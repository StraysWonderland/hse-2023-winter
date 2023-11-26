package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todoList = todoRepository.findAll();
        if (!todoList.isEmpty()) {
            return ResponseEntity.ok(todoList);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/todos/{id}")
	public ResponseEntity<Todo> getTodoById(@PathVariable Integer id){
        Todo todoItem = todoRepository.findById(id).orElse(null);
        if (todoItem != null) {
            return ResponseEntity.ok(todoItem);
        }
        return ResponseEntity.notFound().build();
	}

	@PostMapping("/todos")
	public ResponseEntity<Todo> CreateTodo(@PathVariable String title){
		var item = new Todo();
		item.title = title;
		todoRepository.save(item);
		return ResponseEntity.status(HttpStatus.CREATED).body(item);
	}

	@PutMapping("/todos/{id}/{title}")
	ResponseEntity<Todo> UpdateTodo(@PathVariable Integer id, @PathVariable String title){
        Todo existingItem = todoRepository.findById(id).orElse(null);
        if (existingItem != null) {
            existingItem.title = title;
            todoRepository.save(existingItem);
            return ResponseEntity.status(HttpStatus.OK).body(existingItem);
        }
        return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/todos/{id}")
	ResponseEntity<Todo> DeleteTodo(@PathVariable Integer id){
        Todo item = todoRepository.findById(id).orElse(null);
        if (item != null) {
            todoRepository.delete(item);
            return ResponseEntity.status(HttpStatus.OK).body(item);
        }
        return ResponseEntity.notFound().build();
	}
    
}
