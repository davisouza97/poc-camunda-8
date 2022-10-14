package com.example.workflow.service;

import io.camunda.zeebe.client.ZeebeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CorrelationReceiveService {

    @Autowired
    private ZeebeClient zeebeClient;


    public void start(String orderId) {
        HashMap<String, Object> var = new HashMap<>();
        var.put("orderId", Integer.parseInt(orderId));
        zeebeClient.newCreateInstanceCommand().bpmnProcessId("Process_a24708ff-ab33-4a6b-9719-fd5961c7e1e9")
                .latestVersion()
                .variables(var)
                .send()
                .join();
    }

    //    @JobWorker
    public void execute(String orderId) {
//        zeebeClient.newPublishMessageCommand().

        zeebeClient.newPublishMessageCommand().messageName("receiveMessage").correlationKey(orderId).send();
    }


}
