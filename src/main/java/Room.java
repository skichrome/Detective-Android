public class Room
{
    // Attributes : Name of room, ArrayList items, ArrayList pnj //

    private static int idForIncrement = 1;
    private int id;
    private String name;
    private String availableRooms;
    //private static String item;

    // NAME OF ROOM //

    public Room(String mName, String mAvailableRooms)
	 {
        this.id = idForIncrement++;
        this.name = mName;
        this.availableRooms = mAvailableRooms;
    }

    public String getName() { return name; }

    public String getAvailableRooms() { return availableRooms; }

    public String toString()
    {
      return "Localisation : Vous êtes dans "
      + name
      + System.lineSeparator()
      + "Vous allez inspecter : (Q pour quitter) "
      + System.lineSeparator()
      + availableRooms;
    }

    // CHOICE ROOM //

    // ITEMS OF ROOM //

    // public  String getItem() { return item; }

    // Methods : getRoom(), setRoom(), getAvailableItem(), getPnj(), getCorpse()
}
