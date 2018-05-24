import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program
{
	public static void main(String[] args) {

		// NAME OF ROOM //

		Room room1 = new Room("le hall");                // H
		Room room2 = new Room("la salle de bain");        // W
		Room room3 = new Room("la chambre");            // C
		Room room4 = new Room("le salon");                // S
		Room room5 = new Room("le bureau");                // B
		Room room6 = new Room("la cuisine");            // K
		Room room7 = new Room("le jardin");                // G
		Room room8 = new Room("la bibliotheque");        // L


		Room[] tabRoom = {room1, room2, room3, room4, room5, room6, room7, room8};

		List<Room> roomList = new ArrayList<>();

		for (NameRoom room : NameRoom.values())
			roomList.add(new Room(room.getName()));

		// 	for (NameRoom roomName : NameRoom.values()) {
		// 	System.out.println(roomName.getName());
		// }

		Scanner sc = new Scanner(System.in);
		//char wish = ' ';
		char choice = ' ';
		do {

			do {

				if (choice == ' ' | choice == 'H') {
					System.out.println(tabRoom[0].toString());
					// System.out.println("Vous allez inspecter : (Q pour quitter)");
					// System.out.println("");
					// System.out.println("la cuisine (K)");
					// System.out.println("le salon (S)");
					// System.out.println("la biblioth�que (L)");
					choice = sc.nextLine().charAt(0);
				} else if (choice == 'K') {

					printSelectionToConsole(roomList.get(0).toString());
//

					// System.out.println(tabRoom[5].toString());
					// System.out.println("Vous allez inspecter : (Q pour quitter)");
					// System.out.println("");
					// System.out.println("le hall (H)");
					// System.out.println("le salon (S)");

					choice = sc.nextLine().charAt(0);
				} else if (choice == 'S') {
					System.out.println(tabRoom[3].toString());
					System.out.println("Vous allez inspecter : (Q pour quitter)");
					System.out.println("");
					System.out.println("la cuisine (K)");
					System.out.println("le hall (H)");
					choice = sc.nextLine().charAt(0);
				} else if (choice == 'L') {
					System.out.println(tabRoom[7].toString());
					System.out.println("Vous allez inspecter : (Q pour quitter)");
					System.out.println("");
					System.out.println("le hall (H)");
					choice = sc.nextLine().charAt(0);
				}

				// if users don't choose existing rooms
				if (choice != 'K' && choice != 'S' && choice != 'L' && choice != 'H' && choice != 'Q') {
					System.out.println("Cette pi�ce n'existe pas.");
					System.out.println("");
				}

			} while (choice != 'K' && choice != 'S' && choice != 'L' && choice != 'H' && choice != 'Q');

//			do{
//				//System.out.println("Souhaitez-vous continuer � explorer ? (O/N)");
//				wish = sc.nextLine().charAt(0);
//				}while (wish != 'Q');

		} while (choice != 'Q');


	}

	private static void printSelectionToConsole(String tabValue) {
		String str = tabValue + "\n\n" + "Vous allez inspecter : (Q pour quitter)" +
				"\n\n" + "la cuisine (K)" +
				"\n\n" + "le hall (H)";

		System.out.println(str);
	}
}

// Todo Proposition d'optimisation : A discuter ^^

//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Program
//{
//	public static void main(String[] args)
//	{
//		List<Room> rooms = configureRoomList();
//		printMenu(rooms);
//	}
//
//	private static List<Room> configureRoomList()
//	{
//		List<Room> roomList = new ArrayList<>();
//
//		for (NameRoom room : NameRoom.values())
//			roomList.add(new Room(room.getName()));
//
//		return roomList;
//	}
//
//	private static void printMenu(List<Room> mRoomList)
//	{
//		Scanner sc = new Scanner(System.in);
//		char previousChoice = 'H';
//		char choice = 'H';
//
//		while (true)
//		{
//			switch (choice)
//			{
//				case 'H':
//					printSelectionToConsole(mRoomList.get(0).toString());
//					previousChoice = choice;
//					choice = sc.nextLine().charAt(0);
//					break;
//
//				case 'K':
//					printSelectionToConsole(mRoomList.get(5).toString());
//					previousChoice = choice;
//					choice = sc.nextLine().charAt(0);
//					break;
//
//				case 'S':
//					printSelectionToConsole(mRoomList.get(3).toString());
//					previousChoice = choice;
//					choice = sc.nextLine().charAt(0);
//					break;
//
//				case 'L':
//					printSelectionToConsole(mRoomList.get(7).toString());
//					previousChoice = choice;
//					choice = sc.nextLine().charAt(0);
//					break;
//
//				case 'Q':
//					return;
//
//				default:
//					System.out.println("Cette pièce n'existe pas.\n");
//					choice = previousChoice;
//					break;
//			}
//		}
//	}
//
//	private static void printSelectionToConsole(String tabValue)
//	{
//		String str = tabValue + System.lineSeparator() +
//				"Vous allez inspecter : (Q pour quitter)" + System.lineSeparator() +
//				"la cuisine (K)" + System.lineSeparator() +
//				"le hall (H)";
//		System.out.println(str);
//	}