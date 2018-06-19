public class Game {

    private Room[] listRoom;

    public Game() {
        Room kitchen = new Room(NameRoom.KITCHEN);
        Room hall = new Room(NameRoom.HALL);
        Room wc = new Room(NameRoom.WC);
        Room bedroom = new Room(NameRoom.BED_ROOM);
        Room library = new Room(NameRoom.LIBRARY);
        Room livingRoom = new Room(NameRoom.LIVING_ROOM);
        Room office = new Room(NameRoom.OFFICE);
        Room garden = new Room(NameRoom.GARDEN);

        this.listRoom = new Room[]{hall, kitchen, wc, bedroom, library, livingRoom, office, garden};
    }

    public Room[] getListRoom() {
        return listRoom;
    }
}
