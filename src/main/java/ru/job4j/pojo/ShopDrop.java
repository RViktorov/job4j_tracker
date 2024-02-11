package ru.job4j.pojo;

import java.util.Arrays;

public class ShopDrop {

    public static Product[] delete(Product[] products, int index) {

        for (int i = index; i < products.length; i++) {
            if (i == products.length - 1) {
                products[i] = null;
            } else
                products[i] = products[i + 1];
        }
        return products;
    }
}