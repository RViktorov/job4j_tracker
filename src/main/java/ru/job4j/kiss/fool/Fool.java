package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {
    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        int startAt = 1;
        Scanner input = new Scanner(System.in);
        while (startAt < 100) {

            String computerAnswer = getFizzBuzz(startAt);
            System.out.println(computerAnswer);
            startAt++;
            String correctAnswer = getFizzBuzz(startAt);
            String userAnswer = input.nextLine().trim();
            if (!correctAnswer.equalsIgnoreCase(userAnswer)) {
                System.out.println("Ошибка. Начинай снова.");
                startAt = 1;
                continue;
            }
            startAt++;
        }
    }

    public static String getFizzBuzz(int number) {
        if (number % 15 == 0) {
            return "FizzBuzz";
        }
        if (number % 3 == 0) {
            return "Fizz";
        }
        if (number % 5 == 0) {
            return "Buzz";
        }
        return String.valueOf(number);
    }

}