import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomDriver
{
	public static void main(String[] args)
	{
		List<Room> rooms = configureRoomList();
		printMenu(rooms);
	}

	private static List<Room> configureRoomList()
	{
		List<Room> roomList = new ArrayList<>();

		for (NameRoom room : NameRoom.values())
			roomList.add(new Room(room.getName()));

		return roomList;
	}

	private static void printMenu(List<Room> mRoomList)
	{
		Scanner sc = new Scanner(System.in);
		char previousChoice = 'H';
		char choice = 'H';

		while (true)
		{
			switch (choice)
			{
				case 'H':
					printSelectionToConsole(mRoomList.get(0).toString());
					previousChoice = choice;
					choice = sc.nextLine().charAt(0);
					break;

				case 'K':
					printSelectionToConsole(mRoomList.get(5).toString());
					previousChoice = choice;
					choice = sc.nextLine().charAt(0);
					break;

				case 'S':
					printSelectionToConsole(mRoomList.get(3).toString());
					previousChoice = choice;
					choice = sc.nextLine().charAt(0);
					break;

				case 'L':
					printSelectionToConsole(mRoomList.get(7).toString());
					previousChoice = choice;
					choice = sc.nextLine().charAt(0);
					break;

				case 'Q':
					return;

				default:
					System.out.println("Cette pièce n'existe pas.\n");
					choice = previousChoice;
					break;
			}
		}
	}

	private static void printSelectionToConsole(String tabValue)
	{
		String str = tabValue + System.lineSeparator() +
				"Vous allez inspecter : (Q pour quitter)" + System.lineSeparator() +
				"la cuisine (K)" + System.lineSeparator() +
				"le hall (H)";
		System.out.println(str);
	}
}