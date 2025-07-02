package com.autobots.java.mobileBanking;

import java.util.UUID;

public abstract class BankAccount {

    protected UUID accountNumber;
    protected double balance;
    Currency currency;
    Client client;
    Transaction transaction;

    public BankAccount(Currency currency, Client client) {
        this.currency = currency;
        this.client = client;
        this.transaction = new Transaction();
    }

    abstract void deposit(double amount);
    abstract boolean withdraw(double amount);
    void addTransaction (String type, double amount){

    }

    public UUID getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(UUID accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
