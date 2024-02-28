package dev.codeunlu.docker.controller;

import dev.codeunlu.docker.dto.BaseResponse;
import dev.codeunlu.docker.dto.RequestTodo;
import dev.codeunlu.docker.dto.TodoDto;
import dev.codeunlu.docker.model.Todo;
import dev.codeunlu.docker.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/todos")
public class TodoController {

    private final TodoService todoService;


    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<BaseResponse<List<TodoDto>>> findAll(){
        return ResponseEntity.ok(BaseResponse.success(todoService.findAll(), "Tüm kayıtlar başarıyla çekildi."));
    }

    @PostMapping
    public ResponseEntity<BaseResponse<TodoDto>> saveTodo(@RequestBody RequestTodo request){
        return new ResponseEntity<>(BaseResponse
                .success(todoService.save(request), "Kayıt Başarıyla oluşturuldu."),
                HttpStatus.CREATED);
    }
}
