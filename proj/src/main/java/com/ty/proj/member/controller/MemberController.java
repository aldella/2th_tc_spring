package com.ty.proj.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
public class MemberController {
	
	@PostMapping("login")
	public String login(String userId, String userPwd) {
		System.out.println(userId+":"+userPwd);
		return null;
	}
}
