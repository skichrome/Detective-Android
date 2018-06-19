public class Game {

    private Room[] listRoom;

    public Game() {
        //Room configuration
        configureRoom();
        //PNJ configuration
        //Item configuration
    }

    public Room[] getListRoom() {
        return listRoom;
    }

    private void configureRoom(){
        Room kitchen = new Room(NameRoom.KITCHEN);
        Room hall = new Room(NameRoom.HALL);
        Room wc = new Room(NameRoom.WC);
        Room bedroom = new Room(NameRoom.BED_ROOM);
        Room library = new Room(NameRoom.LIBRARY);
        Room livingRoom = new Room(NameRoom.LIVING_ROOM);
        Room office = new Room(NameRoom.OFFICE);
        Room garden = new Room(NameRoom.GARDEN);

        this.listRoom = new Room[]{hall/*0*/, kitchen/*1*/, wc/*2*/, bedroom/*3*/, library/*4*/, livingRoom/*5*/, office/*6*/, garden/*7*/};
    }
    public int setIndex(char choice) {
        switch (choice) {
            case 'H': //HALL
                return 0;

            case 'W': //WC
                return 2;

            case 'C': //Chambre
                return 3;

            case 'S': //Salon
                return 5;

            case 'B': //Bureau
                return 6;

            case 'K': //Cuisine
                return 1;

            case 'G': //Jardin
                return 8;

            case 'L': // Biblio
                return 7;

            default:
                return 0;
        }

    }

    public void verifChoice(char choice, int position, Boolean isValid){
        char[] availableChoice = this.listRoom[position].getAvailableChoice();
        for (char ch : availableChoice) {
            // on parcourt le tableau de choix de caractère
            if (choice == ch) {
                //si le choix est égal à ce qu'on trouve dans le tableau
                position = this.setIndex(choice);
                System.out.println(this.listRoom[position]);
                isValid = true;
            }
        }

    }
}
