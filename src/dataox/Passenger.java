package dataox;

public class Passenger {
    private Direction direction;
    private int neededFloor;
    private final int currentFloor;
    private final String name;

    public Passenger(Floor thisFloor, int maxFloorPassengerGo, String name) {
        currentFloor = thisFloor.getNumberFloor();
        setNeededFloor();
        this.name = name;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getNeededFloor() {
        return neededFloor;
    }

    private void setDirection() {
        if (currentFloor < neededFloor) {
            direction = Direction.UP;
        } else {
            direction = Direction.DOWN;
        }
    }

    public void setNeededFloor() {
        do {
            neededFloor = RandomMaker.getRandomNumBetween(1, 20);
        }
        while (neededFloor == currentFloor);
        setDirection();
    }

    public void changeNeededFloor(Building building) {
        do {
            this.neededFloor = RandomMaker.getRandomNumBetween(1, building.getTotalFloors());
        }
        while (neededFloor == currentFloor);
        setDirection();
    }

    public String getName() {
        return name;
    }
}
