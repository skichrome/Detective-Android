

import java.util.HashMap;
import java.util.Scanner;

public class Game {

    private Room[] listRoom;
    private HashMap<Character, Integer> characterHashMap;
    private int position;
    private Data slot = new Data();
    private String exceptionMessage = "Veuillez taper sur entrée qu'une fois la saisie effectué!";
    private Scanner sc = new Scanner(System.in);

    public Game() {
        //Room configuration
        configureRoom();
        //PNJ configuration
        //Item configuration
    }


    //******************************************************************************************************************
    //                                           ROOM CONFIGURATION
    //******************************************************************************************************************

    private Room[] getListRoom() {
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
        this.roomIndexPosition();

    }

    private void roomIndexPosition() {
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


    //******************************************************************************************************************
    //                                                PRINTING
    //******************************************************************************************************************

    private void printMainMenu() {
        System.out.println("\n********************\n" +
                "** MENU PRINCIPAL **\n" +
                "********************\n");

        System.out.println("Nouvelle partie (N)\n"
                + "Continuer la partie (C)\n"
                + "Quitter (Q)");
    }

    private void printActionMenu() {
        System.out.println("Listes des actions possibles :\n\t"
                + "-Se déplacer (D)\n\t"
                + "-Observer la zone (O)\n\t"
                + "-Retour menu principal (R)\n");
    }

    private void printGameMenu() {
        System.out.println("\n******************\n" +
                "** ECRAN DE JEU **\n" +
                "******************\n");
    }

    //******************************************************************************************************************
    //                                                   MENU
    //******************************************************************************************************************

    public void mainMenu() {
        char menuChoice = '\0';
        this.printMainMenu();

        do {
            try {
                menuChoice = sc.nextLine().toUpperCase().charAt(0);
            } catch (IndexOutOfBoundsException n) {
                System.err.println(exceptionMessage);
            } catch (NullPointerException e) {
                System.err.println(exceptionMessage + e.getMessage());
            }

            if (menuChoice != 'Q' && menuChoice != 'N' && menuChoice != 'C')
                System.err.println("Merci de sélectionner une des options proposées");

        } while (menuChoice != 'Q' && menuChoice != 'N' && menuChoice != 'C');

        //NEW GAME
        if (menuChoice == 'N') {
            this.newGame();
            //CONTINUE GAME
        } else if (menuChoice == 'C') {
            this.continueGame();
            //QUIT GAME
        } else {
            System.out.println("Au revoir !");
        }

    }

    private void actionMenu() {
        char actionChoice = '\0';
        this.printActionMenu();

        do {
            try {
                actionChoice = sc.nextLine().toUpperCase().charAt(0);
            } catch (IndexOutOfBoundsException n) {
                System.out.println(exceptionMessage);
            } catch (NullPointerException e) {
                System.out.println(exceptionMessage + e.getMessage());
            }

            if (actionChoice != 'R' && actionChoice != 'D' && actionChoice != 'O')
                System.err.println("Merci de sélectionner une des options proposées !");

        } while (actionChoice != 'R' && actionChoice != 'D' && actionChoice != 'O');
        //MOVE
        if (actionChoice == 'D') {
            this.moveIntoRoom();
            //OBSERVE
        } else if (actionChoice == 'O') {
            this.observeRoom();
            //BACK MENU
        } else {
            //Go back to the menu when finish the game
            System.out.println("=> Vous retournez au menu principal");
            this.mainMenu();
        }

    }

    private void newGame() {
        this.printGameMenu();
        //if user select the good input so we launch introduction...
        String intro = "Bienvenue dans le manoir Shikabuki, détective Kovac.\n" +
                "Votre objectif est de mener à bien l'enquête sur le meurtre d'un très grand diginitaire Maths." +
                "\nCe dernier a eu sa stack détruite..." +
                "\nVous devez chercher et trouver le coupable !\n";
        System.out.println(intro);
        //First thing to do check if there is a saving
        if (ifSaving()) {
            //if true we empty the file
            slot.saveRoom('\0');
            //initialise position to 0
            position = 0;
        }
        this.actionMenu();

    }

    private void continueGame() {
        //We need to check if the game have a saving first before
        if (!ifSaving()) {
            System.out.println("AUCUNE SAUVEGARDE TROUVEE !!! ");
            System.out.println("=> Vous allez débuter une nouvelle partie\n");
            this.newGame();
        } else {
            System.out.println("=> Vous reprenez votre partie !");
            this.actionMenu();
        }
    }

    //******************************************************************************************************************
    //                                                   ACTION
    //******************************************************************************************************************

    private int checkRoomPlayerChoice(char choice) {
        char[] availableChoice = this.getListRoom()[position].getAvailableChoice();
        char tmp = '\0';

        //loop into the char array
        for (char ch : availableChoice) {
            if (ch == choice) {
                tmp = ch;
                break;
            }
        }
        //Comparison between user input and array
        if (choice == tmp) {
            position = this.characterHashMap.get(tmp);
            slot.saveRoom(choice);
            //Prompt the player he is wrong !
        } else if (choice != 'A') {
            System.err.println("Mauvaise(s) touche(s) ! Merci de réitérer votre choix : ");
        }

        return position;
    }

    private void moveIntoRoom() {
        char choice = '\0';

        if (ifSaving()) {
            int pos = this.characterHashMap.get(slot.loadRoom());
            System.out.println(getListRoom()[pos].toString());
        } else {
            System.out.println(getListRoom()[position].toString());
        }


        do {
            try {
                choice = sc.nextLine().toUpperCase().charAt(0);
            } catch (IndexOutOfBoundsException n) {
                System.out.println(exceptionMessage);
            } catch (NullPointerException e) {
                System.out.println(exceptionMessage + e.getMessage());
            }

            if (choice != 'A')
                System.out.println(this.listRoom[checkRoomPlayerChoice(choice)]);

        } while (choice != 'A');
        System.out.println("=> Retour à la liste des actions\n");
        this.actionMenu();
    }

    private void observeRoom() {
        //L'indication de la pièce dans laquelle on est

        //Repartition des indices et des personnages au travers d'arrays (enumeration - 15 objets) Aurelia
        //2 shuffle entre le nombre d'objets et l'objet parmi une liste à afficher dans une pièce //Yann

        //retourne la liste des éléments présent dans la pièce actuelle avec condition
        System.out.println("Rien à observer pour l'instant");
    }

    //******************************************************************************************************************
    //                                                   UTILS
    //******************************************************************************************************************

    public Boolean ifSaving() {
        return slot.loadRoom() != '\0';
    }

    //Seems to be unusual
    private void getPlayerInput(char choice) {
        //Todo trouver pourqoui la variable fait déconner
//        char choice = '\0';
        try {
            choice = (char) (sc.next().toUpperCase().charAt(0));
        } catch (IndexOutOfBoundsException n) {
            System.out.println(exceptionMessage);
        } catch (NullPointerException e) {
            System.out.println(exceptionMessage + e.getMessage());
        }


    }
}
