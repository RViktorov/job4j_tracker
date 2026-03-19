package ru.job4j.ood.srp;

public class Paraglider implements Flyable{
    @Override
    public void fly() {

    }

    @Override
    public double calculateFuel(double distance) {// этот метод будет создавать лишнюю ответственность, т.к параплан не использует топливо
        return 0;
    }
}
