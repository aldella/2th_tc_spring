package com.kh.spring.notice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring.notice.model.service.NoticeService;
import com.kh.spring.notice.model.vo.Message;
import com.kh.spring.notice.model.vo.Notice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {
	private final NoticeService noticeService;

	@PutMapping
	public ResponseEntity<Message> update(@RequestBody Notice notice) {
		log.info("\n notice객체 : {}", notice);
		int result = noticeService.update(notice);
		if(result == 0) {
			return ResponseEntity.status(HttpStatus.OK).body(Message.builder()
																	.message("공지사항 변경 실패")
																	.build());
		}
		Message responseMsg = Message.builder()
									 .data(result)
									 .message("공지사항 변경 성공")
									 .build();
		
		return ResponseEntity.status(HttpStatus.OK).body(responseMsg);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Message> deleteById(@PathVariable int id) {
		int result = noticeService.delete(id);
		
		if(result == 0) {
			return ResponseEntity.status(HttpStatus.OK)
													 .body(Message.builder()
																			  .message("게시글이 존재하지 않음")
																				.build());
		}
		
		Message responseMsg = Message.builder()
																	.message("삭제 성공했습니다.")
																	.data("삭제 성공")
																	.build();
																	
		return ResponseEntity.status(HttpStatus.OK).body(responseMsg);
	}

	@PostMapping
	public ResponseEntity<Message> save(Notice notice) {
		
		int result = noticeService.save(notice);
		if (result == 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.builder().message("추가 실패").build());
		}
		Message responseMsg = Message.builder().message("추가 성공했습니다.").data("추가 성공").build();

		return ResponseEntity.status(HttpStatus.OK).body(responseMsg);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Message> findById(@PathVariable int id) {
		Notice notice = noticeService.findById(id);
		if (notice == null) {
			return ResponseEntity.status(HttpStatus.OK).body(Message.builder().message("조회 결과가 존재하지 않습니다").build());
		}
		Message responseMsg = Message.builder().message("조회 요청에 성공했습니다.").data(notice).build();
		return ResponseEntity.status(HttpStatus.OK).body(responseMsg);
	}

	@GetMapping
	public ResponseEntity<Object> findAll() {
		List<Notice> noticeList = noticeService.findAll();
		log.info("noticeList : {} ", noticeList);
		if (noticeList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Message.builder().message("조회 결과가 없음").build());
		}

		Message responseMsg = Message.builder().data(noticeList).message("조회 성공").build();

		return ResponseEntity.status(HttpStatus.OK).body(responseMsg);
	}
}
