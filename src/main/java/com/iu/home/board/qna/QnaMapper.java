package com.iu.home.board.qna;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.iu.home.util.Pager;

@Mapper
public interface QnaMapper {

	public List<QnaVO> getList(Pager pager) throws Exception;
	
	public int setQna(QnaVO qnaVO) throws Exception;
}