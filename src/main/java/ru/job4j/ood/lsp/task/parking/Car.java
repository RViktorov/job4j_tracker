package ru.job4j.ood.lsp.task.parking;

import java.util.Objects;

public class Car implements Automobile {
    private final String number;

    public Car(String number) {
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException("the vehicle number is not filled in");
        }
        this.number = number;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car car)) {
            return false;
        }
        return Objects.equals(number, car.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}