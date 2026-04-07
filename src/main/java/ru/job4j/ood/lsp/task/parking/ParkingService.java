package ru.job4j.ood.lsp.task.parking;

public interface ParkingService {
    boolean park(Automobile automobile);

    boolean leave(String automobileNumber);

    boolean contains(String automobileNumber);

    int getFreeCarPlaces();

    int getFreeTruckPlaces();

}