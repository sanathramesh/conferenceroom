package util;

import model.Building;
import model.Company;
import model.Floor;

import static util.StringValidator.stringValidator;

public class NewArtifactsAdder {

    public static void addBuilding(Company company, String buildingName) {
        boolean success = false;
        if(stringValidator(buildingName, "building")) {
            if(!company.containsBuilding(buildingName)) {
                company.addBuilding(buildingName);
                success = true;
            }
        }
        if(!success) {
            System.out.println("Failed to add building");
        } else {
            System.out.println("Successfully added building");
        }
    }

    public static void addFloor(Company company, String buildingName) {
        boolean success = false;
        if(stringValidator(buildingName, "building")) {
            if(company.containsBuilding(buildingName)) {
                Building building = company.getBuildingWithName(buildingName);
                building.addFloor();
                System.out.println("Added floor successfully");
                success = true;
            }
        }
        if(!success) {
            System.out.println("Failed to add floor");
        } else {
            System.out.println("Successfully added floor");
        }
    }

    public static void addConferenceRoom(Company company, String buildingName, int floorNumber, String conferenceRoomId,
                                         int capacity) {
        boolean success = false;
        if (stringValidator(buildingName, "building")) {
            if (company.containsBuilding(buildingName)) {
                Building building = company.getBuildingWithName(buildingName);
                if(building.getFloorList().size()>floorNumber || floorNumber<0) {
                    System.out.println("Invalid floor");
                } else {
                    Floor floor = building.getFloorWithNumber(floorNumber);
                    if(!floor.isConferenceRoomPresent(conferenceRoomId)) {
                        floor.addConferenceRoom(conferenceRoomId, capacity);
                        success = true;
                    }
                }
            }
        }

        if(!success) {
            System.out.println("Failed to add conference room");
        } else {
            System.out.println("Successfully added conference room");
        }

    }
}
