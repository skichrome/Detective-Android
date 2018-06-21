import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        //VAR
        Scanner sc = new Scanner(System.in);
        Game game = new Game();
        String exceptionMessage = "Veuillez taper sur entrée qu'une fois la saisie effectué!";
        Character choice = '\0';

        //************************
        // PLAY
        //************************

        //Introduction :
        game.introduction();

        //Main loop
        do {
            try {
                choice = sc.nextLine().toUpperCase().charAt(0);
            } catch (IndexOutOfBoundsException n) {
                System.out.println(exceptionMessage);
            } catch (NullPointerException e) {
                System.out.println(exceptionMessage + e.getMessage());
            }
            //New version
            game.checkPlayerChoice(choice);

        } while (choice != 'Q');
        System.out.println("Au revoir !");
    }
}


