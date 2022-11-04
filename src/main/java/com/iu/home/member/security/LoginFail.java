package com.iu.home.member.security;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginFail implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.info("========= Login Fail ============");
		log.info("LocalMessage {}", exception.getLocalizedMessage());
		log.info("Cause {}", exception.getClass());
		log.info("Message {}", exception.getMessage());
//		String name = exception.getClass().toString();
//		name = name.substring(name.lastIndexOf("."));
//		if(name.equals(".BadCredentialsException")) {
//			name="비번 틀림";
//		}
//		name = URLEncoder.encode(name, "UTF-8");
//		response.sendRedirect("/member/login?error=true&message="+name);
		// 참조변수명 instanceof 클래스명
		// 위와 같은 코드
		String result=null;
		if(exception instanceof BadCredentialsException) {
			result="비번 틀림";
		} else if(exception instanceof InternalAuthenticationServiceException) {
			result="없는 아이디";
		} else {
			result="로그인 실패";
		}
//		result = URLEncoder.encode(result, "UTF-8");
//		response.sendRedirect("/member/login?error=true&message="+result);
//		request.setAttribute("msg", result);
		// JSP를 바로 찾아감
//		request.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(request, response);
		// Post 방식
		request.getRequestDispatcher("member/login").forward(request, response);

	}

}
