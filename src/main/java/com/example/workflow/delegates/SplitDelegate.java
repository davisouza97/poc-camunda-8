package com.example.workflow.delegates;

import com.example.workflow.util.LogUtil;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.workflow.enums.CamundaEnums.COLLECTION;
import static com.example.workflow.enums.CamundaEnums.ORDER_ID;

@Component
public class SplitDelegate {

    @Autowired
    private LogUtil log;

    @JobWorker(type = "split")
    public Map<String, Object> execute(final ActivatedJob job) {
        Integer businessKey = (Integer) job.getVariablesAsMap().get(ORDER_ID.getValue());
        log.logStart("SplitDelegate", businessKey);
        List<String> itemsId = Arrays.asList("1", "2", "3");
        HashMap<String, Object> variables = new HashMap<>();
        variables.put(COLLECTION.getValue(), itemsId);
        log.logEnd("SplitDelegate", businessKey);
        return variables;
    }
}
