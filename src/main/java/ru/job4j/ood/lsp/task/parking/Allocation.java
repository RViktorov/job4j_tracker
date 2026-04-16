package ru.job4j.ood.lsp.task.parking;

import java.util.List;

public class Allocation {

    enum Type {
        TRUCK_PLACE,
        CAR_PLACES
    }

    private final Type type;
    private final List<Integer> indexes;

    Allocation(Type type, List<Integer> indexes) {
        this.type = type;
        this.indexes = indexes;
    }

    public Type getType() {
        return type;
    }

    public List<Integer> getIndexes() {
        return indexes;
    }
}