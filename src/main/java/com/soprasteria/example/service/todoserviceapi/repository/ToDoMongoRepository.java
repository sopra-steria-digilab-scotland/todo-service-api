package com.soprasteria.example.service.todoserviceapi.repository;

import com.soprasteria.example.service.todoserviceapi.domain.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ToDoMongoRepository extends MongoRepository<ToDo, Long> {

    public Optional<ToDo> findById(Long id);
    public List<ToDo> findByTodoName(String partName);
    public void deleteById(Long id);
//    public void markCompleted(Long id);
}
