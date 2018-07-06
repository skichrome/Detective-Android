import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        //VAR
        Scanner sc = new Scanner(System.in);
        Game game = new Game();
        SplashScreen splashScreen = new SplashScreen();
        String exceptionMessage = "Veuillez taper sur entrée qu'une fois la saisie effectué!";
        char choice = '\0';

        //************************
        // PLAY
        //************************

        splashScreen.displayAsciiWord("detective java");
        game.mainMenu();

    }
}


