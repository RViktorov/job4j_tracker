package ru.job4j.polymorphism;

public interface Transport {
    void drive();

    void passengers(int numberPassengers);

    double fill(double fuelQuantity);
}