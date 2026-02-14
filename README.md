# Recommendation System

The system consisting of several microservices and a Kafka broker, emulating the operation of a recommendation system (creating/processing recommendations based on users activity).

## System Components

### Main Service
###### Technology
A Java 21/Spring Boot microservice
###### Description
Has few REST endpoints in order to emulate users activity:
> GET /posts/view

> POST /posts/like

> POST /posts/repost

When these endpoints are executed it sends messages into `recommendation-system.users-activity` Kafka topic with specific key (`view`, `like`, `repost`)
in order to separate them by partition.

### Recommendation Service
###### Technology
A Java 21/Spring Boot microservice
###### Description
Emulates the generation of recommendations for system users.
Sends messages with some information about recommendations to a `recommendation-system.recommendations` Kafka topic every few seconds.

### Kafka Broker
###### Technology
A Docker container based on `apache/kafka:4.1.0` image
###### Description
Has few topics:
- `recommendation-system.users-activity` with 3 partitions for users activity types: views, likes, reposts;
- `recommendation-system.recommendations` with 1 partition for recommendations.

### Kafka UI
###### Technology
A Docker container based on `ghcr.io/kafbat/kafka-ui:v1.4.2` image
###### Description


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
