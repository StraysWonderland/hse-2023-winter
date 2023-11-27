package com.example.demo;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.ipc.http.HttpSender.Response;

@SpringBootApplication
@RestController
public class DemoApplication {

	public ArrayList<Todo> todoItems = new ArrayList<Todo>();

	// RMM LEVEL 0
	// Swamp of POX apporach to get all todos
	@GetMapping("/getAllTodoItems")
	public ArrayList<Todo> getAllTodoItems(){
		return todoItems;
	}

	// RMM Level 1
	// Create Resource Todo
	//
	//@RequestMapping("/todos/getById/{id}")
	//
	//@RequestMapping("/todos/CreateNewItem")

	// RMM Level 2 
	// Introduce Verbs
	@GetMapping("/todosold")
	public ArrayList<Todo> getAllTodoItemsByVerb(){
		return todoItems;
	}

	


	@GetMapping("/")
	public String hello() {
		return "Hallo, Esslingen!";
	}

	@GetMapping("/hello")
	public String helloAgain() {
		return "Guten Morgen, Esslingen!";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
