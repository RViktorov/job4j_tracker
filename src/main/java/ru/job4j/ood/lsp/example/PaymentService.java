package ru.job4j.ood.lsp.example;

public class PaymentService {
    public void pay(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException();
        }
        System.out.println("Paid: " + amount);
    }

}