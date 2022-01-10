# Ticket Service

Requirements: java 11 (spring boot), maven

# Run console app (no spring)

```shell
mvn package
java -jar target/flight-service-0.0.1-SNAPSHOT.jar
```

# Run web app (spring framework)

```mvn spring-boot:run``` - run local web app

# API

```POST /api/baggage``` - add baggage, body {"baggageId":123,"destinationId":123}

```GET /api/coupon/{id}``` - check coupon

```GET /api/tickets/{id}``` - check ticket

