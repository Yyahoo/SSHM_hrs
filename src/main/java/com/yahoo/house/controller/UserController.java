package com.yahoo.house.controller;

import java.awt.image.BufferedImage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yahoo.house.domain.User;
import com.yahoo.house.dto.CheckResult;
import com.yahoo.house.dto.UserLoginDto;
import com.yahoo.house.service.UserService;
import com.yahoo.house.util.CommonUtil;

@Controller
public class UserController {
    
	private static final int CODE_LENGTH = 4;
	@Autowired
	private UserService userService;
    
	@GetMapping("/check")
	@ResponseBody
	public CheckResult checkUsername(String username) {
		boolean valid = userService.checkUnique(username);
		return new CheckResult(username, valid, valid ? "用户名可用" : "用户名已被占用", valid ? "ok.png" : "no.png");

	}

	@PostMapping("/login")
	public String loginmsg(@Valid UserLoginDto user, Errors errors, Model model, HttpServletRequest req) {
		String viewName = "login";

		if (user.getCode().equalsIgnoreCase((String) req.getSession().getAttribute("code"))) {
			if (!errors.hasErrors()) {
				user.setIpAddress(req.getRemoteAddr());
				if (userService.login(user)) {
					req.getSession().setAttribute("userRealname", user.getRealname());
					req.getSession().setAttribute("userid", user.getId());
					viewName = "redirect:home";
				} else {
					model.addAttribute("hint", "用户名或密码错误");
				}
			} else {
				model.addAttribute("hint", "请输入有效的登录信息");
			}
		} else {
			model.addAttribute("hint", "请输入正确的验证码");
		}
		return viewName;
	}

	@PostMapping("/reg")
	public String registmsg(@Valid User user, Model model, Errors error, HttpSession session, String code) {
		String viewName = "register";
	
		if (code.equalsIgnoreCase((String)session.getAttribute("code"))) {
			if (!error.hasErrors()){
				if (userService.register(user)) 
					viewName = "redirect:toLogin";
			   }else {
				model.addAttribute("hint", "请输入有效的注册信息");
			}
		} else {
			model.addAttribute("hint", "请输入正确的验证码");
		}
		return viewName;
	}

	@GetMapping(value = "/code", produces = "image/png")
	@ResponseBody
	public BufferedImage getCode(HttpSession session) throws Exception {
		String code = CommonUtil.generateCode(CODE_LENGTH);
		session.setAttribute("code", code);
		return CommonUtil.generateCodeImage(code, 80, 30);
	}

}
