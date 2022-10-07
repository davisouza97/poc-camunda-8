package com.example.workflow.delegates;

import com.example.workflow.enums.CamundaEnums;
import com.example.workflow.util.LogUtil;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DelegateOne implements JavaDelegate {

    @Autowired
    private LogUtil log;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String businessKey = delegateExecution.getBusinessKey();
        log.logStart("DelegateOne", businessKey);
        String isOdd = Integer.parseInt(businessKey) % 2 != 0 ? "YES" : "NO";
        delegateExecution.setVariable(CamundaEnums.IS_ODD.getValue(), isOdd);
        log.logEnd("DelegateOne", businessKey);
    }
}
