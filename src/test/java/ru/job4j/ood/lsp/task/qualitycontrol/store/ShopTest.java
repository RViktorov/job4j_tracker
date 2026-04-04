package ru.job4j.ood.lsp.task.qualitycontrol.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.task.qualitycontrol.Food;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShopTest {

    @Test
    public void whenProductIsHalfwayPastExpirationDate() {
        Food food = new Food(
                "Сhocolate",
                LocalDate.now().plusDays(3),
                LocalDate.now().minusDays(3),
                150,
                20
        );
        Shop shop = new Shop();
        assertTrue(shop.acceptIntoStorage(food));
    }
}