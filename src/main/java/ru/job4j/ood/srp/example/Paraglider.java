package ru.job4j.ood.srp.example;

import ru.job4j.ood.srp.example.Flyable;

public class Paraglider implements Flyable {
    @Override
    public void fly() {

    }

    @Override
    public double calculateFuel(double distance) { // этот метод будет создавать лишнюю ответственность, т.к параплан не использует топливо
        return 0;
    }
}
