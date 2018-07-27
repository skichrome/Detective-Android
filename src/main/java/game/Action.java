package game;

import data.Data;
import items.Item;
import items.ItemList;
import player.Input;
import rooms.Room;

import java.util.ArrayList;
import java.util.Scanner;

public class Action implements Input {

    // CONSTANT
    public static int position;
    // INSTANTIATE
    private Item item = new Item();
    private Room room = new Room();
    private Data data = new Data();

    // Constructor
    public Action() {
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

    protected void moveIntoRoom(Scanner sc) {
        char choice = '\0';
        String exceptionMessage = "Veuillez taper sur entrée qu'une fois la saisie effectué!";
        // Check if there's a room saved otherwise launch room by default
        if (ifSaving()) {
            int pos = Room.characterHashMap.get(data.loadRoom());
            System.out.println(this.room.getListRoom()[pos].toString());
        } else {
            System.out.println(this.room.getListRoom()[position].toString());
        }

        do {
            try {
                choice = sc.nextLine().toUpperCase().charAt(0);
            } catch (IndexOutOfBoundsException n) {
                System.out.println(exceptionMessage);
            } catch (NullPointerException e) {
                System.out.println(exceptionMessage + e.getMessage());
            }

            if (choice != RETURN_ACTION_MENU)
                System.out.println(Room.listRoom[checkRoomPlayerChoice(choice)]);

        } while (choice != RETURN_ACTION_MENU);
        System.out.println("=> Retour à la liste des actions\n");
        Game game = new Game();
        game.actionMenu();
    }

    public void observeRoom() {

//        ArrayList<ItemList> availableItem = room.getListRoom()[position].getAvailableItem();
        if (item.getAvailableItem().size() > 0) {
            System.out.println(item.getAvailableItem());
        } else {
            System.out.println("Rien à observer pour l'instant\n");
        }
        //L'indication de la pièce dans laquelle on est

        //Repartition des indices et des personnages au travers d'arrays (enumeration - 15 objets) Aurelia
        //2 shuffle entre le nombre d'objets et l'objet parmi une liste à afficher dans une pièce //Yann

        //retourne la liste des éléments présent dans la pièce actuelle avec condition


        //System.out.println("Rien à observer pour l'instant" + getListRoom()[position].getAvailableItem());
        Game game = new Game();
        game.actionMenu();
    }

    //******************************************************************************************************************
    //                                                   UTILS
    //******************************************************************************************************************

    public Boolean ifSaving() {
        return data.loadRoom() != '\0';
    }
}
