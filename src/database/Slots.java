package database;

import model.*;

import java.util.ArrayList;
import java.util.List;

import static util.StringValidator.stringValidator;

public class Slots {
    private List<Slot> slots;

    public Slots() {
        this.slots = new ArrayList<>();
    }

    public void addSlots(String slotId, int slotStart, int slotEnd, String buildingName, int floorNumber,
                         String conferenceRoomId, String userId, Company company) {
        for(int i=0; i<this.getSlots().size(); i++) {
            Slot currentSlot = this.getSlots().get(i);
            if(currentSlot.getSlotId().equals(slotId)) {
                System.out.println("Slot id already present, please use different slot Id");
                return;
            }
        }
        boolean success = false;
        if(stringValidator(slotId, "slot Id") && stringValidator(buildingName, "building name")
        && stringValidator(conferenceRoomId, "conference room id") && Slot.validateSlot(slotStart, slotEnd)) {
            boolean failure = false;
            if(company.containsBuilding(buildingName)) {
                Building building = company.getBuildingWithName(buildingName);
                if(building.getFloorList().size()>=floorNumber || floorNumber<0) {
                    Floor floor = building.getFloorWithNumber(floorNumber);
                    //testing
                    for(int i =0; i<building.getFloorList().size(); i++){
                        System.out.println(building.getFloorList().get(i).getFloorNumber());
                    }

                    //
                    if(floor.isConferenceRoomPresent(conferenceRoomId)) {
                        for(int i=0; i<this.getSlots().size(); i++) {

                            Slot currentSlot = this.getSlots().get(i);

                            if(currentSlot.getConferenceRoomId().equals(conferenceRoomId)
                                    && currentSlot.getFloorNumber()==floorNumber &&
                                    currentSlot.getBuildingName().equals(buildingName) &&
                                    slotStart>=currentSlot.getSlotStart() &&
                                    slotStart<currentSlot.getSlotEnd()
                            ) {
                                failure = true;
                                break;
                            }
                        }
                        if(!failure) {
                            Slot slot = new Slot(slotId, slotStart, slotEnd, buildingName, floorNumber, conferenceRoomId, userId);
                            this.slots.add(slot);
                            success = true;
                        }
                    }
                }
            }
        }
        if(success) {
            System.out.println("slot booked");
        } else {
            System.out.println("Slot already taken");
        }
    }
    public void searchUserId(String userId) {
        for(int i=0; i<this.getSlots().size(); i++) {
            Slot currentSlot = this.getSlots().get(i);
            if(currentSlot.getUserId().equals(userId)) {
                currentSlot.printSlot();
            }
        }
    }

    public void searchUserIdBuildingName(String userId, String buildingName) {
        for(int i=0; i<this.getSlots().size(); i++) {
            Slot currentSlot = this.getSlots().get(i);
            if(currentSlot.getUserId().equals(userId) && currentSlot.getBuildingName().equals(buildingName)) {
                currentSlot.printSlot();
            }
        }
    }

    public void searchUserIdBuildingNameFloorNumber(String userId, String buildingName, int floorNumber) {
        for(int i=0; i<this.getSlots().size(); i++) {
            Slot currentSlot = this.getSlots().get(i);
            if(currentSlot.getUserId().equals(userId) && currentSlot.getBuildingName().equals(buildingName) &&
                    currentSlot.getFloorNumber()==floorNumber
            ) {
                currentSlot.printSlot();
            }
        }
    }





    public void removeSlot(String userId, String slotId, String buildingName, int floorNumber, String conferenceRoomId) {
        int slotIndex = -1;
        for (int i = 0; i < this.getSlots().size(); i++) {
            Slot currentSlot = this.getSlots().get(i);
            if(currentSlot.getSlotId().equals(slotId) && currentSlot.getUserId().equals(userId) &&
                    currentSlot.getBuildingName().equals(buildingName) &&
                    currentSlot.getFloorNumber()==floorNumber && currentSlot.getConferenceRoomId().equals(conferenceRoomId)
            ) {
                slotIndex = i;
            }
            if(slotIndex!=-1) {
                this.slots.remove(slotIndex);
                System.out.println("Slot removed successfully");
            } else {
                System.out.println("Slot cannot be deleted");
            }
        }
    }
    public List<Slot> getSlots() {
        return slots;
    }

    public boolean isSlotAvailable(int slotStart, int slotEnd, String conferenceRoomId) {
        for(int i=0; i<this.slots.size(); i++) {
            if(slotStart>= this.slots.get(i).getSlotStart() && slotStart<this.slots.get(i).getSlotEnd() &&
                    this.slots.get(i).getConferenceRoomId().equals(conferenceRoomId)
            ) {
                return false;
            }
        }
        return true;
    }
}
