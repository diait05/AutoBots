package com.autobots.java.mobileBanking;

public class CreditAccount extends BankAccount {

    protected double creditLimit = 1000;

    public CreditAccount(Currency currency, Client client, Transaction transaction) {
        super(currency, client);
    }

    public void callMethod(String methodName, double amount) {
        if (methodName.equals(OperationType.DEPOSIT.description)) {
            deposit(amount);
        } else if (methodName.equals(OperationType.WITHDRAW.description)) {
            withdraw(amount);
            if (withdraw(amount)) {
                if (amount > balance && (Math.abs(balance - amount) <= creditLimit)) {
                    creditLimit -= Math.abs(balance - amount);
                } else if (amount == balance) {
                    balance += creditLimit -= amount;
                }
            }
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
        if (balance - amount > creditLimit) {
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

