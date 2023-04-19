#  Film Library Soap-Sakila

## Introduction
Welcome to the documentation for the "Movie Library" project! This project is designed to provide a comprehensive backend solution for managing a movie library. The project is built using the JAX-WS framework and uses a MySQL database (SAKILA) as its backend.

## Technologies Used:
* JAX-WS
* Maven
* Lombok
* Tomcat
* Jakarta persistance (Hibernate)
* MYSQL
* XML
* JSON


## Getting Started

Download Sakila DB:

```bash
  https://www.sqliz.com/sakila/installation/
```
for more information about it: 
```bash
https://downloads.mysql.com/docs/sakila-en.pdf
```
Clone the project
```bash
https://github.com/MartinaNaeem/Soap-Sakila-Project.git
```

* Edit username and password values in the persistence.xml with your DB user's data.
* Run your tomcat apache server and then change the configuration of tomcat in pom.xml.
* Finally, deploy the application using the following maven command.
 ```bash
mvn clean install tomcat7:deploy
```
Now, you can start using the APIs by sending HTTP requests to the endpoints specified in the documentation.
## Documentation

[Films Library Documnetation](https://documenter.getpostman.com/view/19818512/2s93Y2Sgkg)

