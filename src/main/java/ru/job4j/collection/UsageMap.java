package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> result = new HashMap<>();
        result.put("ivanov@rambler.ru", "Ivanov Ivan Ivanovich");
        result.put("petrov@rambler.ru", "Petrov Petr Ivanovich");
        result.put("sidorov@rambler.ru", "Sidorov Petr Ivanovich");
        result.put("ivanov@rambler.ru", "Vasin Petr Ivanovich");
        for (String key : result.keySet()) {
            System.out.println(result.get(key));
        }
    }
}
