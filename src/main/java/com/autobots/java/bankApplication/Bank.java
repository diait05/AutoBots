package com.autobots.java.bankApplication;

public interface Bank {

    // абстрактные методы
    double getBalance();          // запрашивать баланс
    void deposit(double amount);  // пополнить счет
    void withDraw(double amount); // снимает деньги со счета

    // межбанковский перевод    отправитель    получатель            сумма
   static void transferFunds(Bank sender, Bank recipient, double transferAmount){
       sender.withDraw(transferAmount);   // снимаем
       recipient.deposit(transferAmount); // положить получателю
   }
}
