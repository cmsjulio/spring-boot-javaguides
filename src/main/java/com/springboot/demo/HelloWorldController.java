package com.springboot.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// @Controller // to make this class as a spring mvc class (that will handle web requests)
// @ResponseBody // to convert Java objects to JSON/XML
@RestController
public class HelloWorldController {

  /*
  @Controller
  We use @Controller annotation to make this class a Spring MVC Class: a class that will handle
  web requests.


  @ResponseBody
  All the REST APIs that we create inside this controller (GET, POST, PUT, DELETE) should return
  a JSON or XML or other different representation format to the client.
  In order to return these kinds of response, we need to use @ResponseBody annotation.

  Basically, @ResponseBody annotation converts Java Object to JSON or XML and send it back to the client.
  It uses HTTP Message converters to do so.


  @RestController
  A combination of both @Controller and @ResponseBody annotations.

  @GetMapping
  To make it a Rest Endpoint to handle HTTP GET requests.

   */

  @GetMapping("/helloworld")
  public String helloWorld(){
    return "Hello World!";
  }

  @GetMapping("/helloworldApp")
  public String helloWorld2(){
    return "Hello World agaaaain!";
  }

}
