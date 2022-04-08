package dataox;


import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private int finalFloorNumber;
    private Direction directionElevator;
    private final List<Passenger> passengersAreInElevator = new ArrayList<>();
    private List<Passenger> passengersEntryInElevator;
    private List<Passenger> passengersExitFromElevator;
    private int passengersInElevatorCount;

    public Elevator(Floor currentFloor) {
        passengersInElevatorCount = 0;
        finalFloorNumber = setFinalFloorNumber();
        directionElevator = Direction.UP;
    }

    public void enterNewPassengersToElevator(Floor currentFloor) {
        passengersEntryInElevator = new ArrayList<>();
        for (int i = 0; i < currentFloor.getPassengersOnTheFloor().size(); i++) {
            if (getDirectionElevator() == currentFloor.getPassengersOnTheFloor().get(i).getDirection() && getVacanciesInElevator() > 0) {
                passengersEntryInElevator.add(currentFloor.getPassengersOnTheFloor().get(i));
                passengersAreInElevator.add(currentFloor.getPassengersOnTheFloor().get(i));
                currentFloor.getPassengersOnTheFloor().remove(currentFloor.getPassengersOnTheFloor().get(i));
                passengersInElevatorCount = passengersInElevatorCount + 1;
            }
        }
    }

    public void exitPassengersFromElevator(Floor currentFloor) {
        passengersExitFromElevator = new ArrayList<>();
        for (int i = 0; i < passengersAreInElevator.size(); i++) {
            if (passengersAreInElevator.get(i).getNeededFloor() == currentFloor.getNumberFloor()) {
                passengersExitFromElevator.add(passengersAreInElevator.get(i));
                passengersAreInElevator.remove(passengersAreInElevator.get(i));
                passengersInElevatorCount = passengersInElevatorCount - 1;
            }
        }
    }

    public int getPassengersInElevatorCount() {
        return passengersInElevatorCount;
    }


    public int getVacanciesInElevator() {
        return 5 - getPassengersInElevatorCount();
    }

    public int setFinalFloorNumber() {
        for (Passenger passenger : passengersAreInElevator) {
            if (finalFloorNumber < passenger.getNeededFloor()) {
                finalFloorNumber = passenger.getNeededFloor();
            }
        }
        return finalFloorNumber;
    }


    public List<Passenger> getPassengersAreInElevator() {
        return passengersAreInElevator;
    }

    public List<Passenger> getPassengersEntryInElevator() {
        return passengersEntryInElevator;
    }

    public List<Passenger> getPassengersExitFromElevator() {
        return passengersExitFromElevator;
    }

    public Direction getDirectionElevator() {
        return directionElevator;
    }

    public void setDirectionElevator(Direction directionElevator) {
        this.directionElevator = directionElevator;
    }
}
