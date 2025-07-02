package com.autobots.java.mobileBanking;

public enum OperationType {
    DEPOSIT("deposit"),
    WITHDRAW("withdraw"),
    TRANSFER("transfer");

    String description = "";

    OperationType(String description) {
        this.description = description;
    }

    public String getDescription(String type) {
        return OperationType.valueOf(type).description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
