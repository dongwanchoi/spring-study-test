package com.cdw.blog.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdw.blog.model.RoleType;
import com.cdw.blog.model.User;
import com.cdw.blog.repository.UserRepository;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;

@RestController
public class DummyControllerTest {

	@Autowired // controller 객체가 메모리에 뜰 때 같이 생성해줌 // 즉 의존성주입
	private UserRepository userRepository;

	// Optional 함수 찾아보기
	// get(),orElseGet(),orElseThrow()


	@Transactional // 함수 종료시에 자동 commit 이 됨.
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User requestUser) {
		System.out.println("id : "+id);
		System.out.println("password : "+requestUser.getPassword());
		System.out.println("email : "+requestUser.getEmail());
		
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("수정에 실패하였습니다.");
		});
		user.setPassword(requestUser.getPassword());
		//user.setEmail(requestUser.getEmail());
		
		// userRepository.save(user);
		
		return user;
	}
	
	@Operation(summary ="리스트 조회", description = "전체 조회하기")
	@GetMapping("/dummy/users")
	public List<User> list(){ 
		return userRepository.findAll();
	}
	
	@GetMapping("/dummy/user")
	public List<User> pageList(@PageableDefault(size=2, sort="id", direction = Sort.Direction.DESC) Pageable pageble){
		Page<User> pagingUser = userRepository.findAll(pageble);
		
		if(pagingUser.isLast()) {}
		List<User> users = pagingUser.getContent();
		return users;
	}
	
	
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		User user = userRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("해당 유저 없음. id: " + id);
		});
		return user;
	}

	// http://localhost:8000/blog/dummy/join(요청)
	// http의 body에 username, password, email 데이터를 가지고 요청
	@PostMapping("/dummy/join")
	public String join(User user) {
		System.out.println("getId: " + user.getId());
		System.out.println("username: " + user.getUserName());
		System.out.println("password: " + user.getPassword());
		System.out.println("email: " + user.getEmail());
		System.out.println("getRole: " + user.getRole());
		System.out.println("getCreateDate: " + user.getCreateDate());

		user.setRole(RoleType.USER);

		userRepository.save(user);
		return "회원가입 완료";
	}
}
