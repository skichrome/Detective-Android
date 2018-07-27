package items;

import rooms.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Item {

    //limit the  number of item in a room
    private static int ITEM_LIMIT = 3;
    private static int MINIMUM_ITEM_BY_GAME = 8;
    private ArrayList<ItemList> itemList = new ArrayList<>();
    private Random generator = new Random();

    // Constructor
    public Item() {
        this.setItemsToList();
    }

    // Getter & Setter

    public ArrayList<ItemList> getItemsList() {
        return itemList;
    }

    private void setItemsToList() {
        itemList.addAll(Arrays.asList(ItemList.values()));
    }

    public ArrayList<ItemList> getAvailableItem() {
        return this.getItemsList();
    }

    // ITEM Method
    private void shuffleItemsIntoRooms(Room[] listRoom) {
        //random generator to shuffle number
        int numberOfItem;
        for (Room room : listRoom) {
            //number of item by room
            numberOfItem = this.generator.nextInt(ITEM_LIMIT);
            attributeItemToRoom(numberOfItem, room);
        }
    }

    private void attributeItemToRoom(int numberOfItem, Room room) {
        //TODO fix illegalBoundExeception happen sometimes
        int itemID;
        int count = 0;
        if (numberOfItem > 0) {

            do {
                for (int i = 0; i <= numberOfItem; i++) {

                    //get random item
                    itemID = this.generator.nextInt(itemList.size());
                    //add it to the available list of the room
                    addAvailableItemList(itemList.get(itemID));
                    //System.out.println(itemID);
                    //remove it from the list
                    //itemList.remove(itemID);
                    count++;

                }
            } while (count <= MINIMUM_ITEM_BY_GAME);
        }

    }


    public void addAvailableItemList(ItemList item) {
        this.getItemsList().add(item);
    }

    public void configureItem() {
        shuffleItemsIntoRooms(Room.listRoom);
        for (Room room : Room.listRoom) {
//            System.out.println("liste des items disponibles dans " + room.getName() + " : " + getAvailableItem());
        }
    }
}
