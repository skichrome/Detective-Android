

public enum NameRoom {


	HALL("Le hall", "la cuisine (K),le salon (S),La biblio (L)"),					// H
	WC("La salle de bain", "le jardin (G), le salon (S), la chambre (C)"),				// W
	BED_ROOM("La chambre", "la salle de bain (W),le bureau (B)"),				// C
	LIVING_ROOM("le salon", "la cuisine (K),le hall (H),la salle de bain (W),le bureau (B),le jardin (G)"),			// S
	OFFICE("le bureau", "la bibliothèque (L),le salon (S),la chambre (C)"),				// B
	KITCHEN("La cuisine", "le salon (S),le hall (H)"),				// K
	GARDEN("le jardin", "la salle de bain (W),le salon (S)"),				// G
	LIBRARY("la bibliothèque", "le hall (H),le bureau (B)");			// L

	private String name;
	private String availableRooms;

	//Constructeur
	NameRoom(String name, String availableRooms){
		this.name = name;
		this.availableRooms = availableRooms;
	}

	public String getAvailableRooms() { return availableRooms; }



	public String getName() {
		return name;
	}



	public String toString(){
		return name;
	}
}