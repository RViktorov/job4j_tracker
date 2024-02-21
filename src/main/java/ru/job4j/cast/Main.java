package ru.job4j.cast;

public class Main {

    public static void main(String[] args) {

        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle airplane = new Airplane();
        Vehicle[] array = {bus, train, airplane};
        for (Vehicle vehicle : array) {
            vehicle.move();
        }
    }
}