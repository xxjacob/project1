package com.ideax.project1.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

	static final int charPerPage = 1000;

	/**
	 * 文章详情
	 */
	@RequestMapping("/view")
	public String view(@RequestParam int id, @RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int r, ModelMap model) {
		News news = newsService.getNewsById(id);
		int len = news.getContent().length();
		int totalPage = len / charPerPage + 1;
		if (page > totalPage)
			page = totalPage;
		if (r == 2)
			news.setContent(news.getContent().substring((page - 1) * 1000));
		else if (totalPage > 1)
			news.setContent(news.getContent().substring((page - 1) * 1000, Math.max(len, page * 1000)));
		model.addAttribute("news", news);
		model.addAttribute("total", totalPage);
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
		model.addAttribute("newestNews", newsService.getNewsList(lmid, 1, 6));
		// 导航栏
		model.addAttribute("pdmap", pindaoService.getPindaoMap());
		return "view";
	}

	@RequestMapping("/oldindex")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		// header pindao
		model.addAttribute("pdmap", pindaoService.getPindaoMap());
		// block info
		model.addAttribute("blocks", blockService.getBlockByBlockGroup(Const.PAGE_INDEX));
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
}
