package com.ideax.project1.controller;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ideax.common.exception.IllegalException;
import com.ideax.project1.common.Const;
import com.ideax.project1.pojo.Comment;
import com.ideax.project1.pojo.Lanmu;
import com.ideax.project1.pojo.News;
import com.ideax.project1.service.BlockService;
import com.ideax.project1.service.CommentService;
import com.ideax.project1.service.NewsService;
import com.ideax.project1.service.PindaoService;
import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndContentImpl;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndEntryImpl;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.feed.synd.SyndFeedImpl;
import com.rometools.rome.io.SyndFeedOutput;

@Controller
public class NewsC {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	NewsService newsService;
	@Autowired
	PindaoService pindaoService;
	@Autowired
	BlockService blockService;
	@Autowired
	CommentService commentService;
	@Value("${img.upload.path}")
	String staticPath;
	static final int charPerPage = 1000;

	static final String breakline = "<p>--------------------------------分页符--------------------------------</p>";

	/**
	 * 文章详情
	 */
	@RequestMapping("/view")
	public String view(@RequestParam int id, @RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int r, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		News news = newsService.getNewsById(id);
		int currentPage = 0;
		int pagefrom = 0, pageto = 0;
		StringBuilder realContent = new StringBuilder();
		String content = news.getContent();
		do {
			currentPage += 1;
			pagefrom = pageto == 0 ? 0 : (pageto + breakline.length());
			int pos = content.indexOf(breakline, pagefrom);
			if (pos != -1) {
				pageto = pos;
			} else {
				pageto = content.length();
			}
			if (r == 2) {
				if (currentPage > page)
					realContent.append(content.substring(pagefrom, pageto));
			} else if (currentPage == page)
				realContent.append(content.substring(pagefrom, pageto));

			if (pos == -1)
				break;

		} while (true);
		if (page > currentPage)
			realContent.append(content.substring(pagefrom, pageto));
		news.setContent(realContent.toString());
		model.addAttribute("news", news);
		model.addAttribute("total", currentPage);
		model.addAttribute("page", page);
		model.addAttribute("r", r);
		// pindao
		int lmid = news.getLmId();
		Lanmu lm = pindaoService.getLanmuByKey(lmid);
		model.addAttribute("lanmu", lm);
		if (lm != null)
			model.addAttribute("pindao", pindaoService.getPindaoByKey(lm.getPdId()));
		// blocks
		model.addAttribute("blocks", blockService.getAllBlocksByPageid(Const.PAGE_VIEW_NEWS));
		// 评论
		Map<Integer, Comment> requiredRef = new HashMap<Integer, Comment>();
		List<Comment> comments = commentService.getCommentsByNewsid(id, 1, 10, requiredRef);
		model.addAttribute("comments", comments);
		List<int[]> refIds = new ArrayList<int[]>(comments.size());
		for (Comment c : comments) {
			if (StringUtils.isBlank(c.getReplyTo()))
				refIds.add(null);
			else {
				String[] sss = c.getReplyTo().split(",");
				int[] iss = new int[sss.length];
				for (int i = 0; i < sss.length; i++)
					iss[i] = Integer.valueOf(sss[i]);
				refIds.add(iss);
			}
		}
		model.addAttribute("refIds", refIds);
		model.addAttribute("refComments", requiredRef);
		// 最新消息
		model.addAttribute("newestNews", newsService.getNewsList(1, 6));
		// 导航栏
		model.addAttribute("pdmap", pindaoService.getPindaoMap());

		// 点击排名
		model.addAttribute("hot", newsService.getNewsListByViewcount(0, 1, 5));

		// 增加访问量
		News update = new News();
		update.setId(news.getId());
		update.setViewCount(news.getViewCount() + 1);
		newsService.updateNewsById(update);
		//
		model.addAttribute("hmtPixel", _HMT.getTongjiUrl(request, response));
		System.out.println(model.get("hmtPixel"));
		return "view";
	}

	@RequestMapping("")
	public String staticindex(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		model.addAttribute("cachedIndexBody", NewsService.cachedIndexBody);
		model.addAttribute("hmtPixel", _HMT.getTongjiUrl(request, response));
		return "staticindex";
	}

	@RequestMapping("/oldindex")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		// header pindao
		model.addAttribute("pdmap", pindaoService.getPindaoMap());
		// block info
		model.addAttribute("blocks", blockService.getAllBlocksByPageid(Const.PAGE_INDEX));
		return "index";
	}

	@RequestMapping("/vote")
	@ResponseBody
	public String vote(@RequestParam String cmt_num, @RequestParam int nid) {
		try {
			News news = newsService.getNewsById(nid);
			News update = new News();
			update.setId(news.getId());
			if ("lv1".equals(cmt_num)) {
				update.setCmtNumLv1(news.getCmtNumLv1() + 1);
			} else if ("lv2".equals(cmt_num)) {
				update.setCmtNumLv2(news.getCmtNumLv2() + 1);
			} else if ("lv3".equals(cmt_num)) {
				update.setCmtNumLv3(news.getCmtNumLv3() + 1);
			} else if ("lv4".equals(cmt_num)) {
				update.setCmtNumLv4(news.getCmtNumLv4() + 1);
			} else if ("lv5".equals(cmt_num)) {
				update.setCmtNumLv5(news.getCmtNumLv5() + 1);
			}
			update.setCmtNum(news.getCmtNum() + 1);
			newsService.updateNewsById(update);
		} catch (IllegalException e) {
			logger.error("", e);
			return "FAIL";
		} catch (Exception e) {
			logger.error("", e);
			return "FAIL";
		}
		return "OK";
	}

	@RequestMapping("/rss")
	public void rss(HttpServletResponse response) {
		try {

			SyndFeed feed = new SyndFeedImpl();
			feed.setEncoding("UTF-8");
			feed.setFeedType("rss_2.0");
			feed.setTitle("zhanguojs");
			feed.setLink("http://3g.zhanguojs.com");
			feed.setDescription("zhanguojs");

			List<News> newsss = new ArrayList<News>();
			for (int id : new int[] { 1, 2, 3, 4 }) {
				List<News> newss = newsService.getLanmuNewsList(id, 1, 10);
				newsss.addAll(newss);
			}

			Collections.sort(newsss, new Comparator<News>() {
				@Override
				public int compare(News o1, News o2) {
					return o2.getCreateTime() - o1.getCreateTime();
				}

			});

			List<SyndEntry> entries = new ArrayList<SyndEntry>();

			for (News news : newsss) {
				SyndEntry entry;
				SyndContent description;
				entry = new SyndEntryImpl();
				entry.setTitle(news.getTitle());
				entry.setLink("http://3g.zhanguojs.com/view?id=" + news.getId());
				entry.setPublishedDate(new Date(news.getCreateTime() * 1000L));
				description = new SyndContentImpl();
				description.setType("text/html");
				description.setValue(news.getContent());
				entry.setDescription(description);
				entries.add(entry);
				feed.setEntries(entries);
			}

			response.setContentType("text/xml; charset=UTF-8");

			Writer writer = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "UTF-8"));
			SyndFeedOutput output = new SyndFeedOutput();
			output.output(feed, writer);
			writer.flush();
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}

	@ExceptionHandler(Throwable.class)
	String exHanlder(Throwable e) {
		if (RuntimeException.class.isAssignableFrom(e.getClass()))
			return "404";
		return "500";
	}
}
