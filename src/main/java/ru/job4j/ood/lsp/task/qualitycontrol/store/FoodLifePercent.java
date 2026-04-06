package ru.job4j.ood.lsp.task.qualitycontrol.store;

import ru.job4j.ood.lsp.task.qualitycontrol.Food;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FoodLifePercent {
    protected double calculatesLifeFood(Food food) {
        long generaShelfLife = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        long usedExpirationDate = ChronoUnit.DAYS.between(food.getCreateDate(), LocalDate.now());
        return (double) usedExpirationDate / generaShelfLife * 100;
    }
}
