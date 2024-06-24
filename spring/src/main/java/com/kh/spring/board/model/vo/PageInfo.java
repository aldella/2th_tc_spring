package com.kh.spring.board.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PageInfo {
	private int listCount; // 현재 게시판의 게시글 총 갯수  -> board 테이블로부터 select count(*)로부터 가져옴
	private int currentPage; // 현재 페이지(사용자가 요청한 페이지) -> 앞(jsp)에서 넘길 것
	private int pageLimit=10; // 페이지 하단에 보여질 페이지바의 최대 갯수 -> 10개로 고정
	private int boardLimit=10; // 한 페이지에 보여질 게시글의 최대 개수 -> 10개로 고정
	
	private int maxPage; // 가장 마지막 페이지가 몇 번 페이지인지(총 페이지의 갯수)
	private int startPage; // 현재 화면 상 페이지바의 시작 수
	private int endPage; // 현재 화면 상 페이지바의 끝 수
}
