package player;

import java.util.Scanner;

public interface Input {

    String exceptionMessage = "Veuillez taper sur entrée qu'une fois la saisie effectué!";
    char NEW_GAME = 'N';
    char CONTINUE_GAME = 'C';
    char QUIT_GAME = 'Q';
    char MOVE_INTO_ROOM = 'D';
    char OBSERVE_ROOM = 'O';
    char RETURN_MAIN_MENU = 'R';
    char RETURN_ACTION_MENU = 'A';
    String BAD_INPUT_ALERT = "Mauvaise(s) touche(s) ! Merci de réitérer votre choix : ";

    // Check main menu input loop
    default boolean checkMainMenuInput(char input) {
        return input != QUIT_GAME && input != NEW_GAME && input != CONTINUE_GAME;
    }

    // Check action menu input
    default boolean checkActionMenuInput(char input) {
        return input != RETURN_MAIN_MENU && input != MOVE_INTO_ROOM && input != OBSERVE_ROOM;
    }

    //Seems to be unusual
    default void setPlayerInput(Scanner sc, char choice) {
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
