package com.kh.spring.board.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.kh.spring.board.model.vo.Board;

public interface BoardService {
	
	// 게시글 전체 조회 + 페이징 처리
	
	// 게시글 목록 조회
	List<Board> findAll(Map<String, Integer> map);
	
	// 게시글 검색 기능
	int searchCount(Map<String,String> map);
	
	// 검색 목록 조회
	List<Board> findByConditionAndKeyword(Map<String,String> map, RowBounds rowBounds);
	
	// 게시글 작성
	int insert(Board board);
	
	// 게시글 상세보기 + 조회수 상승
	int increaseCount(int boardNo);
	
	// 게시글 상세조회
	Board findById(int boardNo);
	
	// 게시글 삭제하기
	int delete(int boardNo);
	
	// 게시글 수정하기
	int update(Board board);
	
	int boardCount();
	
	
	
	// --------------------------------------------댓글 관련 (AJAX)
	
	// 1.AJAX를 이용한 댓글 목록 조회 -> 2. MyBatis기술을 이용한 댓글 조회
	
	// 댓글 작성하기
	
	// --------------------------------------------- Top-N
}