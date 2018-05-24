public class Room
{
	private static int idForIncrement = 1;
	private int id;
	private String name;
	private static String item;

	public Room(String name)
	{
		this.id = idForIncrement++;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return "Localisation : Vous êtes dans " + name;
	}

	public static String getItem() {
		return item;
	}
}