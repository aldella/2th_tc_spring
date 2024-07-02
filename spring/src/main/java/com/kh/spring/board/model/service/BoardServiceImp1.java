package com.kh.spring.board.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.kh.spring.board.model.repository.BoardRepository;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.Reply;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImp1 implements BoardService{
	
	private final BoardRepository boardRepository;
	private final SqlSessionTemplate sqlSession;
	
	@Override
	public List<Board> findAll(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return boardRepository.findAll(sqlSession, map);
	}

	@Override
	public int searchCount(Map<String,String> map) {
		// TODO Auto-generated method stub
		return boardRepository.searchCount(sqlSession, map);
	}

	@Override
	public List<Board> findByConditionAndKeyword(Map<String,String> map, RowBounds rowBounds) {
		return boardRepository.findByConditionAndKeyword(sqlSession, map, rowBounds);
	}

	@Override
	public int insert(Board board) {
		// TODO Auto-generated method stub
		return boardRepository.insert(sqlSession, board);
	}

	@Override
	public int increaseCount(int boardNo) {
		// TODO Auto-generated method stub
		return boardRepository.increaseCount(sqlSession, boardNo);
	}

	@Override
	public Board findById(int boardNo) {
		// TODO Auto-generated method stub
		return boardRepository.findById(sqlSession, boardNo);
	}

	@Override
	public int delete(int boardNo) {
		// TODO Auto-generated method stub
		return boardRepository.delete(sqlSession, boardNo);
	}

	@Override
	public int update(Board board) {
		// TODO Auto-generated method stub
		return boardRepository.update(sqlSession, board);
	}

	@Override
	public int boardCount() {
		// TODO Auto-generated method stub
		return boardRepository.boardCount(sqlSession);
	}
	
	@Override
	public List<Board> selectImages() {
		return boardRepository.selectImages(sqlSession);
	}
	public String selectTest() {
		// TODO Auto-generated method stub
		return boardRepository.selectTest(sqlSession);
	}
	@Override
	public List<Reply> selectReply(int boardNo) {
		// TODO Auto-generated method stub
		return boardRepository.selectReply(sqlSession, boardNo);
	}
	@Override
	public int insertReply(Reply reply) {
		return boardRepository.insertReply(sqlSession, reply);
		// TODO Auto-generated method stub
	}
	@Override
	public Board boardAndReply(int boardNo) {
		return boardRepository.boardAndReply(sqlSession, boardNo);
		// TODO Auto-generated method stub
	}

	@Override
	public List<Board> findTopFiveBoard() {
		// TODO Auto-generated method stub
		return boardRepository.findTopFiveBoard(sqlSession);
	}
	
	

}
