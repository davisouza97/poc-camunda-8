package com.example.workflow.delegates;

import com.example.workflow.util.LogUtil;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.example.workflow.enums.CamundaEnums.IS_ODD;


@Component
public class DelegateOne {

    @Autowired
    private LogUtil log;

    @JobWorker(type = "verifyItemAndAccrualStatusTask")
    public Map<String, Object> execute(final ActivatedJob job) {
        Integer businessKey = (Integer) job.getVariablesAsMap().get("returnId");
        log.logStart("DelegateOne", businessKey);
//        String isOdd = businessKey % 2 != 0 ? "YES" : "NO";
        HashMap<String, Object> variables = new HashMap<>();
        variables.put("allItemsCompleted", "NO");
        log.logEnd("DelegateOne", businessKey);
        return variables;
    }
}

