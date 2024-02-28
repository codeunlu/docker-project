package dev.codeunlu.docker.dto;

import dev.codeunlu.docker.model.Todo;

public record TodoDto(String id, String title, String descrption, Boolean active) {
    public static TodoDto convert(Todo todo){
        return new TodoDto(todo.id(), todo.title(), todo.description(), todo.active());
    }
}
