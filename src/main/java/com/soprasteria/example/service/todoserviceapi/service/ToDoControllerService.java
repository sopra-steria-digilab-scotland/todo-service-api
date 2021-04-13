package com.soprasteria.example.service.todoserviceapi.service;

import com.soprasteria.example.service.todoserviceapi.resources.ToDoResource;
import com.soprasteria.example.service.todoserviceapi.resources.ToDoResourceAssembler;
import com.soprasteria.example.service.todoserviceapi.domain.ToDo;
import com.soprasteria.example.service.todoserviceapi.repository.ToDoMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@ExposesResourceFor(ToDo.class)
@RequestMapping(value = "/todo", produces = "application/json")
public class ToDoControllerService {

    private final String SUCCESSFUL_RETURN_MESSAGE = "OK";


    @Autowired
    private ToDoResourceAssembler assembler;

    @Autowired
    private ToDoMongoRepository mongoRepository;


    /**
     *  Get method to return all todos
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<ToDoResource>> findAllOrders() {

        List<ToDo> todos = mongoRepository.findAll();

        return new ResponseEntity<>(assembler.toResourceCollection(todos), HttpStatus.OK);
    }


    /**
     *  Creating a todo through a REST interface
     * @param todo
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<ToDoResource> saveToDo(@RequestBody ToDo todo){

        todo.setId(System.currentTimeMillis());
        mongoRepository.save(todo);

        return new ResponseEntity<>(assembler.toResource(todo), HttpStatus.CREATED);
    }

    /**
     * Find ToDo by Id
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ToDoResource> findToDoById(@PathVariable Long id) {

        Optional<ToDo> todo = mongoRepository.findById(id);

        if (todo.isPresent()) {
            return new ResponseEntity<>(assembler.toResource(todo.get()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteToDo(@PathVariable Long id) {
        mongoRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    @RequestMapping(value = "/completed/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> markCompleted(@PathVariable Long id) {

        //TODO: implement completed functionality
        Optional<ToDo> todoItem = mongoRepository.findById(id);

        if(todoItem.isPresent()){
            ToDo todo = todoItem.get();
            todo.markTodoCompleted();
            mongoRepository.save(todo);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    /**
     * Service Ping method for health check.
     * @return
     */
    @GetMapping("/ping")
    @ResponseBody
    public ResponseEntity<Void> ping(){
        return new ResponseEntity<>((HttpStatus.OK));
    }
}
