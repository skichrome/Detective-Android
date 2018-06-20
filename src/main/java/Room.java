

public class Room {
    // Attributes : Name of room, ArrayList items, ArrayList pnj //

    private String name;
    private String[] availableRoomsName;
    private  char[] availableChoice;

    //private static String item;
    //private NameRoom nameRoom;

    // NAME OF ROOM //

    public Room(NameRoom name) {
        this.name = name.getName();
        setAvailableRoomName(name);
        setAvailableChoice();
    }

    private void setAvailableRoomName(NameRoom roomName) {
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

    public char[] getAvailableChoice() {
        return availableChoice;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Localisation : Vous êtes dans ");
        str.append(name);
        str.append(System.lineSeparator());
        str.append("Vous pouvez inspecter : (Q pour quitter) ");
        str.append(System.lineSeparator());

        for (String element : availableRoomsName) {
            str.append("-");
            str.append(element);
            str.append(System.lineSeparator());
        }

        str.append("\nIndiquez votre choix :");
        return str.toString();

    }

    // CHOICE ROOM //

    // ITEMS OF ROOM //

    // public  String getItem() { return item; }

    // Methods : getRoom(), setRoom(), getAvailableItem(), getPnj(), getCorpse()
}
