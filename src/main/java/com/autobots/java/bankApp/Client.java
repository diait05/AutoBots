package com.autobots.java.bankApp;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Client {

    private final String fullName;
    private final String clientID;
    private final String pin;
    private final List<BankAccount> accounts = new ArrayList<>();

    public Client(String fullName, String pin) {
        this.fullName = fullName;
        this.pin = pin;
        this.clientID = String.valueOf(UUID.randomUUID()); // clientID дается автоматом банк, чтоб не в ручную
    }

    public boolean authenticate(String inputPin) {
        return this.pin.equals(inputPin); // сравнение паролей
    }

    public void addAccount(BankAccount account){
        accounts.add(account);
    }

    public String getFullName() { // setterов нет, тк final
        return fullName;
    }

    public String getClientID() {
        return clientID;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }
}
