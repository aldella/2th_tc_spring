package com.kh.spring.board.model.vo;

public class PageTemplate {
	public static PageInfo getPageInfo(int searchCount, int boardLimit, int currentPage, int pageLimit) {
		
		int maxPage = (int)(Math.ceil((double)searchCount/boardLimit));
		int startPage = ((currentPage-1)/pageLimit) * pageLimit + 1;
		int endPage = startPage + pageLimit-1;
		if(endPage > maxPage) endPage = maxPage;
		
		return PageInfo.builder()
						.listCount(searchCount)
						.currentPage(currentPage)
						.pageLimit(pageLimit)
						.boardLimit(boardLimit)
						.maxPage(maxPage)
						.startPage(startPage)
						.endPage(endPage)
						.build();
	}
}
