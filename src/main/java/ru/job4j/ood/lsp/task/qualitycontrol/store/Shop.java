package ru.job4j.ood.lsp.task.qualitycontrol.store;

import ru.job4j.ood.lsp.task.qualitycontrol.Food;

public class Shop extends AbstractStore {
    @Override
    public boolean acceptIntoStorage(Food food) {
        double shelfLifePercentage = calculatesLifeFood(food);
        if (shelfLifePercentage >= 25 && shelfLifePercentage < 75) {
            return true;
        }
        if (shelfLifePercentage >= 75 && shelfLifePercentage < 100) {
            food.setPrice(food.getPrice() - (food.getPrice() * (food.getDiscount() / 100)));
            return true;
        }
        return false;
    }

}