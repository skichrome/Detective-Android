public enum NameRoom
{
	/*
	 * Todo Ajouter un champ dans l'énumération pour connaître les pièces possibles
	 * Pour personnaliser la méthode printSelectionToConsole()
	 */

	HALL("Le hall"),					// H
	WC("La salle de bain"),				// W
	BED_ROOM("La chambre"),				// C
	LIVING_ROOM("le salon"),			// S
	OFFICE("le bureau"),				// B
	KITCHEN("La cuisine"),				// K
	GARDEN("le jardin"),				// G
	LIBRARY("la bibliothèque");			// L

	private String name;

	//Constructeur
	NameRoom(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public String toString()
	{
		return name;
	}
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