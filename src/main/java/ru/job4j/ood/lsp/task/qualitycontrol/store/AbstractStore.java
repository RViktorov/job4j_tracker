package ru.job4j.ood.lsp.task.qualitycontrol.store;

import ru.job4j.ood.lsp.task.qualitycontrol.Food;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {

    protected List<Food> foods = new ArrayList<>();
    protected static final double WAREHOUSE_LIMIT = 25.0;
    protected static final double SHOP_LIMIT = 75.0;
    protected static final double TRASH_LIMIT = 100.0;
    protected FoodLifePercent foodLifePercent = new FoodLifePercent();

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

}