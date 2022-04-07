package dataox;

public class Dispatcher {
    private int currentFloor;

    public void moveElevator() {
        Building building = new Building();
        while (true) {
            if (building.getElevator().getDirectionElevator() == Direction.UP) {
                for (currentFloor = 0; currentFloor < building.getAllCountOfFloors(); currentFloor++) {
                    actionOnTheFloor(building);
                    if (building.isThereAnyPassengersInBuilding() && building.getElevator().getPassengersAreInElevator().isEmpty()) {
                        building.getElevator().setDirectionElevator(Direction.STOPPED);
                        break;
                    }
                }
                if (building.getElevator().getDirectionElevator() == Direction.UP) {
                    building.getElevator().setDirectionElevator(Direction.DOWN);
                } else building.getElevator().setDirectionElevator(Direction.STOPPED);
            } else if (building.getElevator().getDirectionElevator() == Direction.DOWN) {
                for (currentFloor = currentFloor - 1; currentFloor >= 1; currentFloor--) {
                    actionOnTheFloor(building);
                    if (building.isThereAnyPassengersInBuilding() && building.getElevator().getPassengersAreInElevator().isEmpty()) {
                        building.getElevator().setDirectionElevator(Direction.STOPPED);
                        break;
                    }
                }
                if (building.getElevator().getDirectionElevator() == Direction.DOWN) {
                    building.getElevator().setDirectionElevator(Direction.UP);
                } else building.getElevator().setDirectionElevator(Direction.STOPPED);
            } else {
                System.out.println("There are no active passengers in the building, so elevator STOPPED");
                break;
            }
        }
    }


    private void actionOnTheFloor(Building building) {
        for (int i = 0; i < building.getCurrentFloor(currentFloor).getPassengersOnTheFloor().size(); i++) {
            building.getCurrentFloor(currentFloor).getPassengersOnTheFloor().get(i).changeNeededFloor(building);
        }
        building.getElevator().exitPassengersFromElevator(building.getCurrentFloor(currentFloor));
        building.getElevator().enterNewPassengersToElevator(building.getCurrentFloor(currentFloor));
        showFloorElevatorStatistics(building);
    }


    private void showFloorElevatorStatistics(Building building) {
        System.out.printf("============== Floor %d ============== %n", currentFloor + 1);
        System.out.printf("%d people were left waiting for the elevator to leave: ", building.getCurrentFloor(currentFloor).getPassengersOnTheFloor().size());
        for (int j = 0; j < building.getCurrentFloor(currentFloor).getPassengersOnTheFloor().size(); j++) {
            System.out.printf("%s, ", building.getCurrentFloor(currentFloor).getPassengersOnTheFloor().get(j).getName());
        }
        System.out.printf("%n%d people entry in elevator: ", building.getElevator().getPassengersEntryInElevator().size());
        for (int z = 0; z < building.getElevator().getPassengersEntryInElevator().size(); z++) {
            System.out.printf("%s, ", building.getElevator().getPassengersEntryInElevator().get(z).getName());
        }
        System.out.printf("%n%d people exit from elevator: ", building.getElevator().getPassengersExitFromElevator().size());
        for (int j = 0; j < building.getElevator().getPassengersExitFromElevator().size(); j++) {
            System.out.printf("%s, ", building.getElevator().getPassengersExitFromElevator().get(j).getName());
        }
        System.out.printf("%n%d passengers in elevator now: ", building.getElevator().getPassengersAreInElevator().size());
        for (int k = 0; k < building.getElevator().getPassengersInElevatorCount(); k++) {
            System.out.printf("%s - need exit on %s floor; ", building.getElevator().getPassengersAreInElevator().get(k).getName(), building.getElevator().getPassengersAreInElevator().get(k).getNeededFloor());
        }
        System.out.printf("%nThere are %d free places in elevator.", building.getElevator().getVacanciesInElevator());
        if (building.getElevator().getPassengersAreInElevator().size() == 5) {
            System.out.printf("%nELEVATOR IS FULL");
        }
        System.out.printf("%nElevator is going %s", building.getElevator().getDirectionElevator());
        System.out.printf("%n");
    }
}

