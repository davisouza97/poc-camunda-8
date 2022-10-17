package com.example.workflow.enums;

public enum CamundaEnums {

    ORDER_ID("orderId"),
    RECEIVE_CORRELATION("RECEIVE_CORRELATION"),
    COLLECTION("collection"),
    IS_ODD("isOdd"),
    ITEM("item"),
    BUSINESS_KEY("businessKey"),
    PROJECT_PROCESS("Process_a24708ff-ab33-4a6b-9719-fd5961c7e1e9");

    private String value;

    CamundaEnums(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
