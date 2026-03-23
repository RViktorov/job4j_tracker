package ru.job4j.ood.ocp.example;

public class DiscountService {//при добавлении новых категорий клиентов принцип OCP нарушится

    public double getDiscount(String type) {
        if (type.equals("pensioner")) {
            return 0.1;
        } else if (type.equals("vip")) {
            return 0.2;
        }
        return 0;
    }

}