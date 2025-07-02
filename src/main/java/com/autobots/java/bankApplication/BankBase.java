package com.autobots.java.bankApplication;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class BankBase implements Bank{ // реализует Интерфейс Bank

    private String bankName;
    private long accountNumber;
    private long routingNumber; // идентификатор банка

    public static Set<BankBase> allBankRecords = new HashSet<>(); // специальное хранилище для всех данных

    public BankBase(long accountNumber, long routingNumber) { // конструктор для создания объектов чс
        if(Long.toString(accountNumber).length() != 12) { // проверка
            throw new IllegalArgumentException("Account number must be 12 digits"); // выбрасывается ошибка
        } else if (Long.toString(routingNumber).length() != 9) {
            throw new IllegalArgumentException("Routing number must be 9 digits");
        } else {
            this.accountNumber = accountNumber;
            this.routingNumber = routingNumber;
        }
    }

    public static void addToAllBankRecords(BankBase bank) throws Exception { // предупреждаем что могут быть исключения
        for(BankBase bankBase: allBankRecords)  {
            if(bankBase.getAccountNumber() == bank.getAccountNumber()) {
                throw new Exception(bank.getAccountNumber() + ": account number already exist");
            }
            if(bankBase.getRoutingNumber() == bank.getRoutingNumber()) {
                throw new Exception(bank.getRoutingNumber() + ": routing number already exist");
            }
        }
        allBankRecords.add(bank);
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(long routingNumber) {
        this.routingNumber = routingNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BankBase bankBase = (BankBase) o;
        return accountNumber == bankBase.accountNumber && routingNumber == bankBase.routingNumber;
        // Объекты считаются равными, если совпадают accountNumber и routingNumber
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, routingNumber);
        // Хеш-код вычисляется по значениям accountNumber и routingNumber
    }

    @Override
    public String toString() {
        return "BankBase: " +
                "accountNumber - " + accountNumber +
                ", routingNumber - " + routingNumber;
    }
}