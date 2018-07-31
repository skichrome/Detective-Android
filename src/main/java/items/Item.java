package items;

import rooms.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Item {

    //limit the  number of item in a room
    private static int ITEM_LIMIT = 3;
    private ArrayList<ItemList> itemList = new ArrayList<>();
    private Random generator = new Random();

    // Constructor
    public Item() {
        this.setItemsToList();
    }

    // Getter & Setter
    private void setItemsToList() {
        itemList.addAll(Arrays.asList(ItemList.values()));
    }


    // ITEM Method
    public void shuffleItemsIntoRooms(Room[] listRoom) {
        //random generator to shuffle number
        int numberOfItem;
        for (Room room : listRoom) {
            //number of item by room
            numberOfItem = this.generator.nextInt(ITEM_LIMIT);
            attributeItemToRoom(numberOfItem, room);
        }
    }

    private void attributeItemToRoom(int numberOfItem, Room room) {

        int itemID;

        for (int i = 0; i <= numberOfItem; i++) {
            if (itemList.size() > 1) {
                //get random item
                itemID = this.generator.nextInt(itemList.size());
                //add it to the available list of the room
                room.addAvailableItemList(itemList.get(itemID));
                //remove it from the list
                itemList.remove(itemID);
            }
        }
    }


    public void configureItem() {
        shuffleItemsIntoRooms(Room.listRoom);
        for (Room room : Room.listRoom) {
//            System.out.println("liste des items disponibles dans " + room.getName() + " : " + room.getAvailableItem());
        }
    }
}
