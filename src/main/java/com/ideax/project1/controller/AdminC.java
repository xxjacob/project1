package com.ideax.project1.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ideax.common.KVStore;
import com.ideax.common.Util;
import com.ideax.common.exception.IllegalException;
import com.ideax.project1.common.Result;
import com.ideax.project1.filter.AdminLoginFilter;
import com.ideax.project1.pojo.Admin;
import com.ideax.project1.pojo.Block;
import com.ideax.project1.pojo.Comment;
import com.ideax.project1.pojo.Lanmu;
import com.ideax.project1.pojo.News;
import com.ideax.project1.pojo.Pindao;
import com.ideax.project1.service.AdminService;
import com.ideax.project1.service.BlockService;
import com.ideax.project1.service.CommentService;
import com.ideax.project1.service.NewsService;
import com.ideax.project1.service.PindaoService;

@Controller
@RequestMapping("asdf")
public class AdminC {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BlockService blockService;
	@Autowired
	NewsService newsService;
	@Autowired
	AdminService adminService;
	@Autowired
	PindaoService pindaoService;
	@Autowired
	CommentService commentService;
	@Autowired
	KVStore kvStore;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String loginpage() {
		return "admin/login";
	}

	@RequestMapping(value = "clean", method = RequestMethod.GET)
	@ResponseBody
	public String clean() {
		kvStore.clear();
		return "OK";
	}

	@RequestMapping(value = "dologin", method = RequestMethod.POST)
	public String dologin(@RequestParam String username, @RequestParam String password,
			@RequestParam(defaultValue = "0") int remember, HttpServletResponse response, Model model) {
		String passwordmd5 = Util.md5Encoding(password);
		Admin admin = adminService.verifyUser(username, passwordmd5);
		if (admin != null) {
			AdminLoginFilter.login(admin, response, remember == 1);
			return "redirect:/asdf/main";
		} else {
			model.addAttribute("error", "wrong username/password");
			return "admin/login";
		}
	}

	@RequestMapping("main")
	public String mainpage(HttpServletRequest req, Model model) {
		List<Block> list = blockService.getAllBlocks();
		Map<Integer, Map<Integer, Block>> page2Blockgroup = new HashMap<Integer, Map<Integer, Block>>();
		for (Block blk : list) {
			Map<Integer, Block> li = null;
			if ((li = page2Blockgroup.get(blk.getPageId())) == null) {
				li = new HashMap<Integer, Block>();
				page2Blockgroup.put(blk.getPageId(), li);
			}
			if (li.get(blk.getBlockGroup()) == null)
				li.put(blk.getBlockGroup(), blk);
		}
		model.addAttribute("blockgroups", page2Blockgroup);
		Map<Integer, Pindao> a = pindaoService.getPindaoKeyMap();
		model.addAttribute("pindaoMap", a);
		return "admin/main";
	}

	@RequestMapping("block/setting")
	public String blockSettingPage(@RequestParam int blockgroup, HttpServletRequest req, Model model) {
		try {
			List<Block> list = blockService.getBlockByBlockGroup(blockgroup);
			Collections.sort(list, new Comparator<Block>() {
				public int compare(Block o1, Block o2) {
					return o1.getOrderNum() - o2.getOrderNum();
				}
			});
			model.addAttribute("blockgroup", list);
		} catch (IllegalException e) {
			logger.error(e.getMessage());
		}
		return "admin/block";
	}

	@RequestMapping("block/update")
	public String updateBlock(@RequestParam int blockgroup, HttpServletRequest req) {
		try {
			List<Block> list = blockService.getBlockByBlockGroup(blockgroup);
			Set<Integer> pageIds = new HashSet<Integer>();
			for (Block blk : list) {
				String url = req.getParameter("url_" + blk.getId());
				if (url != null)
					blk.setUrl(url);
				String title = req.getParameter("title_" + blk.getId());
				if (title != null)
					blk.setTitle(title);
				String html = req.getParameter("html_" + blk.getId());
				if (html != null)
					blk.setHtml(html);
				String type = req.getParameter("type_" + blk.getId());
				if (url != null)
					blk.setType(Byte.valueOf(type));
				String is_bold = req.getParameter("is_bold_" + blk.getId());
				if (is_bold != null)
					blk.setIsBold(Byte.valueOf(is_bold));
				String news_id = req.getParameter("news_id_" + blk.getId());
				if (news_id != null) {
					if (StringUtils.isBlank(news_id))
						blk.setNewsId(0);
					else
						blk.setNewsId(Integer.valueOf(news_id));
				}
				String img = req.getParameter("img_" + blk.getId());
				if (img != null)
					blk.setImg(img);
				pageIds.add(blk.getPageId());
				blockService.updateBlock(blk);
			}
			for (Integer pageId : pageIds)
				blockService.generateHtml(pageId);
		} catch (IllegalException e) {
			logger.error(e.getMessage());
		} catch (Exception e) {
			logger.error("", e);
		}
		return "redirect:/asdf/block/setting?metion=success&blockgroup=" + blockgroup;
	}

	@RequestMapping("news/jsoninfo")
	@ResponseBody
	public Object newsJson(@RequestParam int id) {
		News n = newsService.getNewsById(id);
		return n;
	}

	@RequestMapping("news/updatepage")
	public String updatepage(@RequestParam(defaultValue = "0") int id, HttpServletRequest req,
			@RequestParam(defaultValue = "") String info, Model model) {
		Map<Pindao, List<Lanmu>> s = pindaoService.getPindaoMap();
		model.addAttribute("pdmap", s);
		if (id > 0) {
			News n = newsService.getNewsById(id);
			model.addAttribute("news", n);
		}
		if ("success".equals(info)) {
			model.addAttribute("info", "编辑成功");
		}

		return "admin/news";
	}

	@RequestMapping("news/update")
	public String updatepage(News news, @RequestParam String formatSendTime, HttpServletRequest req, Model model) {
		int id = 0;
		if (StringUtils.isNotBlank(formatSendTime)) {
			try {
				news.setSendTime((int) (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(formatSendTime).getTime() / 1000L));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			news.setSendTime((int) (System.currentTimeMillis() / 1000L));
		}
		if (news.getId() != null && news.getId() > 0) {
			newsService.updateNewsById(news);
			id = news.getId();
		} else
			id = newsService.insertNews(news);
		return "redirect:/asdf/news/updatepage?info=success&id=" + id;
	}

	final int NESLISTSIZE = 20;

	@RequestMapping("news/list")
	public String list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "0") int pdId,
			@RequestParam(defaultValue = "0") int lmId, @RequestParam(defaultValue = "") String info,
			@RequestParam(defaultValue = "0") int id, Model model) {

		if (id > 0) {
			News n = newsService.getNewsById(id);
			List<News> list = new ArrayList<News>(1);
			if (n != null)
				list.add(n);
			model.addAttribute("total", 1);
			model.addAttribute("page", 1);
			model.addAttribute("newslist", list);
			model.addAttribute("id", id);
		} else {
			Result<News> rst = newsService.getLanmuNewsListWithPage(pdId, lmId, page, NESLISTSIZE);
			model.addAttribute("total", rst.getCount() / NESLISTSIZE + (rst.getCount() % NESLISTSIZE == 0 ? 0 : 1));
			model.addAttribute("page", page);
			model.addAttribute("newslist", rst.getList());
		}
		model.addAttribute("pdId", pdId);
		model.addAttribute("lmId", lmId);
		Map<Pindao, List<Lanmu>> s = pindaoService.getPindaoMap();
		model.addAttribute("pdmap", s);
		if ("success".equals(info)) {
			model.addAttribute("info", "操作成功");
		}
		return "admin/newslist";
	}

	final int COMMENTSSIZE = 20;

	@RequestMapping("comment/list")
	public String commentsList(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "-1") byte auditStatus, Model model) {
		Result<Comment> rst = commentService.getCommentPageByAuditStatus(page, COMMENTSSIZE, auditStatus);
		model.addAttribute("total", rst.getCount() / COMMENTSSIZE + (rst.getCount() % COMMENTSSIZE == 0 ? 0 : 1));
		model.addAttribute("page", page);
		model.addAttribute("commentslist", rst.getList());
		Map<Pindao, List<Lanmu>> s = pindaoService.getPindaoMap();
		model.addAttribute("pdmap", s);
		model.addAttribute("auditStatus", auditStatus);
		return "admin/commentlist";
	}

	/**
	 * 
	 * @param id
	 * @param audit
	 *            1通过 2不通过
	 * @param model
	 * @return
	 */
	@RequestMapping("comment/audit")
	public String commentAudit(@RequestParam int id, @RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "-1") byte auditStatus, @RequestParam(defaultValue = "1") byte audit,
			Model model) {
		Comment update = new Comment();
		if (audit == (byte) 1) {
			update.setId(id);
			update.setAuditStatus(audit);
			commentService.updateComment(update);
		}
		return "redirect:/asdf/comment/list?page=" + page + "&auditStatus=" + auditStatus;
	}

	@RequestMapping("news/delete")
	public String newsDelete(@RequestParam int id) {
		if (newsService.deleteById(id) > 0)
			return "redirect:/asdf/news/list?info=success";
		return "redirect:/asdf/news/list";
	}
}
