package com.example.sessiontest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.sessiontest.controller.dto.LoginControllerDto;
import com.example.sessiontest.controller.exception.UnAuthorizedException;
import com.example.sessiontest.controller.exception.UserNotFoundException;
import com.example.sessiontest.controller.mapper.LoginControllerMapper;
import com.example.sessiontest.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@Autowired
	LoginControllerMapper loginMapper;

	@GetMapping("")
	public String loginPage(Model model) {
		return "login";
	}
	
	@PostMapping("")
	@ResponseBody
	public String login(@RequestBody LoginControllerDto loginDto, HttpServletRequest request) {
		try {
			boolean result = loginService.CheckLoginInfo(loginMapper.loginControllerDtoToServiceDto(loginDto));
			if (!result) {
				throw new UnAuthorizedException();
			}
		} catch(NullPointerException ex) {
			throw new UserNotFoundException(loginDto.getUserid());
		}
		
		HttpSession session = request.getSession();
		
		session.setAttribute("loginUser", loginDto.getUserid());
		
		return "OK";
	}
}
