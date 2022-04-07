package dataox;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private final int totalFloors;
    private final List<Floor> allFloorsInTheBuilding = new ArrayList<>();
    private final Elevator elevator;


    public Building() {
        totalFloors = RandomMaker.getRandomNumBetween(5, 20);
        for (int i = 0; i < totalFloors; i++) {
            allFloorsInTheBuilding.add(new Floor(i + 1, totalFloors));
        }
        elevator = new Elevator(allFloorsInTheBuilding.get(0));
        System.out.printf("-------------------------------------%n" +
                "Created new building  with %d floors%n" +
                "-------------------------------------%n", totalFloors);
    }

    public boolean isThereAnyPassengersInBuilding() {
        int counterOfAllPassengersInBuilding = 0;
        for (Floor floor : allFloorsInTheBuilding) {
            counterOfAllPassengersInBuilding = counterOfAllPassengersInBuilding + floor.getPassengersOnTheFloor().size();
        }
        return counterOfAllPassengersInBuilding == 0;
    }

    public int getAllCountOfFloors() {
        return allFloorsInTheBuilding.size();
    }

    public Elevator getElevator() {
        return elevator;
    }

    public Floor getCurrentFloor(int index) {
        return allFloorsInTheBuilding.get(index);
    }

    public int getTotalFloors() {
        return totalFloors;
    }
}
