package com.soprasteria.example.service.todoserviceapi.repository;

import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.core.env.Environment;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

import java.util.Arrays;


@Configuration
@EnableMongoRepositories(basePackages = "com.soprasteria.example")
public class MongoConfig extends AbstractMongoConfiguration {

    @Autowired
    private Environment env;

    @Override
    protected String getDatabaseName() {
        return env.getProperty("database");
    }

    @Override
    public MongoClient mongoClient() {
        MongoCredential cred = MongoCredential.createCredential(env.getProperty("username"), env.getProperty("database"), env.getProperty("password").toCharArray());
        return new MongoClient(new ServerAddress(env.getProperty("host"), Integer.parseInt(env.getProperty("port"))), Arrays.asList(cred));
    }



    @Override
    protected String getMappingBasePackage() {
        return "com.thomasvitale.model";
    }



}
