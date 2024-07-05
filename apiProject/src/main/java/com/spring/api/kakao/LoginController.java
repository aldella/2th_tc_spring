package com.spring.api.kakao;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.api.kakao.model.KakaoService;
import com.spring.api.kakao.model.SocialMember;

@Controller
public class LoginController {
	
	@Autowired
	private KakaoService kakaoService;
	
	@GetMapping("/oauth")
	public void socialLogin(HttpSession session, String code) throws IOException, ParseException {
		String accessToken = kakaoService.getToken(code);
		session.setAttribute("accessToken", accessToken);
		
		SocialMember sm = kakaoService.getUserInfo(accessToken);
		session.setAttribute("loginUser", sm);
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) throws IOException {
		kakaoService.logout((String)session.getAttribute("accessToken"));
		return "redirect:login";
	}
}
