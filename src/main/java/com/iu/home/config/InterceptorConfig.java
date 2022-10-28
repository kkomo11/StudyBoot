package com.iu.home.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.iu.home.interceptors.StudyInterceptor;
import com.iu.home.interceptors.TestInterceptor;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class InterceptorConfig implements WebMvcConfigurer {

	@Autowired // IOC(Inversion Of Control)
	private TestInterceptor testInterceptor;
	
	@Autowired
	private StudyInterceptor studyInterceptor;
	
	@Autowired
	private LocaleChangeInterceptor localeChangeInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		//method chaining
		registry.addInterceptor(testInterceptor)
				.addPathPatterns("/qna/**") // Mapping
				.addPathPatterns("/notice/**")
				.excludePathPatterns("/qna/detail") // excludeMapping
				.excludePathPatterns("/qna/write");
		
		//추가 Interceptor
		registry.addInterceptor(studyInterceptor)
				.addPathPatterns("/qna/**");
		
		registry.addInterceptor(localeChangeInterceptor)
				.addPathPatterns("/**");
		
	}
}