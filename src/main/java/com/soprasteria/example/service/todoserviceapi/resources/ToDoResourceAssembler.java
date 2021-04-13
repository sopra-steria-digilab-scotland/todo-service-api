package com.soprasteria.example.service.todoserviceapi.resources;

import com.soprasteria.example.service.todoserviceapi.domain.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

@Component
public class ToDoResourceAssembler extends ResourceAssembler<ToDo, ToDoResource> {
	
	@Autowired
	protected EntityLinks entityLinks;

	private static final String UPDATE_REL = "update";
	private static final String DELETE_REL = "delete";

	@Override
	public ToDoResource toResource(ToDo order) {
		
		ToDoResource resource = new ToDoResource(order);
		
		final Link selfLink = entityLinks.linkToSingleResource(order);
		
		resource.add(selfLink.withSelfRel());
		resource.add(selfLink.withRel(UPDATE_REL));
		resource.add(selfLink.withRel(DELETE_REL));
		
		return resource;
	}
}
