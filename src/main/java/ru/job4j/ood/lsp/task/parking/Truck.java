package ru.job4j.ood.lsp.task.parking;

import java.util.Objects;

public class Truck implements Automobile {
    private final String number;
    private final int size;

    public Truck(String number, int size) {
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException("the vehicle number is not filled in");
        }
        if (size <= 1) {
            throw new IllegalArgumentException("Truck size must be greater than 1");
        }
        this.number = number;
        this.size = size;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Truck truck)) {
            return false;
        }
        return size == truck.size && Objects.equals(number, truck.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, size);
    }

}