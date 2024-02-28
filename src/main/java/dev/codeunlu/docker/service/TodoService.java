package dev.codeunlu.docker.service;

import dev.codeunlu.docker.dto.RequestTodo;
import dev.codeunlu.docker.model.Todo;
import dev.codeunlu.docker.repository.TodoRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoRepository repository;


    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public Todo save(RequestTodo request){
        Todo todo = Todo.convert(request);
        return repository.save(todo);
    }
}
