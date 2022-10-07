package com.example.workflow.delegates;

import com.example.workflow.enums.CamundaEnums;
import com.example.workflow.util.LogUtil;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DelegateParallel implements JavaDelegate {

    @Autowired
    private LogUtil log;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.logStart("DelegateParallel", delegateExecution.getBusinessKey());
        String itemId = (String) delegateExecution.getVariable(CamundaEnums.ITEM.getValue());
        log.logEnd("DelegateParallel", delegateExecution.getBusinessKey() + " - " + itemId);
    }
}
