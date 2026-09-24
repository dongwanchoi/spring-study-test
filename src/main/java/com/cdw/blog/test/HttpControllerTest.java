package com.cdw.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
 
@Tag(name ="HTTP 테스트", description = "HTTP 테스트용 API")
@RestController
@RequestMapping("/http")
public class HttpControllerTest {

	@Operation(summary = "HTTP GetMapping", description = "Get방식으로 HTTP 접근 연습")
	@GetMapping("/get")
	public String getTest(@RequestParam int id, @RequestParam String userName) {
		return "get:"+id+userName;
	}
	
	@Operation(summary = "HTTP GetMapping", description = "Get방식으로 HTTP 접근 연습")
	@GetMapping("/get2")
	public String getTest2(Member m) {
		return "get:"+m;
	}
	
	@Operation(summary = "HTTP PostMapping", description = "Post방식으로 HTTP 접근 연습")
	@PostMapping("/post")
	public String postTest(Member m) {
		return "post: "+m;
	}
	@Operation(summary = "HTTP PutMapping", description ="Put 방식으로 HTTP 접근 연습")
	@PutMapping("/put")
	public String putTest(@RequestBody Member m) {
		return "put"+m;
	}
	@Operation(summary = "HTTP DelteMapping", description = "Delete 방식으로 HTTP 접근 연습")
	@DeleteMapping("/delete")
	public String deleteTest() {
		return "delete";
	}
	
}
