package model;

public class Slot {
    private String slotId;
    private int slotStart;
    private int slotEnd;
    private String buildingName;
    private int floorNumber;
    private String conferenceRoomId;
    private String userId;

    public Slot(String slotId, int slotStart, int slotEnd, String buildingName, int floorNumber,
                String conferenceRoomId, String userId) {
        this.slotId = slotId;
        this.slotStart = slotStart;
        this.slotEnd = slotEnd;
        this.buildingName = buildingName;
        this.floorNumber = floorNumber;
        this.conferenceRoomId = conferenceRoomId;
        this.userId = userId;
    }

    public static boolean validateSlot(int slotStart, int slotEnd) {
        if(slotStart<slotEnd && slotStart>=0 && slotStart<=24 && slotEnd>=0 && slotEnd<=24) {
            return true;
        }
        System.out.println("Invalid slot");
        return false;

    }

    public String getSlotId() {
        return slotId;
    }

    public int getSlotStart() {
        return slotStart;
    }

    public int getSlotEnd() {
        return slotEnd;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public String getConferenceRoomId() {
        return conferenceRoomId;
    }

    public String getUserId() {
        return userId;
    }

    public void printSlot() {
        System.out.println("slot Id : " + this.slotId + " slotStart : " + this.slotStart + " slotEnd : "
                + slotEnd + " building : " + this.buildingName + " floor : " + this.floorNumber + " conference room number : " +
                this.conferenceRoomId);
    }
}
