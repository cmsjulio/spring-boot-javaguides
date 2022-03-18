# Spring Boot - Java Guides

## 1. What is Spring Boot

### Starting
Spring is good for several reasons:

* Dependency injection;
* Database transaction management;
* Integratin with other Java frameworks;
* Web MVC frameworkd for building web applications;

Spring Boot is used to boot Spring framework applications, in order to quickly create production ready Spring-based applications.

Spring Boot is an extension of Spring Framework, it uses all of its libraries.

Key featuers of SB:

* Spring boot starters;
* Spring boot autoconfiguration;
* Externalized configuration;
* Spring boot actuator;
* Easy to use embedded servlet container support;

### Without Spring Boot

When using MVC, we need to configure:

* Component scan;
* Dispatcher servlet;
* View resolver;
* Web jars (for delivering static content) among other things;

Hibernate/JPA:

* Data source;
* Entity manager factory/sessino fatory;
* Transaction manager and other things;

When we use cache:

* Cache configuration;

When we use message queue:

* Message queue configuration;

When we use NoSQL database:

* NoSQL database configuration;

To help developers to focus only on business logic rather than external configurations, there is Spring Boot.


## 2. Spring Boot key features

### Spring boot starters

Starter modules provided by Spring Boot to quickly start modules such as MVC, MongoDB, JPA, Spring Security, etc.

These starter dependencies are pre configured most of the commonly used libraries dependencies, so that you do not have to search for compatibility among libraries and do manual configuration.

Ex.: spring-boot-starter-data-jpa

Whenever we include this dependency, it will include all the dependencies required to use spring-data-jpa, along with Hibernate library dependencies. Hibernate is a JPA implementation, it is a JPA provider.

Ex.: spring-boot-starter-web

It will be deafult pull all the commonly used libraries when developing Spring MVC applications: Spring MVC, jackson, Tomcat server, Validation API etc.

We need to only add the starter dependency and Spring boot will do lots of things for us.

### Spring boot auto configuration

It attempts to automatically configure the Spring boot application based on the jar dependencies that were added in the class path.

Why do we need them?

Spring based applications have lots of configurations.

Without Spring boot, some beans, let us say, for Hibernate, will have to be configured manually with @Bean.

When using Spring MVC, we need to configure:

* Componente scan;
* Dispatcher servlet;
* View resolver;
* Web jars;
* Data source;
* Entity manager factory/session;
* Transaction manager among a host of other things;

These configurations are typical: in all kind of Spring applications we must configure these things.

Instead of doing them all manually and all the time, we can do them automatically, that is what Spring boot does.

Whenever Spring boot finds an MVC or Hibernate dependency in a class path, it automatically configures Component scan, dispatcher servlet, Hibernate, etc.

### Externalized configuration

Useful for deplying your Spring boot application in different environments. It enables the developer to work with the same application but in different environments -- dev, prodction etc. Property files (yml) are used to maintain the configuration. Spring boot uses different configuration files for different environments. Each one of them for a different profile.

You can use annotations such as @Value and @ConfigurationProperty to read the values from the properties files or yml files.

This is very useful feature for when you are deploying a same application in different environments.

### Spring boot actuator

We use this to monitor all the details configured in our Spring boot application. 

Ex.:

* View the application bean configuration details;
* View the application URL mappings;
* View environment details;
* View configuration parameter values;
* View the registered health check metrics; 

### Easy to use embedded servlet container support

We can quickly run our SP application in a embedded servlet container. 

Whenever we build a web app using Spring framework, we need to deploy our Spring Web app in an external Tomcat server: download a Tomcat, setup server, make a war file of our Spring MVC web app, and then explicitly deploy war file in the Tomcat server.

Spring boot solves it all for us.

By default it provides a Tomcat server as a default servlet container. Whenever we use a Spring boot starter web dependency, it automatically include a Tomcat server dependency. So whenever we run our SB app as a stand alone, it will run in a default embedded Tomcat server. We will not need to create and deploy an external war file and deploy it into an external Tomcat server. We can rather make a jar file of our SB app and run as a stand alone in an embedded servlet container easily.

## 3. Different was to create a Spring boot project

* Using spring initializr
* Using Spring Starter Project in STS (Eclipse)
* Using Sping Boot CLI - command line tool that you can use if you wan to quickly develop a Spring application.

### Using Spring Initializr

Visit start.spring.io. You can also integrate it in your IDE by using plugins.

### Using Spring Starter Project in STS (Eclipse)

Spring team integrated Spring initializr into STS: Spring Tool Suite.

### Using Spring Boot CLI

First you need to install it. Then follow doc commands to create a new project.

## 4. Create Spring Boot app using Spring initializr

Spring Web:
* Spring MVC web application
* Spring Rest API application
* Apache Tomcat as default embedded container.

Spring Data JPA:
* Hibernate, persitance.

## 5. Spring Boot Auto-Configuration: Theory

It attempts to automatically configure your Spring application based on the jar dependencies that you have added.

Why do we need Spring Boot Auto Configuration?

Spring based apps have a lot of configurations.

AppContext.java, AppInitializer.java, WebMvcConfig.java, e.g.

Auto-configuration deals with autonomously implementing such configurations. 

Whenever Spring finds a Spring MVC or Hibernate/JPA dependency in the class path, it runs its auto-configuration.

### Thought process

* When spring mvc jar is added into an app, can we auto configure some beans automatically?
* How about autoconfiguring a data source if Hibernate jar is on the class path?
* How about autoconfiguring a Dispatcher Servlet if Spring MVC jar is on the class path?

