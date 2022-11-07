package com.iu.home.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.iu.home.member.MemberSecurityService;
import com.iu.home.member.MemberSocialService;
import com.iu.home.member.security.LoginFail;
import com.iu.home.member.security.LoginSuccess;
import com.iu.home.member.security.LogoutCustom;
import com.iu.home.member.security.LogoutSuccessCustom;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private LoginSuccess loginSuccess;
	@Autowired
	private LoginFail loginFail;
	@Autowired
	private LogoutCustom logoutCustom;
	@Autowired
	private LogoutSuccessCustom logoutSuccessCustom;
	@Autowired
	private MemberSecurityService memberSecurityService;
	@Autowired
	private MemberSocialService memberSocialService;

	//public을 선언하면 default로 바꾸라는 메세지 출력
	@Bean
	WebSecurityCustomizer webSequrityConfig() {
		return web -> web
				.ignoring()
				.antMatchers("/images/**")
				.antMatchers("/css/**")
				.antMatchers("/js/**")
				.antMatchers("/favicon/**")
				.antMatchers("/file/**");
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
					.csrf()
					.disable()
					.cors()
					.configurationSource(this.corsConfigurationSource())
					.and()
				.authorizeHttpRequests()
					.antMatchers("/admin").hasRole("ADMIN")
					.antMatchers("/manager").hasRole("MANAGER")
					.antMatchers("/qna/list").permitAll()
//					.antMatchers("/qna/**").hasRole("MEMBER")
					.anyRequest().permitAll()
					.and()
				.formLogin()
					.loginPage("/member/login")
//					.loginProcessingUrl("login") // 로그인을 진행 요청할 form태그의 action 주소
					// 개발자가 다른 이름으로 파라미터명을 사용할 때 지정
					.usernameParameter("id")
					.passwordParameter("pw")
//					.defaultSuccessUrl("/")
					.successHandler(loginSuccess)
//					.failureUrl("/member/login?error=true&message=LoginFail")
					.failureHandler(loginFail)
					.permitAll()
					.and()
				.logout()
					.logoutUrl("/member/logout")
//					.logoutSuccessUrl("/")
					.logoutSuccessHandler(logoutSuccessCustom)
					.addLogoutHandler(logoutCustom)
					.invalidateHttpSession(true)
					.deleteCookies("JSESSIONID")
					.permitAll()
					.and()
				.rememberMe()
					.rememberMeParameter("rememberMe") // 파라미터 명
					.tokenValiditySeconds(300) // 로그인 유지시간 (초단위)
					.key("rememberMe") // 인증받은 사용자 정보로 Token생성 시 필요 필수값
					.userDetailsService(memberSecurityService) // 인증 절차를 실행할 UserDetailService 필수값
					.authenticationSuccessHandler(loginSuccess) // Login 성공 시 핸들러
					.and()
				.oauth2Login() // 소셜 로그인 설정
					.userInfoEndpoint()
					.userService(memberSocialService)
					;
		
					 
		
		return httpSecurity.build();
	}
	
	// 평문을 암호화시켜주는 클래스
	@Bean
	public PasswordEncoder getEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://192.168.1.34:5500", "*"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}
