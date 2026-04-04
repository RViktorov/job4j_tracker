package ru.job4j.ood.lsp.task.qualitycontrol.store;

import ru.job4j.ood.lsp.task.qualitycontrol.Food;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {

    protected List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        foods.add(food);
    }

    @Override
    public List<Food> findAll() {
        return foods;
    }

    @Override
    public List<Food> findByName(String name) {
        List<Food> result = new ArrayList<>();
        for (Food food : foods) {
            if (food.getName().equals(name)) {
                result.add(food);
            }
        }
        return result;
    }

    @Override
    public boolean delete(Food food) {
        return foods.remove(food);
    }

    protected double calculatesLifeFood(Food food) {
        long generaShelfLife= ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        long usedExpirationDate= ChronoUnit.DAYS.between(food.getCreateDate(), LocalDate.now());
        return (double) usedExpirationDate / generaShelfLife * 100;
    }
}
