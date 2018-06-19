import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        char choice;

        int position = 0;
        Scanner sc = new Scanner(System.in);

        Game game = new Game();
        Room[] roomList = game.getListRoom();

        System.out.println(roomList[position]);
        Boolean isValid = false;//false

        choice = '\0';


        while (isValid || choice != 'Q') {
            choice = sc.nextLine().charAt(0);
            game.verifChoice(choice, position, isValid);
            if (choice == 'Q') {
                System.out.println("Au revoir !");
            } else {
                System.out.println("Mauvais choix");
            }
        }
    }
}


