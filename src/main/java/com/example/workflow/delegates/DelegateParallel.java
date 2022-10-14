package com.example.workflow.delegates;

import com.example.workflow.enums.CamundaEnums;
import com.example.workflow.util.LogUtil;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DelegateParallel  {

    @Autowired
    private LogUtil log;

    @JobWorker(type = "parallel")
    public void execute(final ActivatedJob job) {
        Integer orderId = (Integer) job.getVariablesAsMap().get("orderId");
        log.logStart("DelegateParallel", orderId);
        String itemId = (String) job.getVariablesAsMap().get(CamundaEnums.ITEM.getValue());
        log.logEnd("DelegateParallel", orderId + " - " + itemId);
    }
//    @Override
//    public void execute(DelegateExecution delegateExecution) throws Exception {
//        log.logStart("DelegateParallel", delegateExecution.getBusinessKey());
//        String itemId = (String) delegateExecution.getVariable(CamundaEnums.ITEM.getValue());
//        log.logEnd("DelegateParallel", delegateExecution.getBusinessKey() + " - " + itemId);
//    }
}
