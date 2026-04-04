package ru.job4j.ood.lsp.task.qualitycontrol.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.task.qualitycontrol.Food;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

class WarehouseTest {

    @Test
    public void whenFoodLess25() {
        Food food = new Food(
                "Milk",
                LocalDate.now().plusDays(10),
                LocalDate.now().minusDays(1),
                100,
                20
        );
        Warehouse warehouse = new Warehouse();
        assertTrue(warehouse.acceptIntoStorage(food));
    }
}
