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


## 6. Spring Boot Auto-Configuratoin: Practical

Where is it implemented?

In pom.xml, spring-boot-starter is the dependency we have to run our SB app as a stand alone, without any server. 

To explore SB autoconfig in action, we change it to spring-boot-starter-web.

Spring-boot-starter-web is used to create: Spring web applications and Spring REST API applications.

To explore it in action, we go to application.properties and add:

```
logging.level.org.springframework.web=debug
```

To see all the debug statements from package org.springframework.web.

Then we run the application.

In the output text, we see the embedded Tomcat server on port 8080 that was autoconfigured.

![img_4.png](images/img_4.png)

It has also configured the RequestMappingHandlerMapping, RequestMappingHandlerAdapter, ServletWebServerApplicationContext, ControllerAdvice beans, many things.

To check if dispatcher servlet autoconfig is enabled or not, we remove the .web in the end of the line we added in app.properties. So that:

```
logging.level.org.springframework=debug
```

Checking the output, we see in the Positive matches section, that DispatcherServletAutoconfiguration matched.

![img_1.png](images/img_1.png)

A anotação @ConditionalOnClass foi a responsável por habilitar o Dispatcher:
* Primeiro checou-se a existência da classe no caminho 'org.springframework.web.servlet.DispatcherServlet'.
* Este check foi realizado pela anotação @ConditionalOnClass.
* A partir de então, habilitou-se a classe DispatcherServletAutoConfiguration.

The spring-boot-starter-web depedency uses spring-web, spring-webmvc, and many others, from springframework. 

![img_5.png](images/img_5.png)

Spring Boot is built on top of Spring Framework.

All the dependencies listed in the pom.xml are installed in the External Libraries directory:

![img_6.png](images/img_6.png)

So spring-webmvc library -- that is added from the pom.xml dependencies -- contains the org.springframework.web.servlet.DispatcherServlet class.

![img_7.png](images/img_7.png)

In the output, all the classes that matched were enabled.

In the negative matches, we see all the classes which were not found in the respective searched path.

![img_3.png](images/img_3.png)

Whenever you add a dependency in your project, the autoconfigure will search for its path and find the required class (that was previously installed by maven) and then do the match -- i.e., enable it.

All autoconfiguration logic is implemented in spring-boot-autoconfigure.jar.

The autoconfiguration classes are those first listed in Positive and Negative matches, such as:
AopAutoconfiguration, DispatcherServletAutoConfiguration, ActiveMQAutoConfiguration, etc.

The list of all autoconfiguration classes are available in the spring-boot-autoconfigure JAR file. As:

![img.png](images/img.png)

Whenever the AutoConfiguration classes are triggered (from noticing the existance of related dependencies in External Libraries), these are the classes that are enabled.

Resumo: a percepção da existência de uma dependência nas External Libraries (ou Maven Dependencies) ativa a classe AutoConfiguration relacionada à dependência em questão.

Exemplo do Dispatcher Servlet:

![img.png](images/imgn1.png)

O diretório META-INF, dentro de spring-boot-autoconfigure, contém um arquivo chamado spring.factories -- arquivo este que contém todas as classes AutoConfiguration do Spring.

![img.png](images/imgn2.png)

Exemplo do Servlet:

![img.png](images/imgn3.png)

### Resumindo

Again: Spring Boot configura automaticamente a aplicação Spring conforme encontra dependências presentes nos caminhos devidos.

A simples adição da dependência spring-boot-starter-web (que carrega consigo outras dependências, como vimos: spring-web, spring-webmvc etc.) foi suficiente para adição das libraries webmvc.

Nas libraries webmvc, tínhamos a Dispatcher Servlet.

Esta foi checada e notada, habilitando o AutoConfigure do Dispatcher Servlet ("DispatcherServletAutoConfiguration matched").

A responsaibilidade de habilitar a AutoConfiguration class sempre que houver uma External Library equivalente é da anotação -- no caso, @ConditionalOnClass.

## 7. Spring Boot App Execution Process - Theory

![img.png](images/img7.1.png)

The SpringbootDemoApplication class, 
in our case, is the Start Class or 
Spring Boot entry point class.

![img.png](images/img7.2.png)

A clase contém um main method, que contém, internamente, um run method da classe SpringApplication. 
O run method é um static method.

### How SpringApplication.run method works

The main method tells Java from where to start the program. Internally, the run method is called.
Then all the logic is dealt with. We can structure the process as follows:

* SB app execution will start from main() method;
* The main() method internally call SpringApplicatin.run() method;
* SpringApplication.run() method performs bootstrapping for our sprinb boot application;
* Starts StopWatch to identify time taken to bootstrap the spring boot application;
* Prepares environment to run our spring boot application (dev, prod, qa, uat);
* Print banner (Spring Boot Logo prints on console);
* Start the IOC container (ApplicationContext) based on the classpath (defaul, Web servlet, Reactive); without SB we would have to do it manually.
* Refresh context;
* Trigger Runners (ApplicationRunner or CommandLineRunner);
* Return Application/context reference (Spring IOC);

## 8. Spring Boot App Execution Process - Practical

Let us check the SpringApplication.run static method -- which
takes SpringbootDemoApplication.class and args as arguments.

![img.png](images/img8.0.png)

We can see that it calls another run static method. By Ctrl+clicking on it, we are sent to:

![img_2.png](images/img8.2.png)

Which also calls another run method. Clicking again:

![img_3.png](images/img8.3.png)

Which is the final run method that is being called.

* Starting the watch to calculate the time consumed in app start:

![img_4.png](images/img8.4.png)

* Preparing environment to run our SB application:

![img_5.png](images/img8.5.png)

After clicking in the .prepareEnvironment method, we have:

![img_6.png](images/img8.6.png)

We do not have to undestand it all, but be aware of the process steps.

* Next step is printing the banner:

![img_7.png](images/img8.7.png)

* Then, the ApplicationContext is created, i.e., creating the Spring IOC Container.

![img_8.png](images/img8.8.png)

After clicking in the method, we have:

![img_9.png](images/img8.9.png)

Checking .create, we see:

![img_10.png](images/img8.10.png)

Which means it will create a Context based on the webApplicationType. Servlet, Reactive or default.

Without SB we would have to start the ApplicationContext manually.

* Then it refreshes the ApplicationContext:

![img_11.png](images/img8.11.png)

* It then stops the Watch (calculates the time taken):

![img_12.png](images/img8.12.png)

* Then it triggers the runners:

![img_13.png](images/img8.13.png)

If we go inside .callRunners, we will see two types of runners, ApplicationRunner
and CommandLineRunner.

![img_14.png](images/img8.14.png)

* After all, it returns a Context:

![img_1.png](images/img8.15.png)

Context is an object of the ConfigurableApplicationContext class:

![img.png](images/img8.16.png)

Which is an interface that extends ApplicationContext:

![img_1.png](images/img8.17.png)

And ApplicationContext is nothing but out Spring IOC container.

