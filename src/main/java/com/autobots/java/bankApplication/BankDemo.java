package com.autobots.java.bankApplication;

public class BankDemo {
    public static void main(String[] args) throws Exception {

        MBank aliiaMBank = new MBank(123456789012L, 444444444);

        System.out.println(aliiaMBank.getBalance());
        aliiaMBank.deposit(100000);
        System.out.println("______________");
        System.out.println(aliiaMBank.getBalance());

        OptimaBank ulugbekOptima = new OptimaBank(210987654321L, 555555555);
        System.out.println(ulugbekOptima.getBalance());

        Bank.transferFunds(aliiaMBank, ulugbekOptima, 500);
        System.out.println(aliiaMBank.getBalance());
        System.out.println(ulugbekOptima.getBalance());

        Demir zinaidaDemir = new Demir(123456123456L, 666666666);
        System.out.println(zinaidaDemir.getBalance());

//        Bank.transferFunds(zinaidaDemir, ulugbekOptima, 1000);
//        zinaidaDemir.withDraw(500000);

        BankBase.allBankRecords.stream().filter(n -> n.getBalance() > 100).forEach(System.out::println);

        double allSumOfBanks = BankBase.allBankRecords.stream().mapToDouble(Bank::getBalance).sum();
        System.out.println(allSumOfBanks);
    }
}
