public enum NameRoom {

    HALL("Le hall", "la cuisine (C),le salon (S),La biblio (B)"),
    WC("La salle de bain", "le jardin (J), le salon (S), le dortoir (D)"),
    BED_ROOM("Le dortoir", "la salle de bain (W),le bureau (O)"),
    LIVING_ROOM("le salon", "la cuisine (C),le hall (H),la salle de bain (W),le bureau (O),le jardin (J)"),
    OFFICE("le bureau", "la bibliothèque (B),le salon (S),le dortoir (D)"),
    KITCHEN("La cuisine", "le salon (S),le hall (H)"),
    GARDEN("le jardin", "la salle de bain (W),le salon (S)"),
    LIBRARY("la bibliothèque", "le hall (H),le bureau (O)");

    private String name;
    private String availableRooms;

    //Constructeur
    NameRoom(String name, String availableRooms) {
        this.name = name;
        this.availableRooms = availableRooms;
    }

    public String getAvailableRooms() {
        return availableRooms;
    }


    public String getName() {
        return name;
    }


    public String toString() {
        return name;
    }
}