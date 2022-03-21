package com.springboot.demo;

import com.springboot.demo.sub1.SpringComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootDemoApplication {

	public static void main(String[] args) {
    ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootDemoApplication.class, args);
    SpringComponent component = applicationContext.getBean(SpringComponent.class); //getting our component from app context
    //applicationContext is our Spring IOC container containing all the Spring Beans.
    // SpringComponent is nothing but a Bean -- because we annotated it with a @Component annotation (annotation based config).
    System.out.println(component.getMessage());
	}

}
