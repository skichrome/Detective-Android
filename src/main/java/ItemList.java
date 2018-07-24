import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ItemList {

    private ArrayList<Items> itemList = new ArrayList<>();
    //limit the  number of item in a room
    private static int ITEM_LIMIT = 3;
    private Random generator = new Random();

    public ItemList() {
        this.setItemsToList();
    }

    private void setItemsToList() {
        itemList.addAll(Arrays.asList(Items.values()));
    }

    public ArrayList<Items> getItemsList() {
        return itemList;
    }

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
        //TODO fix illegalBoundExeception happen sometimes
    int itemID;
        if (numberOfItem > 0) {

            for (int i = 0; i <= numberOfItem; i++) {

                //get random item
                itemID = this.generator.nextInt(itemList.size()-1);
                //add it to the available list of the room
                room.addAvailableItemList(itemList.get(itemID));
                //remove it from the list
                itemList.remove(itemID);

            }
        }

    }
}
