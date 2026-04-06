package ru.job4j.ood.lsp.task.qualitycontrol.store;

import ru.job4j.ood.lsp.task.qualitycontrol.Food;

public class Shop extends AbstractStore {
    @Override
    public boolean acceptIntoStorage(Food food) {
        double shelfLifePercentage = foodLifePercent.calculatesLifeFood(food);
        if (shelfLifePercentage >= WAREHOUSE_LIMIT && shelfLifePercentage < SHOP_LIMIT) {
            return true;
        }
        if (shelfLifePercentage >= SHOP_LIMIT && shelfLifePercentage < TRASH_LIMIT) {
            food.setPrice(food.getPrice() - (food.getPrice() * (food.getDiscount() / 100)));
            return true;
        }
        return false;
    }

}