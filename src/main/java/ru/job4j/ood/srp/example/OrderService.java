package ru.job4j.ood.srp.example;

public class OrderService { //пример нарушения SPR в том что один класс отвечает одновременно за модель данных, за отправку почты, создание отчетов
    public void createOrder() {
        System.out.println("Order created");
    }

    public void sendEmail() {
        System.out.println("Email sent");
    }

    public void generateReport() {
        System.out.println("Report generated");
    }

}