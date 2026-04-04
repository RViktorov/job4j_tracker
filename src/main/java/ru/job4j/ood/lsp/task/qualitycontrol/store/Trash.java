package ru.job4j.ood.lsp.task.qualitycontrol.store;

import ru.job4j.ood.lsp.task.qualitycontrol.Food;

public class Trash extends AbstractStore {
    @Override
    public boolean acceptIntoStorage(Food food) {
        System.out.println(calculatesLifeFood(food));
        return calculatesLifeFood(food) >= 100;
    }

}