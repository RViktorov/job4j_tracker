package ru.job4j.ood.dip.example;

public class OrderService {
    private FileLogger logger = new FileLogger(); // сервис строго привязан к определенному виду логирования без абстракции

    void createOrder() {
        logger.log("Order created");
    }
}
