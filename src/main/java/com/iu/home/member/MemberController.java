package com.iu.home.member;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member/*")
@Slf4j
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@GetMapping("add")
	public String setMember(@ModelAttribute MemberVO memberVO) throws Exception {
		return "member/add";
	}
	
	@PostMapping("add")
	public ModelAndView setMember(@Valid MemberVO memberVO, BindingResult bindingResult, ModelAndView mv) throws Exception {
		mv.setViewName("redirect:/");
		if(bindingResult.hasErrors()) {
			//검증에 실패하면 회원가입하는 jsp로 foward
			log.info("검증 에러 발생");
			mv.setViewName("member/add");
		}
//		memberService.setMember(memberVO);
		
		return mv;
	}
	
	@GetMapping("login")
	public String getLogin() throws Exception {
		return "member/login";
	}
	
	@PostMapping("login")
	public String getLogin(MemberVO memberVO, HttpSession session) throws Exception {
		 memberService.getLogin(memberVO, session);
		 
		 return "redirect:/";
	}
	
	@GetMapping("logout")
	public String getLogout(HttpSession session) throws Exception {
		session.removeAttribute("member");
		return "redirect:/";
	}
	
	@GetMapping("idCheck")
	@ResponseBody
	public long getIdCheck(MemberVO memberVO) throws Exception {
		return memberService.getIdCheck(memberVO);
	}
	
	@PostMapping("test")
	@ResponseBody
	public MemberVO setTest(MemberVO memberVO, String[] ar) throws Exception {
		log.info("id {}", memberVO.getId());
		log.info("name {}", memberVO.getName());
		for(String s : ar) {
			log.info("ar : {}", s);
	    }
		
		return memberVO;
	}
}