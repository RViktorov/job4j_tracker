package ru.job4j.ood.lsp.task.qualitycontrol.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.task.qualitycontrol.Food;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TrashTest {

    @Test
    public void whenExpirationDateHasPassed() {
        Food food = new Food(
                "Bread",
                LocalDate.now(),
                LocalDate.now().minusDays(3),
                70,
                20
        );
           Trash trash = new Trash();
        assertTrue(trash.acceptIntoStorage(food));
    }
}