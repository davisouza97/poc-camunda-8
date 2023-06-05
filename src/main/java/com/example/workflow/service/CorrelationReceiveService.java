package com.example.workflow.service;

import io.camunda.zeebe.client.ZeebeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import static com.example.workflow.enums.CamundaEnums.ORDER_ID;
import static com.example.workflow.enums.CamundaEnums.PROJECT_PROCESS;

@Service
public class CorrelationReceiveService {

    @Autowired
    private ZeebeClient zeebeClient;


    public void start(String orderId) {
        HashMap<String, Object> var = new HashMap<>();
        var.put("returnId", Integer.parseInt(orderId));
        zeebeClient.newCreateInstanceCommand().bpmnProcessId("OMS_MARKETPLACE_RETURN")
                .latestVersion()
                .variables(var)
                .send()
                .join();
    }

    public void execute(String orderId) {
        zeebeClient.newPublishMessageCommand()
                .messageName("receiveMessage")
                .correlationKey(orderId)
                .send();
    }


}
