package com.cdw.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdw.blog.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	/*
	 * crud정도는 이걸로쓰면됨
	 * DAO로 알면됨
	 * 빈으로는 등록이라는건
	 * 스프링 ioc에서 객체를 가지고 있나요? 물어보는 것
	 * 필요한 곳에서 인젝션을 통해서 di를 할 수 있음
	 * 
	 * 자동으로 bean등록됨
	 * @Repository 없어도됨 생략가능
	 */
	
	List<User> findAll();
}
