package com.kh.spring.member.model.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.member.model.vo.Member;

@Repository
/* Repository : 저장소
 * 영속성 작업 : DB CRUD 작업(SQL문 실행하고 받아오고 하는것들) (그 외의 것들은 Repository 작업에 절대 들어가면 안됨)
 * 자바의 메모리 라고 하면 RAM 을 의미하는데(휘발성 메모리), 프로그램을 종료하는 순간 그 값까지 같이 사라져버리는것.
 * 그래서 프로그램을 끄더라도 그 데이터가 사라지지 않도록 만들어주는 작업이 영속성 작업이다
 * */
public class MemberRepository {
	public Member login(SqlSessionTemplate sqlSession, Member member) {
		return sqlSession.selectOne("memberMapper.login", member);
	}

	public int insert(SqlSessionTemplate sqlSession, Member member) {
		return sqlSession.insert("memberMapper.join", member);
	}

	public int update(SqlSessionTemplate sqlSession, Member member) {
		// TODO Auto-generated method stub
		return sqlSession.update("memberMapper.update", member);
	}

	public int delete(SqlSessionTemplate sqlSession, String string) {
		// TODO Auto-generated method stub
		return sqlSession.update("memberMapper.delete",string);
	}

	public int idCheck(SqlSessionTemplate sqlSession, String checkId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("memberMapper.idCheck", checkId);
	}
}
