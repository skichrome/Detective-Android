package rooms;

import items.ItemList;
import utils.PlayerInput;

import java.util.ArrayList;
import java.util.HashMap;

public class Room implements PlayerInput {
    // Attributes : Name of room, ArrayList items, ArrayList pnj //

    // CONSTANT
    public static HashMap<Character, Integer> characterHashMap;
    public static Room[] listRoom;
    // VAR
    private String name;
    private String[] availableRoomsName;
    private char[] availableChoice;
    private ArrayList<ItemList> availableItemList = new ArrayList<>();

    public Room() {

    }

    public Room(RoomList name) {
        this.name = name.getName();
        setAvailableRoomName(name);
        setAvailableChoice();
    }

    private void setAvailableRoomName(RoomList roomName) {
        this.availableRoomsName = roomName.getAvailableRooms().split(",");
    }

    public String getName() {
        return name;
    }

    public String[] getAvailableRoomsName() {
        return availableRoomsName;
    }

    private void setAvailableChoice() {
        //position 2 en partant de la fin
        // ex : la cuisine (K)
        int position = 2;
        this.availableChoice = new char[this.availableRoomsName.length];
        for (int i = 0; i < this.availableRoomsName.length; i++) {
            this.availableChoice[i] = availableRoomsName[i].charAt(availableRoomsName[i].length() - position);
        }

    }


    //******************************************************************************************************************
    //                                           ROOM CONFIGURATION
    //******************************************************************************************************************

    public Room[] getListRoom() {
        return listRoom;
    }

    public void configureRoom() {
        Room kitchen = new Room(RoomList.KITCHEN);
        Room hall = new Room(RoomList.HALL);
        Room wc = new Room(RoomList.WC);
        Room dormitory = new Room(RoomList.BED_ROOM);
        Room library = new Room(RoomList.LIBRARY);
        Room livingRoom = new Room(RoomList.LIVING_ROOM);
        Room office = new Room(RoomList.OFFICE);
        Room garden = new Room(RoomList.GARDEN);

        listRoom = new Room[]{hall/*0*/, kitchen/*1*/, wc/*2*/, dormitory/*3*/, library/*4*/, livingRoom/*5*/, office/*6*/, garden/*7*/};
        this.roomIndexPosition();
    }

    private void roomIndexPosition() {
        // Bonus use of hashMap
        characterHashMap = new HashMap<>();
        characterHashMap.put(HALL, 0);//hall
        characterHashMap.put(KITCHEN, 1);//kitchen
        characterHashMap.put(WC, 2);//Wc
        characterHashMap.put(DORMITORIES, 3);//Dormitories
        characterHashMap.put(LIBRARY, 4);//library
        characterHashMap.put(LIVING_ROOM, 5);//living-room
        characterHashMap.put(OFFICE, 6);//office
        characterHashMap.put(GARDEN, 7);//garden
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Localisation : Vous êtes dans ")
                .append(name)
                .append(System.lineSeparator())
                .append("Vous pouvez inspecter : ")
                .append(System.lineSeparator());

        for (String element : availableRoomsName) {
            str.append("-");
            str.append(element);
            str.append(System.lineSeparator());
        }
        str.append(System.lineSeparator())
                .append("-Retourner au menu des actions (A)")
//                .append(System.lineSeparator())
//                .append("-Observer la zone (O)")
                .append(System.lineSeparator())
                .append("Indiquez votre choix :");

        return str.toString();

    }

    //******************************************************************************************************************
    //                                           ITEM'S ROOM METHODS
    //******************************************************************************************************************

    public char[] getAvailableChoice() {
        return availableChoice;
    }

    public void addAvailableItemList(ItemList item) {
        this.availableItemList.add(item);
    }

    public ArrayList<ItemList> getAvailableItem() {
        return this.availableItemList;
    }

}
