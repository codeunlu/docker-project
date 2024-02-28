package dev.codeunlu.docker.model;

import dev.codeunlu.docker.dto.RequestTodo;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "todos")
public record Todo(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        String id,
        String title,
        String description,
        @CreationTimestamp
        LocalDateTime createdDate,
        @UpdateTimestamp
        LocalDateTime updatedDate,
        Boolean active
) {
        public static Todo convert(RequestTodo request){
                return new Todo(null, request.title(), request.description(),LocalDateTime.now(),null,true);
        }
}
