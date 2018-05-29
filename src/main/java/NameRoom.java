public enum NameRoom
{
	/*
	 * Todo Ajouter un champ dans l'énumération pour connaître les pièces possibles
	 * Pour personnaliser la méthode printSelectionToConsole()
	 */

	HALL("Le hall", "la cuisine (K)\nle salon (S)\nLa biblio (L)"),					// H
	WC("La salle de bain", "le jardin (G)\nle salon (S)\nla chambre (C)"),				// W
	BED_ROOM("La chambre", "la salle de bain (W)\nle bureau (B)"),				// C
	LIVING_ROOM("le salon", "la cuisine (K)\nle hall (H)\nla salle de bain (W)\nle bureau (B)\nle jardin (G)"),			// S
	OFFICE("le bureau", "la bibliothèque (L)\nle salon (S)\nla chambre (C)"),				// B
	KITCHEN("La cuisine", "le salon (S)\nle hall (H)"),				// K
	GARDEN("le jardin", "la salle de bain (W)\nle salon (S)"),				// G
	LIBRARY("la bibliothèque", "le hall (H)\nle bureau (B)");			// L

	private String name;
	private String availableRooms;

	//Constructeur
	NameRoom(String mName, String mAvailableRooms)
	{
		this.name = mName;
		this.availableRooms = mAvailableRooms;
	}

	public String getName() { return name; }

	public String getAvailableRooms() { return availableRooms; }

	public String toString() { return name; }
}


//public enum Volume
//{
//	HALL
//			{
//				@Override
//				public void access()
//				{
//					System.out.println(roomName.getName());
//					System.out.println("Vous allez inspecter : (Q pour quitter)");
//					System.out.println("");
//					System.out.println("la cuisine (K)");
//					System.out.println("le salon (S)");
//					System.out.println("la bibliothï¿½que (L)");
//					choice = sc.nextLine()
//							.charAt(0);
//
//
//				}
//			}, MEDIUM
//		{
//			@Override
//			public void alert()
//			{
//				System.out.println("Tout baigne.");
//
//			}
//		}, HIGH
//		{
//			@Override
//			public void alert()
//			{
//				System.out.println("Attention, c'est trop fort !");
//
//			}
//		};
//}
