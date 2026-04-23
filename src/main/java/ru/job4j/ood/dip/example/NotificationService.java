package ru.job4j.ood.dip.example;

public class NotificationService {
    private EmailSender sender = new EmailSender();//строгая привязка к одному способу отправки уведомлений

    void notifyUser(String message) {
        sender.send(message);
    }
}
