package com.iu.home.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.board.qna.QnaFileVO;
import com.iu.home.board.qna.QnaService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/fileDown/*")
@Slf4j
public class FileManageController {
	
	@Autowired
	private QnaService qnaService;

	@GetMapping("{path}") // RestFul, RestAPI
	public ModelAndView fileDownQna(@PathVariable String path, QnaFileVO qnaFileVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		qnaFileVO = qnaService.getFileDetail(qnaFileVO);
		
		mv.addObject("fileVO", qnaFileVO);
		mv.addObject("path", path);
		mv.setViewName("fileManager");
		return mv;
	}
}
