package com.example.workflow.delegates;

import com.example.workflow.util.LogUtil;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DelegateSend {

    @Autowired
    private LogUtil log;

    @JobWorker(type = "send")
    public void execute(final ActivatedJob job) {
        Integer businessKey = (Integer) job.getVariablesAsMap().get("orderId");
        log.logStart("DelegateSend", businessKey);
        log.logEnd("DelegateSend", businessKey);
    }

//    @Override
//    public void execute(DelegateExecution delegateExecution) throws Exception {
//        log.logStart("DelegateSend", delegateExecution.getBusinessKey());
//        log.logEnd("DelegateSend", delegateExecution.getBusinessKey());
//    }
}
