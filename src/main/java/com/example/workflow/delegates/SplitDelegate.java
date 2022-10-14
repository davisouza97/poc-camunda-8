package com.example.workflow.delegates;

import com.example.workflow.util.LogUtil;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SplitDelegate {

    @Autowired
    private LogUtil log;

    @JobWorker(type = "split")
    public Map<String, Object> execute(final ActivatedJob job) {
        Integer businessKey = (Integer) job.getVariablesAsMap().get("orderId");
        log.logStart("SplitDelegate", businessKey);
        List<String> itemsId = Arrays.asList("1", "2", "3");
        HashMap<String, Object> variables = new HashMap<>();
        variables.put("collection", itemsId);//TODO converter para String?
        log.logEnd("SplitDelegate", businessKey);
        return variables;
    }

//    @Override
//    public void execute(DelegateExecution delegateExecution) throws Exception {
//        log.logStart("SplitDelegate", delegateExecution.getBusinessKey());
//        List<String> itemsId = Arrays.asList("1","2","3");
//        delegateExecution.setVariable(CamundaEnums.COLLECTION.getValue(), itemsId);
//        log.logEnd("SplitDelegate", delegateExecution.getBusinessKey());
//    }
}
