public enum NameRoom {

    HALL("le hall", "la bibliothèque (B),la cuisine (C),le salon (S)"),
    WC("la salle de bain", "le dortoir (D),le jardin (J),le salon (S)"),
    BED_ROOM("le dortoir", "le bureau (O),la salle de bain (W)"),
    LIVING_ROOM("le salon", "le bureau (O),la cuisine (C),le hall (H),le jardin (J),la salle de bain (W)"),
    OFFICE("le bureau", "la bibliothèque (B),le dortoir (D),le salon (S)"),
    KITCHEN("la cuisine", "le hall (H),le salon (S)"),
    GARDEN("le jardin", "la salle de bain (W),le salon (S)"),
    LIBRARY("la bibliothèque", "le bureau (O),le hall (H)");

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