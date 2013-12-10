package com.ideax.project1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ideax.project1.common.Const;
import com.ideax.project1.pojo.Comment;
import com.ideax.project1.pojo.News;
import com.ideax.project1.service.BlockService;
import com.ideax.project1.service.CommentService;
import com.ideax.project1.service.NewsService;
import com.ideax.project1.service.PindaoService;

@Controller
public class NewsC {

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
            ModelMap model) {
        News news = newsService.getNewsById(id);
        int len = news.getContent().length();
        int totalPage = len / charPerPage + 1;
        if (page > totalPage)
            page = totalPage;
        if (totalPage > 1)
            news.setContent(news.getContent().substring(0, Math.max(len, page * 1000)));
        model.addAttribute("news", news);
        model.addAttribute("total", totalPage);
        // 评论
        Map<Integer, Comment> requiredRef = new HashMap<Integer, Comment>();
        List<Comment> comments = commentService.getCommentsByNewsid(id, requiredRef);
        model.addAttribute("comments", comments);
        model.addAttribute("refComments", requiredRef);
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
}
