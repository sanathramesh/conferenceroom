package model;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private int floorNumber;
    private List<ConferenceRoom> roomList;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.roomList = new ArrayList<>();
    }

    public void addConferenceRoom(String name, int totalCapacity) {
        ConferenceRoom conferenceRoom = new ConferenceRoom(name, totalCapacity);
        this.roomList.add(conferenceRoom);
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ConferenceRoom> getRoomList() {
        return roomList;
    }

    public boolean isConferenceRoomPresent(String name) {
        for(int i=0; i<this.getRoomList().size(); i++) {
            if(getRoomList().get(i).getRoomId().equals(name)) {
                System.out.println("Room with name : " + name + " is already present");
                return true;
            }
        }
        return false;
    }
}
