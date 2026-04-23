package ru.job4j.ood.dip.example;

import liquibase.database.core.MySQLDatabase;

public class UserService {
    private MySQLDatabase db = new MySQLDatabase();// сервис зависит от одного вида баз данных, необходима реализация через интерфейс

    void saveUser(String user) {
        db.save(user);
    }
}
