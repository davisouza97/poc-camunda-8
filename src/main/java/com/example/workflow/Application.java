package com.example.workflow;

import io.camunda.zeebe.spring.client.EnableZeebeClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableZeebeClient
public class Application {

  public static void main(String... args) {
    SpringApplication.run(Application.class, args);
  }
}