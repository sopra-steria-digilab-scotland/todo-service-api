package com.soprasteria.example.service.todoserviceapi;

import com.soprasteria.example.service.todoserviceapi.service.ToDoControllerService;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.BDDAssertions.then;

public class ToDoUnitTests {

    @Test
    public void pingUnitTest(){
        ToDoControllerService cont = new ToDoControllerService();

        ResponseEntity<Void> resp = cont.ping();

        then(resp.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
