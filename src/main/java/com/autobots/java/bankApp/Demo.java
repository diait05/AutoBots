package com.autobots.java.bankApp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo {
    static Scanner scanner = new Scanner(System.in);
    static Map<String, Client> clients = new HashMap<>();

    public static void main(String[] args) {

        Client asan = new Client("Asan Uson", "1234");

        DepositAccount asanDepositAccount = new DepositAccount(asan, Currency.USD);
        CreditAccount asanCreditAccount = new CreditAccount(asan, Currency.EUR);

        asan.addAccount(asanDepositAccount);
        asan.addAccount(asanCreditAccount);
        System.out.println("\nClient ID: " + asan.getClientID() +"\n");

        clients.put(asan.getClientID(), asan);

        System.out.println("======= Welcome to Mbank =======");
        System.out.print("\nPlease enter client ID: ");
        String clientID = scanner.nextLine();
        Client client = clients.get(clientID);
        if (client == null) {
            System.out.println("Client was not found");
            return;
        }
        System.out.print("Please enter pin code: ");
        String pinCode = scanner.nextLine();
        if (!client.authenticate(pinCode)) {
            System.out.println("You entered wrong pin code!");
            return;
        }
        System.out.println("\n" + client.getFullName() + ", welcome to Mbank!");
        while (true) {
            System.out.println("Меню: ");
            System.out.println("1.Посмотреть счета");
            System.out.println("2.Перевести между счетами");
            System.out.println("3.Показать чек");
            System.out.println("0.Выход из системы");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    for (BankAccount bankAccount : client.getAccounts()) {
                        System.out.printf("%s | %s | Баланс: %.2f %s\n",
                                bankAccount.getClass().getSimpleName(),
                                bankAccount.getAccountNumber(),
                                bankAccount.getBalance(), bankAccount.getCurrency());
                    }
                    break;
                case "2":
                    System.out.print("Введите номер счета отправителя: ");
                    String fromID = scanner.nextLine();
                    System.out.print("Введите номер счета получателя: ");
                    String toID = scanner.nextLine();
                    System.out.print("Сумма: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    BankAccount from = findAccount(fromID);
                    BankAccount to = findAccount(toID);
                    if (from != null && to != null) {
                        boolean result = BankService.transfer(from, to, amount);
                        System.out.println(result ? "Операция прошла успешно" : "Ошибка перевода");
                    } else {
                        System.out.println("Счета не найдены");
                    }
                    break;
                case "3":
                    for (BankAccount bankAccount : client.getAccounts()) {
                        System.out.println("\n == чек по счету №: " + bankAccount.getAccountNumber());
                        for (Transaction transaction : bankAccount.getTransactions()) {
                            System.out.println(transaction);
                        }
                    }
                    break;

                case "0":
                    System.out.println("Выход...");
                    return;

                default:
                    System.out.println("Неверный выбор");
            }
        }
    }

    private static BankAccount findAccount(String accountNumber) {
        for (Client client : clients.values()) { // находим клиентов
            for (BankAccount bankAccount : client.getAccounts()) { // проверяем счета клиента
                if (bankAccount.getAccountNumber().equals(accountNumber)) {
                    return bankAccount; // если находим возвращаем счет
                }
            }
        }
        return null;
    }
}
