package com.ideax.project1.controller;

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
import com.ideax.project1.pojo.Comment;
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
        return "redirect:/view?id" + nid;
    }
}
