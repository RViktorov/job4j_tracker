package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.ExitAction;
import ru.job4j.tracker.action.UserAction;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.MockInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemDescByNameTest {

    @Test
    void whenItemDescByName() {
        List<Item> lists = new ArrayList<>();
        lists.add(new Item(1, "Sleep"));
        lists.add(new Item(2, "Run"));
        lists.add(new Item(3, "Go"));
        lists.sort(new ItemDescByName());
        List<Item> items = new ArrayList<>(lists);
        List<Item> expected = new ArrayList<>(List.of(new Item(1, "Sleep"), new Item(2, "Run"), new Item(3, "Go")));
        assertThat(items).isEqualTo(expected);
    }

}