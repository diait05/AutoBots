package com.autobots.java.bankApplication;

public class OptimaBank extends BankBase {

    private double balance = 0;

    public OptimaBank(long accountNumber, long routingNumber) throws Exception {
        super(accountNumber, routingNumber);
        addToAllBankRecords(this); // this - это ссылка на текущий объект, который создается в конструкторе
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount < 0 || amount > 300000) {
            throw new IllegalArgumentException("Invalid amount can not be deposit");
        }
        balance += amount;
    }

    @Override
    public void withDraw(double amount) {
        if (amount < 0 || amount > 250000){
            throw new IllegalArgumentException("Invalid amount can not be withDraw");
        } else {
            if (amount > balance){
                throw new IllegalArgumentException("Insufficient funds");
            } else {
                balance -= amount;
            }
        }
    }
}
