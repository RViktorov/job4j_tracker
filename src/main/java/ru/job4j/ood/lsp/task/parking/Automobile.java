package ru.job4j.ood.lsp.task.parking;

public interface Automobile {
    String getNumber();

    int getSize();

    default boolean isCar() {
        return getSize() == 1;
    }

    default boolean isTruck() {
        return getSize() > 1;
    }

}