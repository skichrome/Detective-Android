import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ItemList {

    private ArrayList<Items> itemList = new ArrayList<>();
    //limit the  number of item in a room
    private static int ITEM_LIMIT = 3;
    private static int MINIMUM_ITEM_BY_GAME = 8;
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
    int count = 0;
        if (numberOfItem > 0) {

        	do {
        		  for (int i = 0; i <= numberOfItem; i++) {

        		      //get random item
        		      itemID = this.generator.nextInt(itemList.size());
        		      //add it to the available list of the room
        		      room.addAvailableItemList(itemList.get(itemID));
        		      //System.out.println(itemID);
        		      //remove it from the list
        		      //itemList.remove(itemID);
        		      count ++;

        		  }
        		} while (count <= MINIMUM_ITEM_BY_GAME);
        }

    }
}
