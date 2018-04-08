# Ski Jumpers
Application for managing list of ski jumpers and their achievements.

## Technologies
Java 8, Spring Boot, Hibernate, H2/MySql

For convenience application is by default configured to use in memory H2 database and there is no need to install and configure your own database. DB schema will be generated by Hibernate when starting application.

## Instruction
To run the application you need to have Java 8 installed. Not working with Java 9.

### Running
```
mvn package
java -jar target/skiJumpers-1.0-SNAPSHOT.jar
```

### Tests
`mvn test`

### Using
There is no GUI yet. To use the application use some kind of REST application (e.g. Postman).

##### List all ski jumpers
GET `http://localhost:8080/skiJumpers`

##### Add new ski jumper
POST `http://localhost:8080/skiJumpers`

Example request body:
```
{
        "name": "Kamil",
        "surname": "Stoch",
        "nation": "POLAND",
        "winsInCareerInWorldCup": 31,
        "podiumsInCareerInWorldCup": 57
    }
```


##### Edit ski jumper with ID {id}
PUT `http://localhost:8080/skiJumpers/{id}`

Example request body:
```
{
        "name": "Kamil",
        "surname": "Stoch",
        "nation": "POLAND",
        "winsInCareerInWorldCup": 31,
        "podiumsInCareerInWorldCup": 57
    }
```

##### Delete ski jumper with ID {id}
DELETE `http://localhost:8080/skiJumpers/{id}`