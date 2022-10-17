package com.example.workflow.delegates;

import com.example.workflow.util.LogUtil;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.workflow.enums.CamundaEnums.ORDER_ID;

@Component
public class DelegateSend {

    @Autowired
    private LogUtil log;

    @JobWorker(type = "send")
    public void execute(final ActivatedJob job) {
        Integer businessKey = (Integer) job.getVariablesAsMap().get(ORDER_ID.getValue());
        log.logStart("DelegateSend", businessKey);
        log.logEnd("DelegateSend", businessKey);
    }
}
