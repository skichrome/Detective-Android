public class Room {

	// Attributes : Name of room, ArrayList items, ArrayList pnj //

	private static int idForIncrement = 1;
	private int id;
	private String name;
	private static String item;



	// NAME OF ROOM //

	public Room(String name) {
		this.id = idForIncrement++;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return "Localisation : Vous ?tes dans " + name;
	}








	// CHOICE ROOM //



	// ITEMS OF ROOM //

	public static String getItem() {
		return item;
	}







	// Methods : getRoom(), setRoom(), getAvailableItem(), getPnj(), getCorpse()
	//

}
