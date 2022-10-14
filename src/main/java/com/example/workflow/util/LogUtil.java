package com.example.workflow.util;

import org.springframework.stereotype.Component;

@Component
public class LogUtil {

    public void logStart(String delegateName, Object businessKey){
        System.out.println(delegateName + " - start - [" + businessKey+ "]");
    }

    public void logEnd(String delegateName, Object businessKey){
        System.out.println(delegateName + " - end - [" + businessKey+ "]");
    }

}
