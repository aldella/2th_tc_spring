package com.kh.spring.member.model.service;

import com.kh.spring.member.model.vo.Member;

public interface MemberService {
	int returnNum();
	
	//메소드를 어떻게 사용하는지 방법을 기술하는 데 사용.
	//기획 단계에서 모두 마무리되어야함!
	
	// 로그인(SELECT)
	Member login(Member member);
	
	// 회원가입(INSERT)
	int insert(Member member); //값을 몇개 받아오죠? 곤란한데 그냥 Controller에서 가공해서 넘어오죠? <- 이런식으로 회의가능 = 팀이 있는 이유
	
	// 회원 정보 수정(UPDATE)
	int update(Member member);
	
	// 회원 탈퇴(DELETE, UPDATE)
	int delete(String string);
	
	// 아이디 중복체크(SELECT)
	int idCheck(String idCheck);
	
	// 메일인증
}
