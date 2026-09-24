package com.cdw.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

}


/* crud 기본 게시판 구현.
 *  왜 이객체가 필요한지, 
 *  이코드를 다른 곳에 넣으면 어떤 문제가 생기는지
 *  이 클래스가 담당하는 책임은 무엇인지
 *  
 */