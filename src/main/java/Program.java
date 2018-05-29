//Todo Proposition d'optimisation : A discuter ^^

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program
{
    public static void main(String[] args)
    {
        List<Room> rooms = configureRoomList();
        printMenu(rooms);
    }

    public static List<Room> configureRoomList()
    {
        List<Room> roomList = new ArrayList<>();

        for (NameRoom room : NameRoom.values())
            roomList.add(new Room(room.getName(), room.getAvailableRooms()));

        return roomList;
    }

    private static void printMenu(List<Room> mRoomList)
    {
        Scanner sc = new Scanner(System.in);
        char previousChoice = 'H';
        char choice = 'H';

        while (true)
        {
            switch (choice)
            {
                case 'H': //HALL
                    printSelectionToConsole(mRoomList.get(0));
                    System.out.println();
                    previousChoice = choice;
                    choice = sc.nextLine().charAt(0);
                    break;

                case 'W': //WC
                    printSelectionToConsole(mRoomList.get(1));
                    previousChoice = choice;
                    choice = sc.nextLine().charAt(0);
                    break;

                case 'C': //Chambre
                    printSelectionToConsole(mRoomList.get(2));
                    previousChoice = choice;
                    choice = sc.nextLine().charAt(0);
                    break;

                case 'S': //Salon
                    printSelectionToConsole(mRoomList.get(3));
                    previousChoice = choice;
                    choice = sc.nextLine().charAt(0);
                    break;

                case 'B': //Bureau
                    printSelectionToConsole(mRoomList.get(4));
                    previousChoice = choice;
                    choice = sc.nextLine().charAt(0);
                    break;

                case 'K': //Cuisine
                    printSelectionToConsole(mRoomList.get(5));
                    previousChoice = choice;
                    choice = sc.nextLine().charAt(0);
                    break;

                case 'G': //Jardin
                    printSelectionToConsole(mRoomList.get(6));
                    previousChoice = choice;
                    choice = sc.nextLine().charAt(0);
                    break;

                case 'L': // Biblio
                    printSelectionToConsole(mRoomList.get(7));
                    previousChoice = choice;
                    choice = sc.nextLine().charAt(0);
                    break;

                case 'Q': // Quitter
                    return;

                default:
                    System.out.println("Cette pièce n'existe pas.\n");
                    choice = previousChoice;
                    break;
            }
        }
    }

    private static void printSelectionToConsole(Room roomOption)
    {
      String str = roomOption.toString();
        System.out.println(str);
    }
}
