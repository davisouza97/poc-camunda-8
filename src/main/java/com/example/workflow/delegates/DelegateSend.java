package com.example.workflow.delegates;

import com.example.workflow.util.LogUtil;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DelegateSend implements JavaDelegate {

    @Autowired
    private LogUtil log;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.logStart("DelegateSend", delegateExecution.getBusinessKey());
        log.logEnd("DelegateSend", delegateExecution.getBusinessKey());
    }
}
