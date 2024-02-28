package dev.codeunlu.docker.controller;

import dev.codeunlu.docker.dto.RequestTodo;
import dev.codeunlu.docker.model.Todo;
import dev.codeunlu.docker.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/todos")
public class TodoController {

    private final TodoService todoService;


    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<Todo> saveTodo(@RequestBody RequestTodo request){
        return new ResponseEntity<>(todoService.save(request), HttpStatus.CREATED);
    }
}
