package ru.job4j.ood.lsp.task.parking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingServiceImp implements ParkingService {
    private final String[] carPlaces;
    private final String[] truckPlaces;
    private final Map<String, Allocation> allocations = new HashMap<>();

    public ParkingServiceImp(int carPlacesCount, int truckPlacesCount) {
        if (carPlacesCount < 0 || truckPlacesCount < 0) {
            throw new IllegalArgumentException("Places count must not be negative");
        }
        this.carPlaces = new String[carPlacesCount];
        this.truckPlaces = new String[truckPlacesCount];
    }

    @Override
    public boolean park(Automobile automobile) {
        if (automobile == null) {
            throw new IllegalArgumentException("Automobile must not be null");
        }

        if (allocations.containsKey(automobile.getNumber())) {
            return false;
        }

        if (automobile.isCar()) {
            return parkCar(automobile);
        }

        return parkTruck(automobile);
    }

    @Override
    public boolean leave(String automobileNumber) {
        Allocation allocation = allocations.remove(automobileNumber);
        if (allocation == null) {
            return false;
        }

        if (allocation.getType() == Allocation.Type.TRUCK_PLACE) {
            for (Integer index : allocation.getIndexes()) {
                truckPlaces[index] = null;
            }
        } else {
            for (Integer index : allocation.getIndexes()) {
                carPlaces[index] = null;
            }
        }

        return true;
    }

    @Override
    public boolean contains(String automobileNumber) {
        return allocations.containsKey(automobileNumber);
    }

    @Override
    public int getFreeCarPlaces() {
        int count = 0;
        for (String place : carPlaces) {
            if (place == null) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int getFreeTruckPlaces() {
        int count = 0;
        for (String place : truckPlaces) {
            if (place == null) {
                count++;
            }
        }
        return count;
    }

    private boolean parkCar(Automobile automobile) {
        for (int i = 0; i < carPlaces.length; i++) {
            if (carPlaces[i] == null) {
                carPlaces[i] = automobile.getNumber();
                allocations.put(
                        automobile.getNumber(),
                        new Allocation(Allocation.Type.CAR_PLACES, List.of(i))
                );
                return true;
            }
        }
        return false;
    }

    private boolean parkTruck(Automobile automobile) {
        for (int i = 0; i < truckPlaces.length; i++) {
            if (truckPlaces[i] == null) {
                truckPlaces[i] = automobile.getNumber();
                allocations.put(
                        automobile.getNumber(),
                        new Allocation(Allocation.Type.TRUCK_PLACE, List.of(i))
                );
                return true;
            }
        }

        List<Integer> indexes = findConsecutiveCarPlaces(automobile.getSize());
        if (indexes.isEmpty()) {
            return false;
        }

        for (Integer index : indexes) {
            carPlaces[index] = automobile.getNumber();
        }

        allocations.put(
                automobile.getNumber(),
                new Allocation(Allocation.Type.CAR_PLACES, indexes)
        );
        return true;
    }

    private List<Integer> findConsecutiveCarPlaces(int requiredSize) {
        int consecutive = 0;
        int start = -1;

        for (int i = 0; i < carPlaces.length; i++) {
            if (carPlaces[i] == null) {
                if (consecutive == 0) {
                    start = i;
                }
                consecutive++;

                if (consecutive == requiredSize) {
                    List<Integer> result = new ArrayList<>();
                    for (int j = start; j < start + requiredSize; j++) {
                        result.add(j);
                    }
                    return result;
                }
            } else {
                consecutive = 0;
                start = -1;
            }
        }

        return List.of();
    }

}