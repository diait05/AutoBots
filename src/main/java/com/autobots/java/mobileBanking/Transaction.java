package com.autobots.java.mobileBanking;

import java.time.LocalDateTime;
import java.util.Formatter;

public class Transaction {

    private OperationType operationType;
    private double operationSum;
    private LocalDateTime timestamp;

    public String getOperationType(String type) {
        return operationType.getDescription(type);
    }

    public void setOperationType(String type) {
        this.operationType = OperationType.valueOf(type);
    }

    public double getOperationSum() {
        return operationSum;
    }

    public void setOperationSum(double operationSum) {
        this.operationSum = operationSum;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Transaction: \n" +
                "operationType: " + operationType +
                "\noperationSum: " + operationSum +
                "\ntimestamp: " + timestamp;
    }
}

