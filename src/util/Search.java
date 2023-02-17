package util;

import database.Slots;
import model.*;

import java.util.List;

import static util.StringValidator.stringValidator;

public class Search {
    public static void listBookings(Company company, String userId, String buildingName, int floor, Slots slots) {
        if(stringValidator(userId, "user Id")) {
            if(stringValidator(buildingName, "building name") && company.containsBuilding(buildingName)) {
                Building building = company.getBuildingWithName(buildingName);
                if(building.getFloorList().size()>=floor && floor >0) {
                    slots.searchUserIdBuildingNameFloorNumber(userId, buildingName, floor);
                } else {
                    slots.searchUserIdBuildingName(userId, buildingName);
                }
            } else {
                slots.searchUserId(userId);
            }
        }
    }

    public static void availableRooms(Company company, String userId, int slotStart, int slotEnd, String buildingName,
                                       int floorNumber, int capacity, Slots slots) {
        System.out.println("Available rooms for given slot are :");
        if(stringValidator(userId, "user Id")) {
            if (stringValidator(buildingName, "building name") && company.containsBuilding(buildingName)) {
                Building building = company.getBuildingWithName(buildingName);
                if (building.getFloorList().size() >= floorNumber && floorNumber > 0) {
                    Floor floor = building.getFloorWithNumber(floorNumber);
                    printAvailableRooms(floor.getRoomList(), capacity, slots, slotStart, slotEnd,
                            buildingName, floorNumber);
                } else {
                    List<Floor> floorList = building.getFloorList();
                    for(int j=0; j<floorList.size(); j++) {
                        Floor floor = floorList.get(j);
                        printAvailableRooms(floor.getRoomList(), capacity, slots, slotStart, slotEnd,
                                buildingName, floorNumber);
                    }
                }
            } else {
                List<Building> buildingList = company.getBuildingList();
                for(int k=0; k<buildingList.size(); k++) {
                    Building building = buildingList.get(k);
                    List<Floor> floorList = building.getFloorList();
                    for(int j=0; j<floorList.size(); j++) {
                        Floor floor = floorList.get(j);
                        printAvailableRooms(floor.getRoomList(), capacity, slots, slotStart, slotEnd,
                                buildingName, floorNumber);
                    }
                }
            }
        }
    }

    public static void printAvailableRooms(List<ConferenceRoom> conferenceRooms, int capacity, Slots slots, int slotStart,
                                    int slotEnd, String buildingName, int floorNumber) {
        for(int i=0; i<conferenceRooms.size(); i++) {
            if(slots.isSlotAvailable(slotStart, slotEnd, conferenceRooms.get(i).getRoomId()) &&
                    (capacity <= 0 || conferenceRooms.get(i).getTotalCapacity() >= capacity)
            ) {
                System.out.println("building : " + buildingName + " floorNumber :" + floorNumber
                        + " conference room Id : " + conferenceRooms.get(i));
            }
        }
    }
}
