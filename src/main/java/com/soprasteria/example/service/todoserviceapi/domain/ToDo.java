package com.soprasteria.example.service.todoserviceapi.domain;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
//@RequiredArgsConstructor
@ToString
@Document(collection = "todo")
public class ToDo implements Identifiable {

    @Id
    private Long id;
    private String todoName;
    private String todoDescription;
    private String createdBy;
    private boolean isComplete;

    @Override
    public void setId(Long id) {
        this.id = id;
    }


    public void markTodoCompleted(){
        this.isComplete = true;
    }

    public void markTodoIncomplete(){
        this.isComplete = false;
    }

    @Override
    public Long getId() {
        return id;
    }
}
