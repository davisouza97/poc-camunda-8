package com.example.workflow.config;

import io.camunda.zeebe.client.ZeebeClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class CamundaConfig {

//    @Bean
    public ZeebeClient zeebeClient() {
//        return ZeebeClient.newClientBuilder()
//                .gatewayAddress("127.0.0.1:26500")
//                .usePlaintext()
//                .build();
        return null;
    }

}
