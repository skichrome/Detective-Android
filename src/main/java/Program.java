import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        //VAR
        Scanner sc = new Scanner(System.in);
        Game game = new Game();

        //************************
        // PLAY
        //************************

        game.menuIteration(sc);


//        //Main loop
//        do {
//            try {
//                choice = sc.nextLine().toUpperCase().charAt(0);
//            } catch (IndexOutOfBoundsException n) {
//                System.out.println(exceptionMessage);
//            } catch (NullPointerException e) {
//                System.out.println(exceptionMessage + e.getMessage());
//            }
//            //New version
//            game.checkPlayerChoice(choice);
//
//            if (choice != 'R') {
//                save.saveRoom(choice);
//            }
//
//        } while (choice != 'R');
//        System.out.println("Au revoir !");



    }
}


