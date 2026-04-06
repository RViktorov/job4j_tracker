package ru.job4j.ood.lsp.task.qualitycontrol.store;

import ru.job4j.ood.lsp.task.qualitycontrol.Food;

public class Trash extends AbstractStore {
    @Override
    public boolean acceptIntoStorage(Food food) {
        return foodLifePercent.calculatesLifeFood(food) >= TRASH_LIMIT;
    }

}