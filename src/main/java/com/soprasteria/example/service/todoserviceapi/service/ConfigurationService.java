package com.soprasteria.example.service.todoserviceapi.service;


import com.soprasteria.example.service.todoserviceapi.domain.ToDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/config")
public class ConfigurationService {

    private static final Logger logger = LoggerFactory.getLogger(ConfigurationService.class);

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> getConfig() {


        logger.info(" -- printing in logger --");

        Map<String, String> envs = System.getenv();
        for(String key: envs.keySet()){
            logger.info("--> CONFIGURATION ENV: Key:["+key+"] Value:["+envs.get(key)+"]");
        }


        return new ResponseEntity<>("ALL OK", HttpStatus.OK);

    }
}
