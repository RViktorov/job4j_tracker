package ru.job4j.ood.lsp.task.qualitycontrol;

import ru.job4j.ood.lsp.task.qualitycontrol.store.Store;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    private final List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void placementProductsInStorage(Food food) {
        for (Store store : stores) {
            if (store.acceptIntoStorage(food)) {
                store.add(food);
                return;
            }
        }
    }

    public void resort() {
        List<Food> allFoods = new ArrayList<>();
        for (Store store : stores) {
            allFoods.addAll(store.findAll());
            store.clear();
        }
        for (Food food : allFoods) {
            placementProductsInStorage(food);
        }
    }

}