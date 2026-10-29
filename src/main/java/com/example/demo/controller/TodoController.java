package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Todo;
import com.example.demo.service.TodoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TodoController {
	private final TodoService todoService;
	@GetMapping("/")
	public String index() {
		return "redirect:/todo";
		
	}
	@RequestMapping("/todo")
	public String todoList(Model model) {
		model.addAttribute("todos",todoService.findAll());
		return "index";
	}
	
	@PostMapping("/save-todo")
	public String saveTodo(
			@RequestParam("title")String title,
			@RequestParam("description")String description
			) {
		var todo= new Todo();		
		todo.setTitle(title);
		todo.setDescription(description);
		todo.setCompleted(false);
		todoService.saveTodo(todo);
		return "redirect:/todo";
		
	}
	

}
