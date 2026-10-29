package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.TodoDao;
import com.example.demo.entity.Todo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {
	private final TodoDao todoDao;
	public List<Todo> findAll(){
		return todoDao.findAll();
		
	}
	public void saveTodo(Todo todo) {
		todoDao.save(todo);
	}
	
	

}
