package com.example.workflow.controller;


import com.example.workflow.enums.CamundaEnums;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiveController {

    @Autowired
    private RuntimeService runtimeService;

    @PostMapping(value = "/v1/start")
    public ResponseEntity<Void> start(@RequestParam(required = false, name = "id") String id) {
        runtimeService
                .startProcessInstanceByKey(
                        CamundaEnums.PROJECT_PROCESS.getValue(),
                        id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping(value = "/v1/receive")
    public ResponseEntity<Void> receive(@RequestParam(required = false, name = "id") String id) {
        runtimeService.createMessageCorrelation(CamundaEnums.RECEIVE_CORRELATION.getValue())
                .processInstanceBusinessKey(id)
                .correlate();

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
