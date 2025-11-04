# Recommendation System

The system consisting of several microservices (emulating the business logic of a recommendation system based on user actions) interacting through a Kafka broker

## Main Service

The Main Service has few endpoints in order to emulate users activity
> GET /posts/view

> POST /posts/like

> POST /posts/repost

When these endpoints are executed then it sends messages into `users-activity` Kafka topic with specific key (`view`, `like`, `repost`) 
in order to separate them by partition.

## Recommendation Service

The Recommendation Service is a microservice that emulates the generation of recommendations for system users 
and sends messages with information about recommendations to a `recommendations` Kafka topic every few seconds.


## Running the System using the Docker Compose tool

In order to run the system it is necessary to build microservices first:
> mvn package

Then the Docker images can be built:
> docker compose build [--no-cache]

And the full System can be launched:
> docker compose up -d