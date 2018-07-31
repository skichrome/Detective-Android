package rooms;

public enum RoomList {

    HALL("le hall", "la bibliothèque (L),la cuisine (K),le salon (S)"),
    WC("la salle de bain", "le dortoir (B),le salon (S)"),
    BED_ROOM("le dortoir", "le bureau (F),la salle de bain (W)"),
    LIVING_ROOM("le salon", "le bureau (F),la cuisine (K),le hall (H),le jardin (J),la salle de bain (W)"),
    OFFICE("le bureau", "la bibliothèque (L),le dortoir (B),le salon (S)"),
    KITCHEN("la cuisine", "le hall (H),le salon (S)"),
    GARDEN("le jardin", "le salon (S)"),
    LIBRARY("la bibliothèque", "le bureau (F),le hall (H)");

    private String name;
    private String availableRooms;

    //Constructeur
    RoomList(String name, String availableRooms) {
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