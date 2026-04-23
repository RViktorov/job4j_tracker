package ru.job4j.ood.lsp.task.qualitycontrol.store;

import ru.job4j.ood.lsp.task.qualitycontrol.Food;

import java.util.List;

public interface Store {
    boolean acceptIntoStorage(Food food);

    void add(Food food);

    List<Food> findAll();

    boolean delete(Food food);

    List<Food> findByName(String name);

    void clear();

}