package ru.job4j.ood.ocp.example;

public class PaymentService {// добавить новый тип оплаты (пример криптовалюта), то нарушаем принцип закрытости OCP

    public void pay(String method) {
        switch (method) {
            case "card":
                System.out.println("Card");
                break;
            case "QRcode":
                System.out.println("QRcode");
                break;
        }
    }
}
