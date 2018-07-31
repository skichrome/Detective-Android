package game;

import datas.Data;
import items.Item;
import items.ItemList;
import rooms.Room;
import utils.PlayerInput;
import utils.Utils;

import java.util.ArrayList;
import java.util.Scanner;

public class Game implements PlayerInput {

    //     CONSTANT
    private static int position;
    //     VAR
    private Data data = new Data();
    private Scanner sc = new Scanner(System.in);
    private Item item = new Item();
    private Room room = new Room();
    private Utils utils = new Utils();

    public Game() {
        // configuration
        room.configureRoom();
        item.configureItem();
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
                System.err.println(EXCEPTION_MESSAGE);
            } catch (NullPointerException e) {
                System.err.println(EXCEPTION_MESSAGE + e.getMessage());
            }

            if (checkMainMenuInput(menuChoice))
                System.err.println(DISPLAY_ERROR_MESSAGE);

        } while (checkMainMenuInput(menuChoice));

        //NEW GAME
        if (menuChoice == NEW_GAME) {
            this.newGame();
            //CONTINUE GAME
        } else if (menuChoice == CONTINUE_GAME) {
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
                System.out.println(EXCEPTION_MESSAGE);
            } catch (NullPointerException e) {
                System.out.println(EXCEPTION_MESSAGE + e.getMessage());
            }

            if (checkActionMenuInput(actionChoice))
                System.err.println(DISPLAY_ERROR_MESSAGE);

        } while (checkActionMenuInput(actionChoice));
        //MOVE
        if (actionChoice == MOVE_INTO_ROOM) {
            this.moveIntoRoom(sc);
            //OBSERVE
        } else if (actionChoice == OBSERVE_ROOM) {
            this.observeRoom();
            //BACK MENU
        } else {
            //Go back to the menu when finish the game
            System.out.println(" => Vous retournez au menu principal.");
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
        if (utils.ifSaving()) {
            //if true we empty the file
            data.saveRoom('\0');
            //initialise position to 0
            position = 0;
        }
        this.actionMenu();

    }

    private void continueGame() {
        //We need to check if the game have a saving first before
        if (!utils.ifSaving()) {
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
        char[] availableChoice = this.room.getListRoom()[position].getAvailableChoice();
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
            position = Room.characterHashMap.get(tmp);
            data.saveRoom(choice);
            //Prompt the player he is wrong !
        } else if (choice != RETURN_ACTION_MENU) {
            System.err.println(BAD_INPUT_ALERT);
        }

        return position;
    }

    private void moveIntoRoom(Scanner sc) {
        char choice = '\0';
        // Check if there's a room saved otherwise launch room by default
        if (utils.ifSaving()) {
            int pos = Room.characterHashMap.get(data.loadRoom());
            System.out.println(this.room.getListRoom()[pos].toString());
        } else {
            System.out.println(this.room.getListRoom()[position].toString());
        }

        do {
            try {
                choice = sc.nextLine().toUpperCase().charAt(0);
            } catch (IndexOutOfBoundsException n) {
                System.out.println(EXCEPTION_MESSAGE);
            } catch (NullPointerException e) {
                System.out.println(EXCEPTION_MESSAGE + e.getMessage());
            }


            if (choice != RETURN_ACTION_MENU)
                System.out.println(Room.listRoom[checkRoomPlayerChoice(choice)]);

        } while (choice != RETURN_ACTION_MENU);
        System.out.println("=> Retour à la liste des actions\n");

        this.actionMenu();
    }

    private void observeRoom() {

        ArrayList<ItemList> availableItem = room.getListRoom()[position].getAvailableItem();
        if (availableItem.size() > 0) {
            System.out.println("Après une brève inspection de la pièce, voici les objets disponibles : ");
            for (ItemList item : availableItem) {
                System.out.println("- " + item.getName());
            }
            System.out.println(System.lineSeparator());
        } else {
            System.out.println("Rien à observer pour l'instant\n");
        }

        this.actionMenu();
    }

}
