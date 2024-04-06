package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {
    @Test
    void whenItemAscByName() {
        List<Item> lists = new ArrayList<>();
        lists.add(new Item(1, "Sleep"));
        lists.add(new Item(2, "Run"));
        lists.add(new Item(3, "Go"));
        lists.sort(new ItemAscByName());
        List<Item> items = new ArrayList<>(lists);
        List<Item> expected = new ArrayList<>(List.of(new Item(3, "Go"), new Item(2, "Run"), new Item(1, "Sleep")));
        assertThat(items).isEqualTo(expected);
    }

}