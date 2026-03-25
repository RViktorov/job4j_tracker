package ru.job4j.ood.lsp.example;

public class CryptoPaymentService extends PaymentService {
    @Override
    public void pay(int amount) {
        if (amount < 100) { // условие установлено более строгое-нарушение LSP
            throw new IllegalArgumentException();
        }
        System.out.println("Crypto paid: " + amount);
    }

}