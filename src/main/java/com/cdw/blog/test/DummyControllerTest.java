package com.cdw.blog.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdw.blog.model.RoleType;
import com.cdw.blog.model.User;
import com.cdw.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {

	@Autowired // controller 객체가 메모리에 뜰 때 같이 생성해줌 // 즉 의존성주입
	private UserRepository userRepository;

	// Optional 함수 찾아보기
	// get(),orElseGet(),orElseThrow()

	@GetMapping("/dummmy/user/{id}")
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
