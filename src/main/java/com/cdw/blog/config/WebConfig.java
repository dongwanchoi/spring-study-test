//package com.cdw.blog.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**") // 서버의 모든 엔드포인트(/api/** 등)에 대해
//				.allowedOrigins("http://localhost:3000") // 리액트 개발 서버 주소 허용
//				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 허용할 HTTP Method
//				.allowCredentials(true); // 쿠키나 인증 정보 전송을 허용할 경우 (필요시)
//	}
//}