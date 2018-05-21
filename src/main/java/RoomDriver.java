

public class RoomDriver {

	public static void main(String[] args) {
		
		
		// NAME OF ROOM //
		
		Room room1 = new Room("le jardin");
		Room room2 = new Room("la salle de bain");
		Room room3 = new Room("la chambre");
		Room room4 = new Room("le salon");
		Room room5 = new Room("le bureau");
		Room room6 = new Room("la cuisine");
		Room room7 = new Room("le hall");
		Room room8 = new Room("la biblioth?que");
		

		Room [] tabRoom = {room1, room2, room3, room4, room5, room6, room7, room8};
		
		
		for(int i = 0; i < 8; i++) {
			
			System.out.println(tabRoom[i].toString());
			
		}
		
//		ArrayList<String> tabItem = new ArrayList<String>();
//
//		System.out.println(tabItem.size());
//		tabItem.add(Room.getItem());
		
	}

}
