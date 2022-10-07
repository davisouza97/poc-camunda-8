package com.example.workflow.delegates;

import com.example.workflow.enums.CamundaEnums;
import com.example.workflow.util.LogUtil;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class SplitDelegate implements JavaDelegate {

    @Autowired
    private LogUtil log;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.logStart("SplitDelegate", delegateExecution.getBusinessKey());
        List<String> itemsId = Arrays.asList("1","2","3");
        delegateExecution.setVariable(CamundaEnums.COLLECTION.getValue(), itemsId);
        log.logEnd("SplitDelegate", delegateExecution.getBusinessKey());
    }
}
