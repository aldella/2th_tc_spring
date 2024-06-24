package com.kh.spring.board.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.board.model.service.BoardServiceImp1;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.PageInfo;
import com.kh.spring.board.model.vo.PageTemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {
	
	private final BoardServiceImp1 boardService;
	
	
	/*
	 * deleteById : Client(게시글 작성자)에게 정수형의 boardNo(BOARD테이블의 PK)를 전달 받아서 BOARD 테이블에 존재하는 STATUS 컬럼의 값을 'N'으로 갱신
	 * @param boardNo : 각 행을 식별하기 위한 PK
	 * @param filePath : 요청 처리 성공 시 첨부파일을 제거하기 위해 파일이 저장되어있는 경로 및 파일명
	 * @return : 반환된 View의 논리적인 경로
	 */
	@PostMapping("board-update.do")
	public String update(Board board, MultipartFile reupFile, HttpSession session) {
		if(!reupFile.getOriginalFilename().equals("")) {
			board.setOriginName(reupFile.getOriginalFilename());
			board.setChangeName(saveFile(reupFile, session));
		}
		if( boardService.update(board) > 0 ) {
			session.setAttribute("alertMsg", "수정 성공");
			return "redirect:board-detail?boardNo="+board.getBoardNo();
		} else { 
			session.setAttribute("errorMsg", "게시굴 수정 실패");
			return "common/errorPage";
		}
	}
	
	@PostMapping("boardUpdateForm.do")
	public ModelAndView updateForm(ModelAndView mv, int boardNo) {
		mv.addObject("board", boardService.findById(boardNo));
		mv.setViewName("board/boardUpdate");
		return mv;
	}
	
	@PostMapping("boardDelete.do")
	public String deleteById(int boardNo,
							String filePath,
							HttpSession session,
							Model model) {
		if(boardService.delete(boardNo) > 0) {
			if(!"".equals(filePath)) {
				new File(session.getServletContext().getRealPath(filePath)).delete();
			}
			session.setAttribute("alertMsg", "게시글 삭제 성공");
			return "redirect:boardlist";
		} else {
			model.addAttribute("errorMsg", "게시글 삭제 실패");
			return "common/errorPage";
		}
	}
	
	@GetMapping("board-detail")
	public ModelAndView findById(int boardNo,
								ModelAndView mv) {
		// 1. 데이터 가공 -> 받은 데이터가 한 개라 할 게 없음
		// 2. 서비스 호출
		if (boardService.increaseCount(boardNo) > 0 ) { //조회수 증가에 성공했으면 데이터 불러오기
			//3. 성공시 : 응답화면 지정
			mv.addObject("board", boardService.findById(boardNo)).setViewName("board/boardDetail");
		} else {
			mv.addObject("errorMsg","게시글 상세 조회에 실패했습니다.").setViewName("common/errorPage");
		}
		
		return mv;
	}
	
	@PostMapping("insert.do")
	public String insert(Board board,
						MultipartFile upfile,
						HttpSession session,
						Model model) {
		log.info("board:{}", board);
		log.info("upfild : {}",upfile);
		String originName = "";
		String changeName = "";
		
		if(!upfile.getOriginalFilename().equals("")) {
			/*
			originName = upfile.getOriginalFilename();
			String ext = originName.substring(originName.lastIndexOf("."));
			int num = (int)(Math.random()*1000+1);
			String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String savePath = session.getServletContext().getRealPath("/resources/uploadFiles/");
			changeName = "TH_"+currentTime+"_"+num+ext;
			try {
				upfile.transferTo( new File(savePath + changeName) );
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			*/
			saveFile(upfile, session);
			board.setOriginName(upfile.getOriginalFilename());
			board.setChangeName(saveFile(upfile, session));
			
		}
		if (boardService.insert(board) > 0 ) {
			session.setAttribute("alertMsg", "게시글 작성 완료");
		} else {
			model.addAttribute("errorMsg", "게시글 작성 실패");
			return "common/errorPage";
		}
		
		return "redirect:boardlist";
	}
	
	@GetMapping("boardForm.do")
	public String boardFormForwarding() {
		return "board/insertForm";
	}
	
	@GetMapping("search.do")
	public String search(String condition,
						String keyword,
						@RequestParam(value="page", defaultValue="1") int page,
						Model model) {
		log.info("컨디션{}, 검색키워드{}",condition,keyword);
		
		Map<String, String> map = new HashMap();
		map.put("condition", condition);
		map.put("keyword", keyword);
		
		int searchCount = boardService.searchCount(map);
		int currentPage = page;
		int pageLimit = 3;
		int boardLimit = 3;

		PageInfo pageInfo = PageTemplate.getPageInfo(searchCount, boardLimit, currentPage, pageLimit);
		
		RowBounds rowBounds = new RowBounds( (currentPage-1)*boardLimit , boardLimit);
		
		List<Board> boardList = boardService.findByConditionAndKeyword(map, rowBounds);
		
		model.addAttribute("list",boardList);
		model.addAttribute("pageInfo",pageInfo);
		model.addAttribute("keyword",keyword);
		model.addAttribute("condition",condition);
		
		return "board/list";
	}
	
	
	@GetMapping("boardlist")
	public String forwarding(@RequestParam(defaultValue = "1") int page, Model model) { //맨 첫 번째 페이지는 굳이 써주지 않아도 page 값이 1인걸로
		int listCount; // 현재 게시판의 게시글 총 갯수  -> board 테이블로부터 select count(*)로부터 가져옴
		int currentPage; // 현재 페이지(사용자가 요청한 페이지) -> 앞(jsp)에서 넘길 것
		int pageLimit=10; // 페이지 하단에 보여질 페이지바의 최대 갯수 -> 10개로 고정
		int boardLimit=10; // 한 페이지에 보여질 게시글의 최대 개수 -> 10개로 고정
		
		int maxPage; // 가장 마지막 페이지가 몇 번 페이지인지(총 페이지의 갯수)
		int startPage; // 현재 화면 상 페이지바의 시작 수
		int endPage; // 현재 화면 상 페이지바의 끝 수
		
		// 현재 게시판의 게시글 총 갯수
		listCount = boardService.boardCount();
		
		// 현재 페이지(사용자가 요청한 페이지) -> 앞(jsp)에서 넘길 것
		currentPage = page;
		
		//log.info("게시글의 총 개수 : {}, 현재 요청 페이지 : {}", listCount, currentPage);
		
		// maxPage : 가장 마지막 페이지가 몇 번 페이지인지(총 페이지의 갯수)
		/*
		 * maxPage는 listCount와 boardLimit에 영향을 받음
		 * 공식 구하기 -> 단, boardLimit=10 이라는 가정 하에 규칙찾기
		 * 
		 * 총 갯수(listCount)		게시글 갯수(boardLimit)		maxPage(마지막 페이지)
		 * 100					10							10페이지
		 * 106					10							11페이지
		 * 111					10							12페이지
		 * 
		 * 나눗셈 -> 소수점 -> 올림처리 = maxPage
		 * 
		 * */
		
		maxPage = (int)(Math.ceil((double)listCount/boardLimit));
		
		/* startPage : 페이지 하단에 보여질 페이징바의 시작 수 
		 * currentPage, pageLimit에 영향을 받음
		 * 
		 * 공식 구하기
		 * 	단, pageLimit이 10이라고 가정
		 * 
		 * -startPage의 예시를 보자
		 * (pageLimit=10) : 1, 11, 21, 31, 41, ... -> n*10 + 1
		 * (pageLimit=5) : 1,6,11,16,21,26,... -> n*5 + 1
		 *  즉, startPage = n*pageLimit + 1
		 *  
		 *  n만 구하면 됨
		 *  
		 *  n=0 : 1~10
		 *  n=1 : 11~20
		 *  n=2 : 21~30
		 *  n=3 : 31~40
		 *  n = (현재게시글번호-1)/pageLimit = currentPage
		 *  현재페이지/pageLimit 하면 10페이지여도 의도는 n=0나와야하는데 n=1나와버리니까 걍 현재페이지에서 -1한거
		 * 
		 */
		
		
		startPage = ((currentPage-1)/pageLimit) * pageLimit + 1;
		
		/* endPage : startPage, pageLimit에 영향을 받음. 단, 게시글이 충분하지 않은데 끝이 엄청 많으면 이상하니까 maxPage도 마지막 페이징바에 대해 영향을 끼침
		 * startPage : 1 -> endPage : 10
		 * startPage : 11 -> endPage : 20
		 * startPage : 21 -> endPage : 30
		 * endPage = startPage + pageLimit-1;
		 * 
		 */
		//게시글 갯수가 충분하지 않은데 페이징 수만 많으면 이상하니까 endPage를 maxPage에 맞게 구현
		endPage = startPage + pageLimit-1;
		if(endPage > maxPage) endPage = maxPage;
		
		PageInfo pageInfo = PageInfo.builder()
									.listCount(listCount)
									.currentPage(currentPage)
									.pageLimit(pageLimit)
									.boardLimit(boardLimit)
									.maxPage(maxPage)
									.startPage(startPage)
									.endPage(endPage)
									.build();
		
		/*
		 * 시작값 : (currentPage -1) * boardLimit +1;
		 * 끝값 : 시작값 + boardLimit - 1;
		 */
		
		Map<String, Integer> map = new HashMap();
		int startValue = (currentPage - 1) * boardLimit + 1;
		int endValue = (startValue + boardLimit - 1);
		map.put("startValue",startValue);
		map.put("endValue", endValue);
		
		List<Board> boardList = boardService.findAll(map);
		
		log.info("조회된 게시글 갯수 : {}", boardList.size());
		log.info("조회된 게시글 목록 : {}", boardList);
		
		model.addAttribute("list", boardList);
		model.addAttribute("pageInfo", pageInfo);
		
		return "board/list";
	}
	
	public String saveFile(MultipartFile upfile, HttpSession session) {
		String originName = upfile.getOriginalFilename();
		String ext = (originName.lastIndexOf(".") > -1) ? originName.substring(originName.lastIndexOf(".")) : ""  ;
		int num = (int)(Math.random()*1000+1);
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String savePath = session.getServletContext().getRealPath("/resources/uploadFiles/");
		String changeName = "TH_"+currentTime+"_"+num+ext;
		try {
			upfile.transferTo( new File(savePath + changeName) );
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "resources/uploadFiles/" + changeName;
	}
}