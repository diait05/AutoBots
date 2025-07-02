package com.autobots.java.mobileBanking;

public class ExchangeRate {

    // Курс к USD;
    final static double USD = 1.0;
    final static double EUR = 1.1;
    final static double KGS = 0.011;

    static double convert(double amount, Currency from, Currency to) {
        double result = 0.0;
        if (from.equals(Currency.EUR) && to.equals(Currency.USD)) {
            result = amount * EUR;
        } else if (from.equals(Currency.USD) && to.equals(Currency.EUR)) {
            result = amount * USD / EUR;
        } else if (from.equals(Currency.KGS) && to.equals(Currency.EUR)) {
            result = amount / USD / EUR;
        } else if (from.equals(Currency.KGS) && to.equals(Currency.USD)) {
            result = amount / USD;
        } else if (from.equals(Currency.USD) && to.equals(Currency.KGS)) {
            result = amount / KGS;
        } else if (from.equals(Currency.EUR) && to.equals(Currency.KGS)) {
            result = amount / KGS / EUR;
        }
        return result;
    }
}
