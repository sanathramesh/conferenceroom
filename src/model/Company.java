package model;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String companyName;
    private List<Building> buildingList;

    public Company(String name) {
        if(name==null) {
            System.out.println("Company name cant be null");
        } else {
            this.companyName = name;
            this.buildingList = new ArrayList<>();
        }
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Building> getBuildingList() {
        return buildingList;
    }

    public boolean containsBuilding(String buildingName) {
        for(int i=0; i<buildingList.size(); i++) {
            if(buildingList.get(i).getBuildingName().equals(buildingName)) {
                System.out.println("building is already present in the company");
                return true;
            }
        }
        return false;
    }

    public void addBuilding(String name) {
        if(name==null || name.trim().length()==0) {
            System.out.println("----Invalid Building name, name cant be null or length 0----");
            return;
        }
        name = name.trim();
        Building building = new Building(name);
        this.buildingList.add(building);
    }

    public Building getBuildingWithName(String buildingName) {
        for(int i=0; i<buildingList.size(); i++) {
            if(buildingList.get(i).getBuildingName().equals(buildingName)) {
                return buildingList.get(i);
            }
        }
        return null;
    }
}
