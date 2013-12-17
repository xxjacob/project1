package com.ideax.project1.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ideax.project1.common.Const;
import com.ideax.project1.common.Result;
import com.ideax.project1.pojo.Lanmu;
import com.ideax.project1.pojo.News;
import com.ideax.project1.pojo.Pindao;
import com.ideax.project1.service.BlockService;
import com.ideax.project1.service.CommentService;
import com.ideax.project1.service.NewsService;
import com.ideax.project1.service.PindaoService;

@Controller
public class PindaoC {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	NewsService newsService;
	@Autowired
	PindaoService pindaoService;
	@Autowired
	BlockService blockService;
	@Autowired
	CommentService commentService;

	@RequestMapping("/pd")
	public String pindaopage(@RequestParam int id, ModelMap model) {
		// pindao
		Pindao pd = pindaoService.getPindaoByKey(id);
		model.addAttribute("pindao", pd);
		List<Lanmu> lanmus = pindaoService.getLanmusByPdid(pd.getId());
		model.addAttribute("lanmus", lanmus);
		// blocks
		model.addAttribute("blocks", blockService.getAllBlocksByPageidAndPdid(Const.PAGE_PINDAO, pd.getId()));
		// lanmu news
		List<List<News>> newsss = new ArrayList<List<News>>(lanmus.size());
		for (Lanmu lm : lanmus) {
			List<News> newss = newsService.getLanmuNewsList(lm.getId(), 1, 5);
			newsss.add(newss);
		}
		model.addAttribute("newsss", newsss);
		// 导航栏
		model.addAttribute("pdmap", pindaoService.getPindaoMap());
		return "pd";
	}

	final int LANMU_NEWS_SIZE = 20;

	@RequestMapping("/lm")
	public String lanmupage(@RequestParam int id, @RequestParam(required = false, defaultValue = "1") int page,
			ModelMap model) {
		// pindao
		Lanmu lm = pindaoService.getLanmuByKey(id);
		model.addAttribute("lanmu", lm);
		Pindao pd = pindaoService.getPindaoByKey(lm.getPdId());
		model.addAttribute("pindao", pd);
		// blocks
		model.addAttribute("blocks", blockService.getAllBlocksByPageid(Const.PAGE_LANMU));
		// lanmu news
		Result<News> rst = newsService.getLanmuNewsListWithPage(lm.getPdId(), lm.getId(), page, LANMU_NEWS_SIZE);
		model.addAttribute("newss", rst.getList());
		model.addAttribute("total", rst.getCount() / LANMU_NEWS_SIZE + (rst.getCount() % LANMU_NEWS_SIZE == 0 ? 0 : 1));
		model.addAttribute("page", page);
		// 点击排行
		List<News> hotlist = newsService.getNewsListByViewcount(pd.getId(), page, 5);
		model.addAttribute("hotlist", hotlist);
		// 导航栏
		model.addAttribute("pdmap", pindaoService.getPindaoMap());
		return "lm";
	}
}
