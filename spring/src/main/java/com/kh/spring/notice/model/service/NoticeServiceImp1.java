package com.kh.spring.notice.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kh.spring.notice.model.dao.NoticeMapper;
import com.kh.spring.notice.model.vo.Notice;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeServiceImp1 implements NoticeService{

	private final NoticeMapper noticeMapper;
	
	@Override
	public List<Notice> findAll() {
		// TODO Auto-generated method stub
		return noticeMapper.findAll();
	}

	@Override
	public Notice findById(int noticeNo) {
		// TODO Auto-generated method stub
		return noticeMapper.findById(noticeNo);
	}

	@Override
	public int save(Notice notice) {
		return noticeMapper.save(notice);
	}

	@Override
	public int update(Notice notice) {
		// TODO Auto-generated method stub
		return noticeMapper.update(notice);
	}

	@Override
	public int delete(int noticeNo) {
		return noticeMapper.delete(noticeNo);
	}
	

}
