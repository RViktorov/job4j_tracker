package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int c) {
        return c - x;
    }

    public int divide(int d) {
        return d / x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int sumAllOperation(int b) {
        return sum(b) + multiply(b) + minus(b) + divide(b);
    }

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println(result);
        result = minus(10);
        System.out.println(result);
        Calculator calculator = new Calculator();
        result = calculator.divide(10);
        System.out.println(result);
        result = calculator.multiply(10);
        System.out.println(result);
        result = calculator.sumAllOperation(10);
        System.out.println(result);

    }

}