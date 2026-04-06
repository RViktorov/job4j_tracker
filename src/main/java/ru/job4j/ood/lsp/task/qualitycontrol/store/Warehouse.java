package ru.job4j.ood.lsp.task.qualitycontrol.store;

import ru.job4j.ood.lsp.task.qualitycontrol.Food;

public class Warehouse extends AbstractStore {
    @Override
    public boolean acceptIntoStorage(Food food) {
        return foodLifePercent.calculatesLifeFood(food) < WAREHOUSE_LIMIT;
    }

}