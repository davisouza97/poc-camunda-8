package com.example.workflow.enums;

public enum CamundaEnums {

    RECEIVE_CORRELATION("RECEIVE_CORRELATION"),
    COLLECTION("collection"),
    IS_ODD("isOdd"),
    ITEM("item"),
    PROJECT_PROCESS("my-project-process");

    private String value;

    CamundaEnums(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
