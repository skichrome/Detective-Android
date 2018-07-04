import java.util.HashMap;
import java.util.Scanner;

public class Game {

    private Room[] listRoom;
    private HashMap<Character, Integer> characterHashMap;
    private int position;
    private Save slot = new Save();
    private String exceptionMessage = "Veuillez taper sur entrée qu'une fois la saisie effectué!";

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
        this.findRoomPositionWithPlayerInput();

    }

    /*
     * Another approach, what do you think !?
     * */
    public void findRoomPositionWithPlayerInput() {
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
     * This gonna change in the future... (play/quit) if play => (move, observe) if move => we know it works, else if observe => (TODO)
     * */
    public void checkPlayerChoice(char gameChoice) {
        char[] availableChoice = this.getListRoom()[position].getAvailableChoice();
        char tmp = '\n';

        //loop into the char array
        for (char ch : availableChoice) {
            if (ch == gameChoice) {
                tmp = ch;
                break;
            }
        }
        //Comparison between user input and array
        if (gameChoice == tmp) {
//            position = this.setIndex(choice); Yann version ;)
            position = this.characterHashMap.get(gameChoice); // hashMap version
            System.out.println(this.listRoom[position]);
            //Prompt the player he is wrong !
        } else if (gameChoice != 'R') {
            System.out.println("Mauvaise(s) touche(s) ! Merci de réitérer votre choix : ");
        }

    }

    /*
     * At the beginning of the game
     * */
    public void introduction(Scanner sc) {
        String intro = "Bienvenue dans le jeu Detective Java.\n" +
                "Votre objectif est de mener l'enquête sur une histoire de meurtre...\n";
        System.out.println(intro + "\n" + getListRoom()[position].toString());

        //When introduction is called we launch the game
        gameIteration(sc);

    }


    private char getPlayerInput(Scanner sc) {

        //Todo trouver pourqoui la variable fait déconner
        char choice = '\0';
        try {
            choice = sc.nextLine().toUpperCase().charAt(0);
        } catch (IndexOutOfBoundsException n) {
            System.out.println(exceptionMessage);
        } catch (NullPointerException e) {
            System.out.println(exceptionMessage + e.getMessage());
        }
        return choice;

    }

    private void printMenu() {
        System.out.println("********************\n" +
                "** MENU PRINCIPAL **\n" +
                "********************\n");

        System.out.println("Nouvelle partie (N)\n"
                + "Continuer la partie (C)\n"
                + "Quitter (Q)");
    }

    public void menuIteration(Scanner sc) {
        char choice = '\0';
        printMenu();
        do {
            try {
                choice = sc.nextLine().toUpperCase().charAt(0);
            } catch (IndexOutOfBoundsException n) {
                System.out.println(exceptionMessage);
            } catch (NullPointerException e) {
                System.out.println(exceptionMessage + e.getMessage());
            }

            if (choice == 'N')
                newGame(sc);
            if (choice == 'C')
                continueGame();

            if (choice != 'Q')
                System.out.println("Merci de sélectionner une des options proposées");

        } while (choice != 'Q');
        System.out.println("Au revoir !");

    }


    private void gameIteration(Scanner sc) {
        char choice = '\0';
        do {
            try {
                choice = sc.nextLine().toUpperCase().charAt(0);
            } catch (IndexOutOfBoundsException n) {
                System.out.println(exceptionMessage);
            } catch (NullPointerException e) {
                System.out.println(exceptionMessage + e.getMessage());
            }
            //New version
            checkPlayerChoice(choice);
            //Possible to add plenty method here

            if (choice != 'R') {
                slot.saveRoom(choice);
            }

        } while (choice != 'R');
        //Go back to the menu when finish the game
        menuIteration(sc);
    }

    private void newGame(Scanner sc) {
        //if user select the good input so we launch introduction...
        introduction(sc);

    }

    private void continueGame() {
        //if user select the good input so we launch the load info (i there is a load info other wise it's introduction
        slot.loadRoom();
    }

}
