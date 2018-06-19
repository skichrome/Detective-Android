import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        char choice;
        char[] availableChoice;
        int position = 0;
        Scanner sc = new Scanner(System.in);

        Game game = new Game();
        Room[] roomList = game.getListRoom();

//        System.out.println(roomList[position]);

        availableChoice = roomList[position].getAvailableChoice();
        System.out.println(roomList[position].getAvailableRoomsName().length);
        for (String str : roomList[position].getAvailableRoomsName()) {
            System.out.println(str);
        }
        for (char ch : availableChoice) {
            System.out.println(ch);
        }
        choice = sc.next().charAt(0);
//        while (choice)

    }

}


