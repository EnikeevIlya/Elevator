package dataox;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private final int numberFloor;
    private final List<Passenger> passengersOnTheFloor = new ArrayList<>();


    public Floor(int numberFloor, int maxFloorPassengerGo) {
        this.numberFloor = numberFloor;
        int startNumberOfPassengersOnTheFloor = RandomMaker.getRandomNumBetween(0, 10);
        for (int i = 0; i < startNumberOfPassengersOnTheFloor; i++) {
            String passengerName = "/F-" + numberFloor + " * P-" + i + "/";
            passengersOnTheFloor.add(new Passenger(this, maxFloorPassengerGo, passengerName));
        }
        System.out.printf("%d floor  |  %d passengers%n", numberFloor, startNumberOfPassengersOnTheFloor);
    }

    public List<Passenger> getPassengersOnTheFloor() {
        return passengersOnTheFloor;
    }

    public int getNumberFloor() {
        return numberFloor;
    }
}
