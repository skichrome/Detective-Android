package utils;

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

    // ERROR MESSAGE
    String DISPLAY_ERROR_MESSAGE = "Merci de sélectionner une des options proposées";
    String BAD_INPUT_ALERT = "Mauvaise(s) touche(s) ! Merci de réitérer votre choix : ";
    String EXCEPTION_MESSAGE = "Veuillez taper sur entrée qu'une fois la saisie effectuée!";

    // Check main menu input loop
    default boolean checkMainMenuInput(char input) {
        return input != QUIT_GAME && input != NEW_GAME && input != CONTINUE_GAME;
    }

    // Check action menu input
    default boolean checkActionMenuInput(char input) {
        return input != RETURN_MAIN_MENU && input != MOVE_INTO_ROOM;
    }

    // Check action menu and observe
    default boolean checkMoveIntoRoom(char input) {
        return input != RETURN_ACTION_MENU && input != OBSERVE_ROOM;
    }
}
