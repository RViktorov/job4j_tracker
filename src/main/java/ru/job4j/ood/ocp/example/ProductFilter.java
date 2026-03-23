package ru.job4j.ood.ocp.example;

import java.util.List;

public class ProductFilter {//класс будет меняться при добавлении каждого нового метода, нарушение OCP

    public List<Product> filterByColor(List<Product> products, String color) {

        return products;
    }

    public List<Product> filterBySize(List<Product> products, double size) {

        return products;
    }

    public List<Product> filterByPrice(List<Product> products, double price) {

        return products;
    }

}