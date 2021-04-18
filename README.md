# README File

## Purpose
This project is used as an example project which uses REST based services to store information in a NO-SQL database.

The project uses spring boot and mongodb database as its base technology.

This is a "To-Do" application and the API can be accesses by tools like postman.

## Configuration maps

authentication_database - For the demo we use database authentication for connectivity
username - User detail mapped from ConfigMaps
password - User detail mapped from ConfigMaps
database - the database name configured.
port - Port number , default port is 27017
host - the host name configured for the environment.

## Message structures

### Adding a to-do item

METHOD: POST 
URL: http://<domain-name>/todo
Payload: {
"todoName":"first test todo",
"todoDescription":"first test todo description",
"createdBy":"user0"
}

### List all todos



### Adding nexus

if there is no image on openshift, then use below command to add it as template.
oc create -f https://raw.githubusercontent.com/kenmoini/openshift-sonatype-nexus/master/nexus3-persistent-template.yaml
