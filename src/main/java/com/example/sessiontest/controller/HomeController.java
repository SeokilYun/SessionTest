package com.example.sessiontest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class HomeController {
	@GetMapping("")
	public String home() {
		return "index";
	}
	
	@GetMapping("/welcome")
	public String welcome(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("loginUser");
		model.addAttribute("user", userId);
		return "welcome";
	}
}
