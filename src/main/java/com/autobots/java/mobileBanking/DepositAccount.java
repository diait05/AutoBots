package com.autobots.java.mobileBanking;

import java.time.LocalDateTime;

public class DepositAccount extends BankAccount {

    public DepositAccount(Currency currency, Client client, Transaction transaction) {
        super(currency, client);
    }

    public void callMethod(String methodName, double amount) {
        transaction.setOperationType(methodName);
        transaction.setOperationSum(amount);
        transaction.setTimestamp(LocalDateTime.now());
        if (methodName.equals(OperationType.DEPOSIT.description)) {
            deposit(amount);
            System.out.println(transaction);
        } else if (methodName.equals(OperationType.WITHDRAW.description)) {
            withdraw(amount);
            balance -= amount;
            System.out.println(transaction);
        }
    }

    @Override
    void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Insufficient funds for deposit");
        } else {
            balance += amount;
        }
    }

    @Override
    boolean withdraw(double amount) {
        if (balance < amount) {
            throw new IllegalArgumentException("Insufficient funds for withdraw");
        } else {
            return true;
        }
    }

    @Override
    void addTransaction(String type, double amount) {
        callMethod(type, amount);
    }
}

