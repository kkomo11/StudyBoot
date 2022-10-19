package com.iu.home.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QnaService {

	@Autowired
	private QnaMapper qnaMapper;
	
	public List<QnaVO> getList(Pager pager) throws Exception {
		return qnaMapper.getList(pager);
	}
	
	public int setQna(QnaVO qnaVO) throws Exception {
		
		for(MultipartFile f : qnaVO.getFiles()) {
			if(f.isEmpty()) continue;
			log.info("FileName : {}", f.getOriginalFilename());
		}
		return 1;//qnaMapper.setQna(qnaVO);
	}
}
