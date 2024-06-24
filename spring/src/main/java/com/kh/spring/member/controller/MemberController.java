package com.kh.spring.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.member.model.service.MemberServiceImp1;
import com.kh.spring.member.model.vo.Member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
public class MemberController {
	
	private final MemberServiceImp1 memberService;
	private final HttpServletRequest request;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	/*
	@RequestMapping("login.do")
	public String login(HttpServletRequest request) {
		String userId = request.getParameter("id"); // jsp단에서 받아온 input text요소의 name값이 id
		String userPwd = request.getParameter("pwd"); // jsp단에서 받아온 input text요소의 name값이 pwd
		log.info(userId);
		log.info(userPwd);
		return "main";
	}
	*/
	
	/*
	@RequestMapping("login.do")
	public String login(@RequestParam(value="id") String userId, @RequestParam(value="pwd") String userPwd) {
		log.info(userId);
		log.info(userPwd);
		return "main";
	}*/
	
	/*
	@RequestMapping("login.do")
	public String login(Member member) {
		Member loginMember = memberService.login(member);
		log.info("가져온 멤버 : {}", loginMember);
		return "main";
	}*/
	
	/*
	@RequestMapping("login.do")
	public String login(Member member, Model model, HttpSession session) {
		Member loginUser = memberService.login(member);
		if(loginUser == null) { //로그인에 실패
			model.addAttribute("errorMsg", "로그인실패");
			return "common/errorPage";
		} else {
			session.setAttribute("loginUser", loginUser);
			log.info("session데이터 : {}",session.getAttribute("loginUser"));
		}
		return "redirect:/";
	}
	*/
	
	@PostMapping("login.do")
	public ModelAndView login(Member member, ModelAndView mv, HttpSession session) {
		//member.userPwd = 평문
		
		Member loginUser = memberService.login(member);
		// MEMBER테이블에 사용자가 입력한 userId값이존재하고 STATUS컬럼의 값이 'Y'와 일치한다면
		//loginUser -> 조회된 ResultSet의 컬럼의 값이 필드에 차곡차곡 담긴 Member 객체의 주소값이 담겨있음
		//			-> userPwd필드 : DB에 기록된 암호화된 비밀번호
		//BCryptPasswordEncoder.matches(평문,암호문)
		//암호문에 포함되어있는 Salt값을 판단해서 평문에 Salt값을 더한 후 암호화를 반복하여 두 값이 같은지 비교
		//일치하면 true 아니면 false
		
		if (loginUser!=null && bCryptPasswordEncoder.matches(member.getUserPwd(), loginUser.getUserPwd())) { 
			session.setAttribute("loginUser", loginUser);
			mv.setViewName("redirect:/");
		} else {
			mv.addObject("errorMsg", "로그인 실패");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	@GetMapping("/member/{id}")
	public void restTest(@PathVariable String id) {
		 log.info("앞단에서 넘긴값 : {}",id);
	}
	
	@GetMapping("logout.do")
	public String logout(HttpSession session) {
		//sessionScope에 존재하는 loginUser 제거
		session.removeAttribute("loginUser");
		return "redirect:/";
	}
	
	@GetMapping("enroll.do")
	public String enrollForm() {
		return "member/enrollForm";
	}
	
	@PostMapping("join.do")
	public String memberJoin(Member member, Model model) {
		//1. 데이터 가공
		String encPwd = bCryptPasswordEncoder.encode(member.getUserPwd());
		member.setUserPwd(encPwd);
		int rst = memberService.insert(member);
		String viewName = "";
		
		//2. 응답화면 지정
		if (rst > 0) { 
			viewName="redirect:/";
		} else {
			model.addAttribute("errorMsg","회원가입 실패");
			viewName="common/errorPage";
		}
		return viewName;
	}
	
	@GetMapping("mypage.do")
	public String mypage() {
		return "member/myPage";
	}
	
	@PostMapping("update.do")
	public String update(Member member, HttpSession session, Model model) {
		
		int rst = memberService.update(member);
		String viewName = "";

		if (rst>0) { 
			session.setAttribute("loginUser", memberService.login(member));
			//업데이트 구문 성공시
			viewName = "redirect:mypage.do";
		} else {
			//업데이트 구문 실패시
			viewName = "common/errorPage";
			session.setAttribute("errorMsg", "정보 수정에 실패했습니다.");
		}
		
		return viewName;
	}
	
	@PostMapping("delete.do")
	public String delete(Member member, HttpSession session) {
		
		String plainPwd = member.getUserPwd();
		String encPwd = ((Member)session.getAttribute("loginUser")).getUserPwd();
		
		if(bCryptPasswordEncoder.matches(plainPwd, encPwd)) {
			//성공 시
			if(memberService.delete(member.getUserId())> 0) {
				session.setAttribute("alertMsg", "회원 탈퇴에 성공했습니다.");
				session.removeAttribute("loginUser");
				return "redirect:/";
			} else {
				session.setAttribute("alertMsg", "회원 탈퇴에 실패했습니다.");
				return "common/errorPage";
			}
			
		} else {
			session.setAttribute("alertMsg", "비밀번호가 일치하지 않습니다");
			return "redirect:mypage.do";
		}
	}
	
}