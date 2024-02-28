package dev.codeunlu.docker.service;

import dev.codeunlu.docker.dto.RequestTodo;
import dev.codeunlu.docker.dto.TodoDto;
import dev.codeunlu.docker.model.Todo;
import dev.codeunlu.docker.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository repository;


    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<TodoDto> findAll(){
        return repository.findAll().stream().map(TodoDto::convert).toList();
    }

    public TodoDto save(RequestTodo request){
        Todo todo = Todo.convert(request);
        return TodoDto.convert(repository.save(todo));
    }
}
