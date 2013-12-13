package com.ideax.project1.controller;

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

import com.ideax.common.Util;
import com.ideax.common.exception.IllegalException;
import com.ideax.project1.filter.AdminLoginFilter;
import com.ideax.project1.pojo.Admin;
import com.ideax.project1.pojo.Block;
import com.ideax.project1.pojo.News;
import com.ideax.project1.service.AdminService;
import com.ideax.project1.service.BlockService;
import com.ideax.project1.service.NewsService;

@Controller
@RequestMapping("asdf")
public class AdminC {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BlockService blockService;
    @Autowired
    AdminLoginFilter sessionFilter;
    @Autowired
    NewsService newsService;
    @Autowired
    AdminService adminService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String loginpage() {
        return "admin/login";
    }

    @RequestMapping(value = "dologin", method = RequestMethod.POST)
    public String dologin(@RequestParam String username, @RequestParam String password,
            @RequestParam(defaultValue = "0") int remember, HttpServletResponse response, Model model) {
        String passwordmd5 = Util.md5Encoding(password);
        Admin admin = adminService.verifyUser(username, passwordmd5);
        if (admin != null) {
            sessionFilter.login(admin, response, remember == 1);
            return "redirect:/asdf/main";
        } else {
            model.addAttribute("error", "wrong username/password");
            return "admin/login";
        }
    }

    @RequestMapping("main")
    public String mainpage(HttpServletRequest req, Model model) {
        List<Block> list = blockService.getAllBlocks();
        Map<Integer, Block> page2Blockgroup = new HashMap<Integer, Block>();
        for (Block blk : list) {
            if (page2Blockgroup.get(blk).getPageId() != null) {
                blk.setBlockName(blk.getBlockName().substring(0, blk.getBlockName().lastIndexOf("-")));
                page2Blockgroup.put(blk.getPageId(), blk);
            }
        }
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

}
