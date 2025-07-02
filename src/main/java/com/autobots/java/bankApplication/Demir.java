package com.autobots.java.bankApplication;

public class Demir extends BankBase{

    private double balance = 500;

    public Demir(long accountNumber, long routingNumber) throws Exception {
        super(accountNumber, routingNumber);
        addToAllBankRecords(this); // this - это ссылка на текущий объект, который создается в конструкторе
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        if(amount < 0 || amount > 500000) {
            throw new IllegalArgumentException("Invalid amount can not be deposit");
        }
        balance += amount;
    }

    @Override
    public void withDraw(double amount) {
        if(amount < 0 || amount > 450000) {
            throw  new IllegalArgumentException("Invalid amount can not be withDraw");
        } else {
            if(amount > balance) {
                throw new IllegalArgumentException("Insufficient funds");
            } else {
                balance -= amount;
            }
        }
    }
}
