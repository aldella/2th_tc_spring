package com.ty.proj.mypage.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	//private final MemberServiceImp1 memberService;
	//private final OrderServiceImp1 orderService;
	

	
	@GetMapping("/orderDetail")
	public String orderDetail(String orderNo, HttpSession session) {
		String returnPage="/member/login";
		System.out.println(orderNo);
		// String userId = ((Member)session.getAttribute("loginUser")).getUserId();
		// String userIdInput = orderService.getOrderByNo(orderNo).getUserId();
		// String returnPage (userId == userIdInput) ?  "/mypage/orderDetail" : "/common/errorPage"
		return returnPage;
	}
	
}
