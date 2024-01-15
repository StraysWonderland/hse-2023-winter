# hse-2023-winter

## Lab Requirements
Microservice project consisting of 3 Microservices:
- Frontend to visualise data and provide means to store data conviniently in contrast to via curl or postman
- Backend to process data
- Database to store data

The services can be in either technology
Ideally, containerized all 3 microservices.
Even more ideally, containerized via docker compose

Due Date: Exam Date (January 25th)

## 25. September 2023 - Lecture Canceled

## 02. October 2023 - Cloud Intro

### Intro questions:

* Which technologies or what do you have in mind in general if you think about "distributed systems"?
* the "WHY" - Why would people use and implement a distributed systems architecture?

![Distributed Systems Initial Thoughts](images/distributedsystems.png)
![Cloud and Distributed Systems](images/cloud_and_systems.png)

### Important Slides

- Cloud Pyramid - IaaS, PaaS and SaaS
- Cloud Definition - "Service Model"
- Explain "cloud idea" with one cloud service of your choice

### Resource Capacities and Utilization
In traditional IT (buying and maintaining servers to run operations on) the resources have to be frequently upgraded with the growing workload of users.
This leads to chronical under-utilization of hardware with expensive purchase periods
![Resource Capacities and Utilization](images/resourcecapacities.png)

## 09. October 2023 - Docker Intro

- [website For Exercises](https://hsed.new.trainings.nvtc.io/basics/)
- [Docker Hub](https://hub.docker.com/)
- [GitPod](https://www.gitpod.io/)

* What are containers and how do they work?
* Containers vs. VMs
* History of containers and rise of Docker
* Docker concepts: daemon, hub, dockerfile, CLI
* Running containers with various options

### Objectives

_The student understands the concepts and use cases of container technology and is able to describe them. The first exercise is to pull sample images from an image registry (e.g. Docker Hub) and interact with them (run, expose port, execute shell, cleanup etc). After that the student can show how to build a custom image via Dockerfile and push it to a registry for others to access. Complete the exercises handed out via URL._

### Review questions

* "WHY" Containers? List advantages/disadvantages ..
* What is the difference between a container and a VM? List 3 criteria
* Which technologies led to the evolution of docker (and why)? 
* What is the difference between a docker daemon and the docker hub? 
* What is the difference between docker run, docker pull and docker start?
* Which command transitions from a container instance to an image?
* What are the Docker components and describe them? (Rephrase!)
* What does docker exec do? Provide a pseudo-code example and explain what it does 
* Explain the container latest tag
* Explain 3 factors of the 12-factors in the context of containers. Explain in detail how they are realized!

### NOTES REGARDING EXERCISES: 

We have decided to keep the website running throughout the entire semester so you can access and do the docker exercises at any point.

There is at some point a task that mentions connecting to a virtual machine via ssh.
You can skip this as we will be working either in gitpod or locally but wont have a VM provided to connect to.

2nd Note:
At the end of the containers chapter there is a command given in the exercises to stop all running containers:

```bash 
docker ps -a -q | xargs docker stop
```

Xargs is also a unix specific tool that we usually have within the VMs we provide but that you might not have access to.
So instead you can just stop the containers individually by first running 

```bash
docker ps -q
```

which will give you only the ids of all running containers

```bash
❯ docker ps -q
f90372eb09e3
e5596ca8439a
9771e7c99abb
```

look at the IDs and stop each individually by typing the first 3 digits of the ID

```bash
docker stop f90
```

or you can try ``` wargs ``` on windows though i cant confirm if this is working
```bash
docker ps -a -q | wargs docker rm
```

### Docker Image and Container Storage

Following Diagram illustrates how Image creation and layer sharing is handled and how multiple instances of the same image are created.
![Docker Image Storage](images/DockerImageStorage.png)


### Goal of the Lab Exercise
![Goal of the Docker Lab Exercise](images/dockertodonet.png)


## Session 16-October-23 Introduction to Spring Boot

* Background: Spring Framework - History & components
* Spring ← → Spring Boot
* Spring Initializr (start.spring.io) & starter dependencies
* Basic project structure (folders, configuration ..)
* "Hello, World!" example explained
* Using Actuator

![Spring Boot Initializr Flow](https://raw.githubusercontent.com/maeddes/hft-2022-winter/main/pics/spring_boot_initializr_flow_2022_10_17.png)

### Objectives

The student is able to build and configure an own Spring Boot application from scratch with the IDE of choice. The exercise is to build an own "Hello, World!" application that exposes various - endpoints and is able to execute CRUD operations on the state of the application. Optional: Add logging and testing, configure Actuator.

### Exercises

Application:

* Build your own first Spring Boot Hello, World application at 
* https://start.spring.io
* Change name, Java version, build tool, dependencies. Observe changes
* Use the following deps: Web, Actuator, DevTools
* Annotate a class with @RestController and expose "some" REST Mappings
* Experiment with Mappings, e.g. @GetMapping, @PostMapping
* Pass a parameter via @PathVariable
* Build the application and package into a container image

Helpful Links:

* https://start.spring.io
* https://www.baeldung.com/spring-requestmapping
* https://spring.io/guides#getting-started-guides
* Full tutorial (stuff for next weeks): https://www.baeldung.com/spring-boot-start
* https://www.gitpod.io/docs/introduction/languages/java
* https://spring.io/guides/gs/rest-service/ (or basically Spring Guides in general)
* https://www.baeldung.com/spring-pathvariable (or basically all Baeldung guides)

## 23-October API and REST

![API](https://github.com/maeddes/hse-2023-summer/blob/main/pics/spring_boot_full_and_documented_rest_api_2022_11.png)

![more API](https://github.com/maeddes/hft-23-winter/raw/main/pics/REST_stuff.png)

* Synchronous communication
* HTTP and REST
* Verbs, Resources, Nouns
* Evolution, Richardson Maturity Model (except Level 3)
* CRUD Operations
* Building a REST API with Spring (Boot)
* Building a data model with REST

### Objectives and exercises
_The student understands the concepts of an API and synchronous communication in distributed systems and can explain it in own words._

### Exercise/Lab Task

* Create a full CRUD Rest API on your application
* The API object is a simple Java object with the following field
````
    private String todo;
    private int priority = 2;
````
* A RestController class is supposed to have an internal list of these objects and provide CRUD functionality.
* Starter sample is given in the git repo.

Links:

* https://restfulapi.net/idempotent-rest-apis/
* https://restfulapi.net/richardson-maturity-model/
* https://en.wikipedia.org/wiki/List_of_HTTP_status_codes

* https://www.baeldung.com/spring-requestmapping
* https://www.baeldung.com/spring-request-response-body
* https://www.baeldung.com/spring-rest-openapi-documentation
* https://www.baeldung.com/spring-cors

### Review questions

* Identify good and bad API examples and explain why
* Describe the concepts of Verbs and Nouns
* When is an invocation idempotent and safe? What does it mean? Provide examples
* Describe in your own words the mapping of REST calls to database (SQL) and CRUD calls

  Maturity check:

```
GET http://localhost/pleaseExecuteATask - Get vs. execute, no noun given, execute as pseudo verb in actual URL
POST http://localhost/tasks/ <properties of the task> -> Level 2
PUT http://localhost/people/123/age/25 -> looks ok
POST http://localhost/people/add/matthias/haeussler -> Level 1/2
POST http://localhost/people/matthias/haeussler -> better :)
DELETE http://localhost/animals/23 -> Level 2
```

## 30-October-2023 Persistence

![Recap 12-factor](https://github.com/maeddes/hft-23-winter/raw/main/pics/12_factor_DB.png)

* Spring Data
* Concept of entities and repositories
* JPA and JDBC basics
* H2, PostgeSQL, MySQL - configuration via Spring Boot profiles
* Running databases as Docker images

![Spring Data](https://github.com/maeddes/hft-2022-winter/raw/main/pics/spring_data_overview.png)

### Objectives and exercises
_The student is able to build a Spring Boot application (or extend an existing one) with Spring Data configuration. The exercise is to create an application, which performs CRUD operations on a database backend. The database can either be in-memory (H2) or a (containerized) PostgreSQL. Optional: Provide a docker-compose file to stand up a multi-container environment with application and database._

### Review Questions

* "WHY" persistence? "WHY" persistence frameworks like JPA?
* Describe the necessary components to build an application with Spring Data? Potentially sketch
* What does the annotation @Entity do? 
* How could docker compose help if you have a persistence-based application?


## 07.11.23 Advanced Cloud Topics: Cap Theorem, 12 factor apps
![image](https://github.com/StraysWonderland/hse-2023-winter/assets/22505258/13eceb63-25e6-48a3-b1ee-b2b8bf7b529a)

* CAP Theorem
* Conway's Law
* Fallacies of distributed computing
* Domain-Driven Design basics
* 12-factor application
* Evolution of applications and deployments: Monolithic -> Service-Oriented Architecture -> Microservices
* Introduction to serverless and FaaS terminology

### Objectives and exercises
_The student knows about the evolution of distributed systems (and middleware) and the drivers towards state-of-the-art implementation and deployment. She/he can explain the underlying concepts and theories and put it into practical context. No dedicated exercises for this module. Recap of basics: Spring Boot, Docker, configuration, persistence and messaging._

### Review questions

* "WHY" Cloud-Native Software? What IS Cloud-Native Software?
* Why "evolution" from a monolithic approach to a distributed approach?
* How does the CAP Theorem/Conway's Law relate to this?
* (NO Domain-Driven Design questions)
* How do the 12-factor application "methodology" relate to the technologies that we covered in this semester? (important)
* "WHY" is external configuration important in cloud-native software?
* Where did you see aspects of external configuration in the technologies we used? Provide examples

## 13-November Resilience

* What is Resilience
* Resilience in Distributed Systems
* Typical Problems in distributed Systems
* Patterns towards Resilience
    * Retry
    * Fallback
    * Timeout
    * Loadbalancer
    * Circuit Breaker
    * Monitoring

### Objectives

_The student understands what errors distributed systems typically face and how to design a more resilient systems through various design patterns.
No exercise for this module.

### Review questions
* Explain Resilience in distributed systems
* How to classify the error types a service might be facing
* Outline the concept of different resilience patterns


## 20.11.23 Docker Advanced Topics:
### Volumes
![image](https://github.com/StraysWonderland/hse-2023-winter/assets/22505258/0c1ff9b9-ba50-42d7-9eba-160abb912a72)
![image](https://github.com/StraysWonderland/hse-2023-winter/assets/22505258/5656078f-e187-4e18-ad20-62b939920ea2)

![Volumes documentation](https://docs.docker.com/storage/volumes/)

### Docker Network
![image](https://github.com/StraysWonderland/hse-2023-winter/assets/22505258/e5524d0a-cbb5-4bfe-9eb0-eedfba9a3c84)

### Docker Compose
example docker compose that also creates network

```
version: '3'
services:
  my_service:
    image: my_image
    networks:
      - my_custom_network

networks:
  my_custom_network:
    driver: bridge

```
## 27.11.23 Kubernetes

### Drawbacks of Docker alone on multiple hosts
![image](https://github.com/StraysWonderland/hse-2023-winter/assets/22505258/4cae194e-ea30-486d-8d20-8bad88fd494a)

### Comparison to k8s
![image](https://github.com/StraysWonderland/hse-2023-winter/assets/22505258/a4aae6e8-da77-4f72-b831-38c6514b3f36)

### The Kubeconfig
![image](https://github.com/StraysWonderland/hse-2023-winter/assets/22505258/fffa5f81-3a3f-4df0-ad10-6e1b954248a0)

### Kubernetes rolling update
![image](https://github.com/StraysWonderland/hse-2023-winter/assets/22505258/ad5bac21-6390-4362-846b-93425dedeea6)

* Presentation: Cloud Platforms & Kubernetes
* Kubernetes Background
* What is CaaS?
* Cluster & Node Concept
* Behaviour scenarios of Kubernetes in Action
* Base API objects: Deployments, ReplicaSets, Pods, Services
* Intro into kubectl 
  
### Objectives and exercises
_The student understands the requirements and expectations towards cloud platforms and is able to list them. She/he can explain the advantages over standard container operation with Docker. The exercise is to take a sample Spring Boot application and walk through the steps to containerize and deploy to Kubernetes. The student is aware about various options for local and remote Kubernetes options._

### Review questions

* Please write 100 lines of YAML Code :)
* Explain the relation of "some" of the 12 factors in relation to Kubernetes
* Explain the core principe of Kubernetes in own words. "Why" Kubernetes?
* What is pod? What is a service?
* Which kind of Kubernetes providers do you know? Can they be grouped somehow?

### Links

* https://docs.docker.com/engine/reference/commandline/compose_build/
* https://kubernetes.io/docs/tasks/configure-pod-container/configure-liveness-readiness-startup-probes/
* https://www.baeldung.com/spring-value-annotation

### Links - Kubernetes Options

* https://github.com/learnk8s/free-kubernetes (Overview)

* https://www.katacoda.com/courses/kubernetes/playground (web-based)
* https://training.play-with-kubernetes.com/ (web-based, broken?)

* https://kind.sigs.k8s.io/docs/user/quick-start/ (local)
* https://minikube.sigs.k8s.io/docs/ (local)
* https://docs.docker.com/get-started/kube-deploy/ (local)
* https://k3s.io/ (local)
* https://microk8s.io/ (local)

* https://aws.amazon.com/de/education/awseducate/ (Student)
* https://azure.microsoft.com/en-us/free/students/ (Student)

## 12-December - Code Review - no slides

## 18-December OpenTelemetry

* Why is there a need for monitoring and observability?
* Concept of distributed tracing - What is a trace? What is a span?
* OpenTelemetry as Open Source solution to address this problem
* Different ways of implementation: "Automatic" vs "Programmatic"
* Jaeger as technology to visualize distributed traces

### Objectives and exercises

The student is able to explain why observability is important and what the challenges of modern software (e.g. polyglot, distributed microservices) are. The student is able to use OpenTelemetry with auto-configuration to monitor an application, as well as configuring the agent to send the data to a collector. The student is able to read and describe a distributed trace in e.g. Jaeger.

### Basic OpenTelemetry concept
![OpenTelemetry basics](https://github.com/maeddes/hft-23-winter/raw/main/pics/Otel_basic.png)

### Alternatives for collection and visualization
![OpenTelemetry collection alternatives](https://github.com/maeddes/hft-23-winter/raw/main/pics/Open_Telemetry_Alternatives.png)
