package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Поехали");
    }

    @Override
    public void passengers(int numberPassengers) {
        System.out.println("заполнение автобуса " + numberPassengers);
    }

    @Override
    public double fill(double fuelQuantity) {
        final double PRICE = 35.4;
        return fuelQuantity * PRICE;
    }
}