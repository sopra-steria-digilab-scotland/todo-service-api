package com.soprasteria.example.service.todoserviceapi.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import com.soprasteria.example.service.todoserviceapi.domain.ToDo;
import org.springframework.hateoas.ResourceSupport;

@Getter
public class ToDoResource extends ResourceSupport {

	private final Long idVal;
	private final String name;
	private final String description;
	private final String createdBy;
	private final boolean isComplete;
	
	public ToDoResource(ToDo toDo) {
		idVal = toDo.getId();
		name = toDo.getTodoName();
		description = toDo.getTodoDescription();
		createdBy = toDo.getCreatedBy();
		isComplete = toDo.isComplete();
	}

	@JsonProperty("id")
	public Long getResourceId() {
		return idVal;
	}
	

}
