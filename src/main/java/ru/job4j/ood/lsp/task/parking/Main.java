package ru.job4j.ood.lsp.task.parking;

public class Main {
    public static void main(String[] args) {
        ParkingService parking = new ParkingServiceImp(5, 1);

        Automobile car = new Car("A001");
        Automobile truck = new Truck("T001", 3);

        System.out.println(parking.park(car));    // true
        System.out.println(parking.park(truck));  // true

        System.out.println(parking.getFreeCarPlaces());   // 4
        System.out.println(parking.getFreeTruckPlaces()); // 0

        System.out.println(parking.leave("T001")); // true
        System.out.println(parking.contains("T001")); // false
    }

}