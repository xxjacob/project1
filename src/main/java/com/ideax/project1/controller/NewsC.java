package com.ideax.project1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ideax.project1.service.NewsService;
import com.ideax.project1.service.PindaoService;

@Controller
public class NewsC {

	@Autowired
	NewsService newsService;
	@Autowired
	PindaoService pindaoService;

	@RequestMapping("")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		model.addAttribute("pdmap", pindaoService.getPindaoMap());
		return "index";
	}
}
