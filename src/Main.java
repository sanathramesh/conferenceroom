import database.Slots;
import database.Users;
import model.Company;
import util.NewArtifactsAdder;
import util.Search;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Company Initialization
        System.out.println("Creating Company flow");
        Company company = new Company("Clear Trip");
        System.out.println(company.getCompanyName());
        System.out.println("\n\n\n");

        //Database Initialization
        Slots slots = new Slots();
        Users users = new Users();

        System.out.println("Adding users flow");
        users.addUser("sanath", "sanath");
        users.addUser("ramesh", "ramesh");

        System.out.println("\n\n\n");

        //Add building
        System.out.println("Adding building flow");
        NewArtifactsAdder.addBuilding(company, "b1");
        System.out.println("\n\n\n");

        //Add floor to that building
        System.out.println("Adding floor flow");
        NewArtifactsAdder.addFloor(company, "b1");
        System.out.println("\n\n\n");

        //Add conference room
        System.out.println("Adding conference room flow");
        NewArtifactsAdder.addConferenceRoom(company, "b1" , 1, "c1", 10);
        System.out.println("\n\n\n");


        System.out.println("booking slots flow");
        slots.addSlots("slot1", 11, 12, "b1", 1,
                "c1", "sanath", company);
        System.out.println("\n\n\n");


        System.out.println("listing a conference booking flow");
        Search.listBookings(company, "sanath", "b1", 1, slots);
        System.out.println("\n\n\n");


        System.out.println("listing available rooms for a slot flow, here capacity<=0 means we ignore capacity");
        Search.availableRooms(company, "sanath", 13, 14,"b1", 1, -1, slots );
        System.out.println("\n\n\n");


        System.out.println("Removing a slot");
        slots.removeSlot("sanath", "slot1", "b1", 1, "c1");
        System.out.println("\n\n\n");

    }
}