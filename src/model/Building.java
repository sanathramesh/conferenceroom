package model;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private String buildingName;
    private List<Floor> floorList;

    public Building(String buildingName) {
        this.buildingName = buildingName;
        this.floorList = new ArrayList<>();
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public List<Floor> getFloorList() {
        return floorList;
    }

    public void addFloor() {
        int currentFloors = floorList.size();
        Floor newFloor = new Floor(currentFloors+1);
        this.floorList.add(newFloor);
    }

    public Floor getFloorWithNumber(int floorNumber) {
        for(int i=0; i<this.floorList.size(); i++) {
            if(floorList.get(i).getFloorNumber()==floorNumber) {
                return floorList.get(i);
            }
        }
        return null;
    }
}
