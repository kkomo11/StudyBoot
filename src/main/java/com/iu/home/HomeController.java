package com.iu.home;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iu.home.board.qna.QnaMapper;
import com.iu.home.board.qna.QnaVO;
import com.iu.home.member.MemberVO;

@Controller
public class HomeController {
	
//	@Value("${my.message.hi}")
	private String message;
	
	@Value("${my.default}")
	private String app;
	
	private final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/admin")
	@ResponseBody
	public String admin() {
		return "Admin Role";
	}
	
	@GetMapping("/manager")
	@ResponseBody
	public String manager() {
		return "Manager Role";
	}
	
	@GetMapping("/user")
	@ResponseBody
	public String member() {
		return "Member Role";
	}
	
	@Autowired
	private QnaMapper qnaMapper;

	@GetMapping("/")
	public String home(HttpSession session) throws Exception {
		Enumeration<String> en = session.getAttributeNames();
		log.info("====================================");
		while(en.hasMoreElements()) {
			String key = en.nextElement();
			log.info("Key {}", key);
		}
		SecurityContextImpl context  = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
		if(context!=null) {			
			log.info("context {}", context);
		}
		log.info("====================================");
		return "index";
	}
}