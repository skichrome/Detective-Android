package game;

import datas.Data;
import items.Item;
import items.ItemList;
import rooms.Room;
import utils.MenuUtility;
import utils.PlayerInput;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game implements PlayerInput, MenuUtility {

    //CONSTANT
    private static int POSITION;
    // VAR
    private Data data = new Data();
    private Scanner sc = new Scanner(System.in);
    private Item item = new Item();
    private Room room = new Room();
    private Utils utils = new Utils();
    private List<ItemList> backpack = new ArrayList<>();
    private ArrayList<ItemList> availableItem;

    public Game() {
        // configuration
        room.configureRoom();
        item.configureItem();
    }


    //******************************************************************************************************************
    //                                                   MENU
    //******************************************************************************************************************

    public void mainMenu() {
        char menuChoice;
        this.printMainMenu();

        do {
            menuChoice = getPlayerInput(sc);
            if (checkMainMenuInput(menuChoice))
                System.err.println(DISPLAY_ERROR_MESSAGE);
        } while (checkMainMenuInput(menuChoice));

        switch (menuChoice) {
            case NEW_GAME:
                this.newGame();
                break;
            case CONTINUE_GAME:
                this.continueGame();
                break;
            default:
                System.out.println("Au revoir !");
                System.exit(0);
                break;
        }
    }

    private void actionMenu() {
        char actionChoice;
        this.printActionMenu();

        do {
            actionChoice = getPlayerInput(sc);
            if (checkActionMenuInput(actionChoice))
                System.err.println(DISPLAY_ERROR_MESSAGE);
        } while (checkActionMenuInput(actionChoice));

        switch (actionChoice) {
            case MOVE_INTO_ROOM:
                this.moveIntoRoom(sc);
                break;
//            case OBSERVE_ROOM:
//                this.observeRoom();
//                break;
           case CHECK_INVENTORY:
               this.itemMenuInteraction();
               break;
            default:
                //Go back to the menu when finish the game
                System.out.println(" => Vous retournez au menu principal.");
                this.mainMenu();
                break;
        }
//        //MOVE
//        if (actionChoice == MOVE_INTO_ROOM) {
//            this.moveIntoRoom(sc);
//            //OBSERVE
//        } else if (actionChoice == OBSERVE_ROOM) {
//            this.observeRoom();
//
//            //BACK MENU
//        } else if (actionChoice == CHECK_INVENTORY) {
//            // Todo
//            this.itemMenuInteraction();
//        } else {
//            //Go back to the menu when finish the game
//            System.out.println(" => Vous retournez au menu principal.");
//            this.mainMenu();
//        }

    }

    private void newGame() {
        this.printGameMenu();
        //First thing to do check if there is a saving
        if (utils.ifSaving()) {
            //if true we empty the file
            data.saveRoom('\0');
            //initialise POSITION to 0
            POSITION = 0;
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
        char[] availableChoice = this.room.getListRoom()[POSITION].getAvailableChoice();
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
            POSITION = Room.characterHashMap.get(tmp);
            data.saveRoom(choice);
            //Prompt the player he is wrong !
        } else if (choice != RETURN_ACTION_MENU) {
            System.err.println(BAD_INPUT_ALERT);
        }
        return POSITION;
    }

    private void moveIntoRoom(Scanner sc) {
        char choice;
        // Check if there's a room saved otherwise launch room by default
        if (utils.ifSaving()) {
            int pos = Room.characterHashMap.get(data.loadRoom());
            System.out.println(this.room.getListRoom()[pos].toString());
        } else {
            System.out.println(this.room.getListRoom()[POSITION].toString());
        }

        do {
            choice = getPlayerInput(sc);
            if (checkMoveIntoRoom(choice)) {
                System.out.println(Room.listRoom[checkRoomPlayerChoice(choice)]);
            }
        } while (checkMoveIntoRoom(choice));

        if (choice == RETURN_ACTION_MENU) {
            System.out.println("=> Retour à la liste des actions\n");
            this.actionMenu();
        } else if (choice == OBSERVE_ROOM) {
            System.out.println("=> Vous observez la pièce");
            this.observeRoom();
        }

    }


    private void observeRoom() {
        this.availableItem = room.getListRoom()[POSITION].getAvailableItem();
        if (availableItem.size() > 0) {
            System.out.println("Après une brève inspection de la pièce, voici les objets disponibles : ");
            for (int i = 0; i < availableItem.size(); i++) {
                System.out.println("- (" + i + ") " + availableItem.get(i).getName());
            }

            System.out.println(System.lineSeparator());
        } else {
            System.out.println("Rien à observer pour l'instant\n");
        }
        this.itemMenuInteraction();
    }

    private void takeItem() {
        System.out.println("Renseigner un chiffre pour prendre l'objet :\n");
        int index = this.setItemIndex();
        this.backpack.add(this.availableItem.get(index));
        System.out.println("Vous avez mis dans votre sac : \n" + this.availableItem.get(index));
        this.availableItem.remove(index);
        // TODO
        this.showBackpackContent();
    }

    private void dropItem() {
        System.out.println("Renseigner un chiffre pour jeter l'objet :\n");
        int index = this.setItemIndex();
        ItemList itemToDrop = this.backpack.get(index);
        room.getListRoom()[POSITION].addAvailableItemList(itemToDrop);
        System.out.println("vous venez de jeter " + this.backpack.get(index).getName());
        this.backpack.remove(index);
        // TODO
        this.showBackpackContent();
    }

    // TODO Aurélia : Need to handle the case showBackpackContent method
      private void showBackpackContent() {
      	char choice;
          if (this.backpack.size() > 0) {
          	this.bagPackMenu();
              //System.out.println("Voici le contenu de votre sac : ");
              for (ItemList item : this.backpack) {
                  System.out.println("- " + item.getName() + "\n");
              }
          } else {

          	do {
          		this.EmptyBagPackMenu();
          		choice = getPlayerInput(sc);

          		if (choice == RETURN_ACTION_MENU) {
          			System.out.println("=> Retour à la liste des actions\n");
                  	this.actionMenu();
                  } else if (choice == RETURN_MAIN_MENU) {
                  	System.out.println("=> Retour au menu principal\n");
                  	this.mainMenu();
                  }
              } while (choice != RETURN_ACTION_MENU || choice != RETURN_MAIN_MENU);



          }
          //Todo : whatever the situation we need to do something here otherwise the game is over
      }

    private void itemMenuInteraction() {
        char itemChoice;
        this.printItemMenu();

        do {
            itemChoice = getPlayerInput(sc);
            if (checkItemMenuInput(itemChoice))
                System.err.println(DISPLAY_ERROR_MESSAGE);
        } while (checkItemMenuInput(itemChoice));

        switch (itemChoice) {
            case TAKE:
                this.takeItem();
                break;
//            case DROP:
//                this.dropItem();
//                break;
            case SHOW_BACKPACK:
                this.showBackpackContent();
                break;
            case RETURN_ACTION_MENU:
                System.out.println("=> Retour à la liste des actions\n");
                this.actionMenu();
                break;
            default:
                break;
        }
    }

    private int setItemIndex() {
        int index;
        do {
            index = getPlayerInt(sc);
            if (index < 0 || index >= this.availableItem.size())
                System.err.println(DISPLAY_ERROR_MESSAGE_2);
        } while (index < 0 || index >= this.availableItem.size());

        return index;
    }

}
