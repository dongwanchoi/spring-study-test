package com.cdw.blog.service;

import org.springframework.stereotype.Service;

import com.cdw.blog.model.Board;
import com.cdw.blog.repository.UserRepository;

@Service
public class BoardServiece {

	private UserRepository boardRepository;
	
	public void save(Board board) {
//		boardRepository.save(board);
	}
	
}
