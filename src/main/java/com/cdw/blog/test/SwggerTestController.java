package com.cdw.blog.test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "회원 관리", description = "회원 가입 및 조회 API")
@RestController
@RequestMapping("/api/users")
public class SwggerTestController {

	@Operation(summary = "회원 단건 조회", description = "회원 ID를 통해 특정 유저의 정보를 가져옵니다.")
	@GetMapping("/{id}")
	public ResponseEntity<Object> getUser(@Parameter(description = "조회할 회원의 고유 ID", example = "1") @PathVariable Long id) {
		// 로직 생략
//        		ResponseEntity.ok(new UserResponse(id, "홍길동"));
		return null;
	}
}