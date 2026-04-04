package ru.job4j.ood.lsp.task.qualitycontrol;

import ru.job4j.ood.lsp.task.qualitycontrol.store.Store;

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

}