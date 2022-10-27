package com.iu.home.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.home.util.Pager;

@Controller
@RequestMapping("/qna/")
public class QnaController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private QnaService qnaService;

	@GetMapping("list")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		pager.getRow();
		List<QnaVO> ar = qnaService.getList(pager);
		mv.addObject("list", ar);
		mv.setViewName("board/list");
		return mv;
	}
	
	@GetMapping("write")
	public String setQna() throws Exception {
		return "board/write";
	}
	
	@PostMapping("write")
	public String setQna(QnaVO qnaVO, RedirectAttributes redirectAttributes) throws Exception {
		int result = qnaService.setQna(qnaVO);
		redirectAttributes.addAttribute("result", result);
		return "redirect:list";
	}
	
	@GetMapping("detail")
	public ModelAndView getQnaDetail(QnaVO qnaVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		qnaVO = qnaService.getQnaDetail(qnaVO);
		mv.addObject("QnaVO", qnaVO);
		mv.setViewName("board/detail");
		
		return mv;
	}
	
	@GetMapping("update")
	public ModelAndView setQnaUpdate(QnaVO qnaVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		qnaVO = qnaService.getQnaDetail(qnaVO);
		mv.addObject("qnaVO", qnaVO);
		mv.setViewName("board/update");
		
		return mv;
	}
	
	@PostMapping("fileDelete")
	@ResponseBody
	public boolean setFileDelete(QnaFileVO qnaFileVO) throws Exception {
		return qnaService.setFileDelete(qnaFileVO);
	}
}
