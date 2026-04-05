# Recommendation System

The system consisting of several microservices and a Kafka broker, emulating the operation of a recommendation system (creating/processing recommendations based on users activity).

This project focuses not on business logic and code, but on the system as a whole, the interaction between components, and the infrastructure.

<img src="docs/images/recommendation_system_diagram.png" alt="drawing" width="70%"/>

## System Components

### Main Service
###### Technology
Java 25 / Spring Boot 4 Microservice
###### Description
Has few REST endpoints in order to emulate users activity:
> GET localhost:8080/posts/view

> POST localhost:8080/posts/like

> POST localhost:8080/posts/repost

When these endpoints are executed it sends messages into `recommendation-system.users-activity` Kafka topic with specific key (`view`, `like`, `repost`)
in order to separate them by partition.

### Recommendation Service
###### Technology
Java 25 / Spring Boot 4 Microservice
###### Description
Emulates the generation of recommendations for users:
- Reads messages from the `recommendation-system.users-activity` Kafka topic about users activity
- Generates recommendations with different types and
- Sends messages with some information about recommendations to different partitions of a `recommendation-system.recommendations` Kafka topic.

### Notification Service
###### Technology
Java 25 / Spring Boot 4 Microservice
###### Description
Emulates the generation and sending of notifications to users based on recommendations:
- Reads recommendations from the `recommendation-system.recommendations` Kafka topic
- 'Sends' notifications about recommendations to users.

### Kafka Broker
###### Technology
A Docker container based on `apache/kafka:4.1.0` image
###### Description
Has few topics:
- `recommendation-system.users-activity` with 3 partitions for users activity types: views, likes, reposts;
- `recommendation-system.recommendations` with 3 partitions for different recommendations: news, new friends, interesting blog posts.

### Kafka UI
###### Technology
A Docker container based on `ghcr.io/kafbat/kafka-ui:v1.4.2` image
###### Description
UI for Apache Kafka message broker is available at:
> localhost:8083

### Prometheus
###### Technology
A Docker container based on `prom/prometheus:v3.9.1` image
###### Description
Prometheus becomes available after starting services using Docker Compose:
> localhost:9090

### Grafana

###### Technology
A Docker container based on `grafana/grafana:12.3.2` image
###### Description
Grafana becomes available after starting services using Docker Compose:
> localhost:3000

## Running the System using the Docker Compose tool

In order to run the system it is necessary to build microservices first:
> mvn clean package

Then the Docker images can be built:
> docker compose build [--no-cache]

And the full System can be launched:
> docker compose up -d

To shut down the system, run:
> docker compose down
