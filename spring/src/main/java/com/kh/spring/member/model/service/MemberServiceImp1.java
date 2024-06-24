package com.kh.spring.member.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.kh.spring.member.model.repository.MemberRepository;
import com.kh.spring.member.model.vo.Member;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
// 의사결정코드
public class MemberServiceImp1 implements MemberService {

	private final SqlSessionTemplate sqlSession;
	private final MemberRepository memberRepository;
	
	
	@Override
	public Member login(Member member) {
		//	내가 수행해야하는 SQL문을 호출
		return memberRepository.login(sqlSession, member);
	}

	@Override
	public int insert(Member member) {
		//1. DAO 호출
		//2. 컨트롤러로 결과 반환
		return memberRepository.insert(sqlSession, member);
	}

	@Override
	public int update(Member member) {
		return memberRepository.update(sqlSession, member);
	}

	@Override
	public int delete(String string) {
		return memberRepository.delete(sqlSession, string);
	}

	@Override
	public int returnNum() {
		return 1;
	}

}