package com.springboot.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

  //http://localhost:8080/student
  @GetMapping("/student")
  public Student getStudent(){
    return new Student("Julio", "Silva");

    /*

    How comes a Java Object is being returned as a JSON -- as: {"firstName":"Julio","lastName":"Silva"}?

    That is the beauty of Spring MVC: it uses internal jackson libraries and message converters to convert
    Java objects into JSON.

    Remembering: @RestController internally uses @ResponseBody annotation, which uses HTTP Message converters
    to convert the return value (Java object) to HTTP response body (e.g.:JSON), based on the content-type
    in the request HTTP header.

     */
  }
}
