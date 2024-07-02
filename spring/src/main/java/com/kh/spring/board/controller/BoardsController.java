package com.kh.spring.board.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring.board.model.service.BoardServiceImp1;
import com.kh.spring.board.model.vo.Board;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


//이 컨트롤러는 /boards 로 시작하는 요청이 들어오면 처리를 해줄 컨트롤러. @RequestMapping("boards")
//전부 AJAX로 뿌려주기 위해 @RestController 사용
@RequestMapping(value="boards", produces="application/json; charset=utf-8")
@RestController
@RequiredArgsConstructor
@Slf4j
public class BoardsController {

	private final BoardServiceImp1 boardService;
	
	@GetMapping
	public List<Board> findTopFiveBoard() {
		return boardService.findTopFiveBoard();
	}
	
	@GetMapping("/{boardNo}")
	public Board findByBoardNo(@PathVariable int boardNo) {
		return boardService.findById(boardNo);
	}
	
	
}
