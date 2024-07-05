package com.ty.proj.mypage.model.vo;

import com.ty.proj.member.model.vo.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentPerbook {
	private int orderNo;
	private int bookNo;
	private int orderQuan;
}
