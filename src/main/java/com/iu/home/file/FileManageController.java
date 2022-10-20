package com.iu.home.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.board.qna.QnaFileVO;

@Controller
@RequestMapping("/fileDown/*")
public class FileManageController {

	@GetMapping("qna")
	public ModelAndView fileDown(QnaFileVO qnaFileVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		qnaFileVO.setFileName("0ec2d593-8c67-41da-857c-834ffe3955d2_iu2.jpg");
		qnaFileVO.setOriName("iu2.jpg");
		
		mv.addObject("fileVO", qnaFileVO);
		mv.setViewName("fileManager");
		return mv;
	}
}
