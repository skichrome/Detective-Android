package utils;

import java.util.Scanner;

public interface PlayerInput {

    // INPUT VAR
    char NEW_GAME = 'N';
    char CONTINUE_GAME = 'C';
    char QUIT_GAME = 'Q';
    char MOVE_INTO_ROOM = 'D';
    char OBSERVE_ROOM = 'O';
    char RETURN_MAIN_MENU = 'R';
    char RETURN_ACTION_MENU = 'A';
    // ROOM INPUT
    char HALL = 'H';
    char KITCHEN = 'K';
    char WC = 'W';
    char DORMITORIES = 'B';
    char LIBRARY = 'L';
    char LIVING_ROOM = 'S';
    char OFFICE = 'F';
    char GARDEN = 'J';
    // ITEM INPUT
    char TAKE = 'T';
    char DROP = 'D';
    char SHOW_BACKPACK = 'B';
    char CHECK_INVENTORY = 'I';

    // ERROR MESSAGE
    String DISPLAY_ERROR_MESSAGE = "Merci de sélectionner une des options proposées";
    String DISPLAY_ERROR_MESSAGE_2 = "Vous devez indiquer un chiffre ici !";
    String BAD_INPUT_ALERT = "Mauvaise(s) touche(s) ! Merci de réitérer votre choix : ";
    String EXCEPTION_MESSAGE = "Veuillez taper sur entrée qu'une fois la saisie effectuée!";

    // Check main menu input loop
    default boolean checkMainMenuInput(char input) {
        return input != QUIT_GAME && input != NEW_GAME && input != CONTINUE_GAME;
    }

    // Check action menu input
    default boolean checkActionMenuInput(char input) {
        return input != RETURN_MAIN_MENU && input != MOVE_INTO_ROOM && input != CHECK_INVENTORY;
    }

    // Check action menu and observe
    default boolean checkMoveIntoRoom(char input) {
        return input != RETURN_ACTION_MENU && input != OBSERVE_ROOM;
    }

    // Check action menu input
    default boolean checkItemMenuInput(char input) {
        return input != TAKE && input != DROP && input != SHOW_BACKPACK;
    }

    // Get the player char input in the game
    default char getPlayerInput(Scanner sc) {
        char menuChoice = '\0';
        try {
            menuChoice = sc.nextLine().toUpperCase().charAt(0);
        } catch (IndexOutOfBoundsException n) {
            System.err.println(EXCEPTION_MESSAGE);
        } catch (NullPointerException e) {
            System.err.println(EXCEPTION_MESSAGE + e.getMessage());
        }
        return menuChoice;
    }

    // Get the player input in the game
    default int getPlayerInt(Scanner sc) {
        int intChoice = '\0';
        try {
            intChoice = sc.nextInt();
        } catch (IndexOutOfBoundsException n) {
            System.err.println(EXCEPTION_MESSAGE);
        } catch (NullPointerException e) {
            System.err.println(EXCEPTION_MESSAGE + e.getMessage());
        }
        return intChoice;
    }
}
