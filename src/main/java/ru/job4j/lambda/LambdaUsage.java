package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("eeeee", "a", "ccc", "dddd", "bb");
        Comparator<String> comparator = (left, right) -> {
            System.out.println("compare - " + left.length() + " : " + right.length());
            return Integer.compare(right.length(), left.length());
        };
        strings.sort(comparator);
        for (String string : strings) {
            System.out.println(string);
        }

        Comparator<String> comparatorDescSize = (left, right) -> {
            return Integer.compare(right.length(), left.length());
        };

        strings.sort(comparatorDescSize);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
