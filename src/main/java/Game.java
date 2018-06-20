import java.util.HashMap;

public class Game {

    private Room[] listRoom;
    private HashMap<Character, Integer> characterHashMap;
    private int position;

    public Game() {
        //Room configuration
        configureRoom();
        //PNJ configuration
        //Item configuration
    }

    public Room[] getListRoom() {
        return listRoom;
    }

    private void configureRoom() {
        Room kitchen = new Room(NameRoom.KITCHEN);
        Room hall = new Room(NameRoom.HALL);
        Room wc = new Room(NameRoom.WC);
        Room dormitory = new Room(NameRoom.BED_ROOM);
        Room library = new Room(NameRoom.LIBRARY);
        Room livingRoom = new Room(NameRoom.LIVING_ROOM);
        Room office = new Room(NameRoom.OFFICE);
        Room garden = new Room(NameRoom.GARDEN);

        this.listRoom = new Room[]{hall/*0*/, kitchen/*1*/, wc/*2*/, dormitory/*3*/, library/*4*/, livingRoom/*5*/, office/*6*/, garden/*7*/};
        this.bonusHashMap();
    }

    /*
     * At the beginning of the game
     * */
    public void introduction() {
        String intro = "Bienvenue dans le jeu Detective Java.\n" +
                "Votre objectif est de mener l'enquête sur une histoire de meurtre...\n";
        System.out.println(intro + "\n" + getListRoom()[position].toString());
    }

    /*
     * Not necessary but it works
     * **/
    public int setIndex(char choice) {
        switch (choice) {
            case 'H': //HALL
                return 0;
            case 'W': //WC
                return 2;
            case 'D': //Dortoir
                return 3;
            case 'S': //Salon
                return 5;
            case 'O': //Bureau
                return 6;
            case 'C': //Cuisine
                return 1;
            case 'J': //Jardin
                return 7;
            case 'B': // Biblio
                return 4;
            default:
                return 0;
        }
    }

    /*
     * Another approach, what do you think !?
     * */
    public void bonusHashMap() {
        // Bonus use of hashMap
        this.characterHashMap = new HashMap<>();
        characterHashMap.put('H', 0);//hall
        characterHashMap.put('C', 1);//kitchen
        characterHashMap.put('W', 2);//Wc
        characterHashMap.put('D', 3);//Dormitories
        characterHashMap.put('B', 4);//library
        characterHashMap.put('S', 5);//living-room
        characterHashMap.put('O', 6);//office
        characterHashMap.put('J', 7);//garden
    }

    /*
     * This gonna change in the future... (play/quit) if play => (move, observe) if move => we know it works, else if observe (TODO)
     * */
    public void checkPlayerChoice(char choice) {
        char[] availableChoice = this.getListRoom()[position].getAvailableChoice();
        char tmp = '\n';

        //loop into the char array
        for (char ch : availableChoice) {
            if (ch == choice) {
                tmp = ch;
            }
        }
        //Comparison between user input and array
        if (choice == tmp) {
//            position = this.setIndex(choice);
            position = this.characterHashMap.get(choice);
            System.out.println(this.listRoom[position]);
            //Prompt the player he is wrong !
        } else if (choice != tmp && choice != 'Q') {
            System.out.println("Mauvaise(s) touche(s) ! Merci de réitérer votre choix : ");
        }

    }

}
