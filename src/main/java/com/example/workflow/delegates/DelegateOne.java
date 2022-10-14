package com.example.workflow.delegates;

import com.example.workflow.util.LogUtil;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class DelegateOne {

    @Autowired
    private LogUtil log;

    @JobWorker(type = "one")
    public Map<String, Object> execute(final ActivatedJob job) {
        Integer businessKey = (Integer) job.getVariablesAsMap().get("orderId");
        log.logStart("DelegateOne", businessKey);
        String isOdd = businessKey % 2 != 0 ? "YES" : "NO";
        HashMap<String, Object> variables = new HashMap<>();
        variables.put("isOdd", isOdd);
        log.logEnd("DelegateOne", businessKey);
        return variables;
    }
}

