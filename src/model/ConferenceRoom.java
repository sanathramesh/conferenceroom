package model;

public class ConferenceRoom {
    private int totalCapacity;
    private String roomId;

    public ConferenceRoom(String roomId, int totalCapacity) {
        this.roomId = roomId;
        this.totalCapacity = totalCapacity;
    }

    public String getRoomId() {
        return roomId;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }
}
