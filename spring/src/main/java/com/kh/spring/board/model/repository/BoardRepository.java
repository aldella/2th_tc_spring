package com.kh.spring.board.model.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.board.model.vo.Board;

@Repository
public class BoardRepository {

	public int boardCount(SqlSessionTemplate sqlSession) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("boardMapper.boardCount");
	}

	public List<Board> findAll(SqlSessionTemplate sqlSession, Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("boardMapper.findAll", map);
	}

	public int searchCount(SqlSessionTemplate sqlSession, Map<String, String> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("boardMapper.searchCount", map);
	}

	public List<Board> findByConditionAndKeyword(SqlSessionTemplate sqlSession, Map<String, String> map,
			RowBounds rowBounds) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("boardMapper.findByConditionAndKeyword", map, rowBounds);
	}

	public int insert(SqlSessionTemplate sqlSession, Board board) {
		// TODO Auto-generated method stub
		return sqlSession.insert("boardMapper.save", board);
	}

	public int increaseCount(SqlSessionTemplate sqlSession, int boardNo) {
		// TODO Auto-generated method stub
		return sqlSession.update("boardMapper.increaseCount", boardNo);
	}
	public Board findById(SqlSessionTemplate sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.findById", boardNo);
	}

	public int delete(SqlSessionTemplate sqlSession, int boardNo) {
		// TODO Auto-generated method stub
		return sqlSession.update("boardMapper.delete",boardNo);
	}

	public int update(SqlSessionTemplate sqlSession, Board board) {
		// TODO Auto-generated method stub
		return sqlSession.update("boardMapper.update", board);
	}
	
	
	
	

}