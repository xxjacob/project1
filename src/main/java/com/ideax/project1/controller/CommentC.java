package com.ideax.project1.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ideax.common.Util;
import com.ideax.common.exception.EC;
import com.ideax.common.exception.IllegalException;
import com.ideax.project1.common.Result;
import com.ideax.project1.pojo.Comment;
import com.ideax.project1.pojo.Lanmu;
import com.ideax.project1.pojo.News;
import com.ideax.project1.service.BlockService;
import com.ideax.project1.service.CommentService;
import com.ideax.project1.service.NewsService;
import com.ideax.project1.service.PindaoService;

@Controller
public class CommentC {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	NewsService newsService;
	@Autowired
	PindaoService pindaoService;
	@Autowired
	BlockService blockService;
	@Autowired
	CommentService commentService;

	/**
	 * submitComment
	 * 
	 * @return
	 */
	@RequestMapping("/comment/submit")
	public String sendComment(@RequestParam int nid, @RequestParam(required = false, defaultValue = "0") int rid,
			@RequestParam(defaultValue = "") String content, HttpServletRequest request, ModelMap model) {
		try {
			if (StringUtils.isBlank(content) || content.length() > 70) {
				throw new IllegalException(EC.EC_PARAM, "内容为空，或字数大于70个");
			}

			Comment newcomment = new Comment();
			newcomment.setContent(content);
			newcomment.setIp(Util.getClientIpAddr(request));

			commentService.submitComment(newcomment, rid, nid);

		} catch (IllegalException e) {
			model.addAttribute("error_msg", e.getMessage());
		} catch (Exception e) {
			logger.error("", e);
			model.addAttribute("error_msg", "未知错误!");
		}
		return "redirect:/view?id=" + nid;
	}

	@RequestMapping("/replypage")
	public String replyPage(@RequestParam int rid, @RequestParam int nid, HttpServletRequest request, ModelMap model) {
		News news = newsService.getNewsById(nid);
		model.addAttribute("news", news);
		// pindao
		int lmid = news.getLmId();
		Lanmu lm = pindaoService.getLanmuByKey(lmid);
		model.addAttribute("lanmu", lm);
		if (lm != null)
			model.addAttribute("pindao", pindaoService.getPindaoByKey(lm.getPdId()));
		model.addAttribute("rcomment", commentService.getCommentsById(rid));
		return "reply";
	}

	@RequestMapping("/comments")
	public String commentlist(@RequestParam int nid, @RequestParam(required = false, defaultValue = "1") int page,
			HttpServletRequest request, ModelMap model) {
		News news = newsService.getNewsById(nid);
		model.addAttribute("news", news);
		// pindao
		int lmid = news.getLmId();
		Lanmu lm = pindaoService.getLanmuByKey(lmid);
		model.addAttribute("lanmu", lm);
		if (lm != null)
			model.addAttribute("pindao", pindaoService.getPindaoByKey(lm.getPdId()));
		// 评论
		Map<Integer, Comment> requiredRef = new HashMap<Integer, Comment>();
		Result<Comment> rst = commentService.getCommentPageByNewsid(nid, page, 10, requiredRef);
		List<Comment> comments = rst.getList();
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
		model.addAttribute("total", rst.getCount() / 10 + (rst.getCount() % 10 > 0 ? 1 : 0));
		model.addAttribute("page", page);
		model.addAttribute("count", rst.getCount());
		// 导航栏
		model.addAttribute("pdmap", pindaoService.getPindaoMap());
		return "commentlist";
	}
}
