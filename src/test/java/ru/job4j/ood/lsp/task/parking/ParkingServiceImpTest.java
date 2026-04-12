package ru.job4j.ood.lsp.task.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingServiceImpTest {

    @Test
    void shouldParkCarToCarPlace() {
        ParkingService parking = new ParkingServiceImp(2, 1);
        Automobile car = new Car("A777МР77");

        boolean parked = parking.park(car);

        assertTrue(parked);
        assertTrue(parking.contains("A777МР77"));
        assertEquals(1, parking.getFreeCarPlaces());
        assertEquals(1, parking.getFreeTruckPlaces());
    }

    @Test
    void shouldNotParkCarWhenNoCarPlaces() {
        ParkingService parking = new ParkingServiceImp(0, 1);
        Automobile car = new Car("A777МР77");

        boolean parked = parking.park(car);

        assertFalse(parked);
        assertFalse(parking.contains("A777МР77"));
    }

    @Test
    void shouldParkTruckToTruckPlaceFirst() {
        ParkingService parking = new ParkingServiceImp(5, 1);
        Automobile truck = new Truck("A777МР77", 3);

        boolean parked = parking.park(truck);

        assertTrue(parked);
        assertTrue(parking.contains("A777МР77"));
        assertEquals(5, parking.getFreeCarPlaces());
        assertEquals(0, parking.getFreeTruckPlaces());
    }

    @Test
    void shouldParkTruckToConsecutiveCarPlacesWhenNoTruckPlaces() {
        ParkingService parking = new ParkingServiceImp(5, 0);
        Automobile truck = new Truck("A777МР77", 3);

        boolean parked = parking.park(truck);

        assertTrue(parked);
        assertTrue(parking.contains("A777МР77"));
        assertEquals(2, parking.getFreeCarPlaces());
        assertEquals(0, parking.getFreeTruckPlaces());
    }

}