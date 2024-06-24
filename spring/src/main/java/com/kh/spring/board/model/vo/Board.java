package com.kh.spring.board.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Board {

		private int boardNo;
		private String boardTitle;
		private String boardWriter;
		private String boardContent;
		private String originName; //파일 업로드 이름
		private String changeName; //파일 바꿨을 때 이름
		private int count;
		private String createDate;
		private String status;
		
}