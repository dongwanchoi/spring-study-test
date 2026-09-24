package com.cdw.blog.model;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // 시퀀스, auto_increment

	@Column(nullable = false, length = 30)
	private String userName; // 아이디
	
	@Column(nullable = false, length = 100) //해쉬로 암호화예정
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;

	//@ColumnDefault("'user'")
	@Enumerated(EnumType.STRING)
	private RoleType role;  //enum을 쓰면 도메인을 만들어줄 수있음	//권한

	@CreationTimestamp
	private Timestamp createDate;
}
