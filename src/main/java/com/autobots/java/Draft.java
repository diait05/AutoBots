package com.autobots.java;

public class Draft {
    public static void main(String[] args) {
        int result = sum(5, 6);
        System.out.println(result);

//        int result2 = sum2(10, 20);
        sum2(10, 20);

        String result3 = sum3(4, 8);
        System.out.println(result3);
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static void sum2(int a, int b) {
        System.out.println(a + b);
    }

    public static String sum3(int a, int b) {
        return String.valueOf(a + b);
    }
}
