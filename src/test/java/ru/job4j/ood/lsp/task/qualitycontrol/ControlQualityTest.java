package ru.job4j.ood.lsp.task.qualitycontrol;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.task.qualitycontrol.store.Shop;
import ru.job4j.ood.lsp.task.qualitycontrol.store.Store;
import ru.job4j.ood.lsp.task.qualitycontrol.store.Trash;
import ru.job4j.ood.lsp.task.qualitycontrol.store.Warehouse;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ControlQualityTest {

    @Test
    public void whenDistributeThenCorrectStore() {
        Store warehouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();
        ControlQuality control = new ControlQuality(List.of(warehouse, shop, trash));
        Food food = new Food(
                "Apple",
                LocalDate.now().plusDays(10),
                LocalDate.now().minusDays(1),
                100,
                20
        );
        control.placementProductsInStorage(food);
        assertEquals(1, warehouse.findAll().size());
    }
}