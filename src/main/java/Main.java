import game.Game;

public class Main {
    public static void main(String[] args) {

        //VAR
        Game game = new Game();
        SplashScreen splashScreen = new SplashScreen();

        //************************
        // PLAY
        //************************

        splashScreen.displayAsciiWord("detective java");
        game.mainMenu();
    }
}


