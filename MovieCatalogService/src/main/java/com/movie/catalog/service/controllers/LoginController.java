package com.movie.catalog.service.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@Autowired
	HttpSession session;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {

		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String name) {
		System.out.println(Thread.currentThread().getId());
		System.out.println("1");
		session.setAttribute("usercontext", name);
		System.out.println("2");
		model.put("name", name);

		return "catalog";
	}

}