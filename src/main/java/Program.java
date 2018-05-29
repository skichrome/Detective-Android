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
        //char previousChoice = 'H';
        char choice = 'H';
        /*
          Ma position de départ c'est le HALL
          on me demande de choisir une pièce
          je saisis une lettre
          si la lettre  == à la valeur attendu je passe à l'option suivante
          sinon je ressaisi une valeur tant que c'est pas bon
        */
        // while (true)
        // {

          // if(choice == 'H') {
            // printSelectionToConsole(mRoomList.get(0));
            //
            //
            //
            // while(choice != 'K' || choice != 'S' || choice != 'L') {
            //   if(){
            //     printSelectionToConsole(mRoomList.get(0));
            //   }
            //   else {
            //     System.out.println("Vous n'avez pas accès à cette salle. Changez votre sélection : ");
            //     choice = sc.nextLine().charAt(0);
            //   }
            //
            // }
          // }


//  VERSION DE AURELIA  //

          // printSelectionToConsole(mRoomList.get(0));
          // do {
          //     choice = sc.nextLine().charAt(0);
          // 			do{
          //
          //
          // 				if (choice == 'K' || choice == 'S' || choice == 'L') {
          //           printSelectionToConsole(mRoomList.get(0));
          // 				}
          //
          // 				// if users don't choose existing rooms
          // 				if (choice != 'K' && choice != 'S' && choice != 'L' && choice != 'H' && choice != 'Q')
          // 				{
          // 					System.out.println("Cette piece n'existe pas.");
          // 					System.out.println("");
          // 				}
          //
          // 			}while (choice != 'K' && choice != 'S' && choice != 'L' && choice != 'H' && choice != 'Q');
          // 		}while (choice != 'Q');








            // switch (choice)
            // {
            //     case 'H': //HALL
            //         printSelectionToConsole(mRoomList.get(0));
            //         System.out.println();
            //         previousChoice = choice;
            //         choice = sc.nextLine().charAt(0);
            //
            //         break;
            //
            //     case 'W': //WC
            //         printSelectionToConsole(mRoomList.get(1));
            //         previousChoice = choice;
            //         choice = sc.nextLine().charAt(0);
            //         break;
            //
            //     case 'C': //Chambre
            //         printSelectionToConsole(mRoomList.get(2));
            //         previousChoice = choice;
            //         choice = sc.nextLine().charAt(0);
            //         break;
            //
            //     case 'S': //Salon
            //         printSelectionToConsole(mRoomList.get(3));
            //         previousChoice = choice;
            //         choice = sc.nextLine().charAt(0);
            //         break;
            //
            //     case 'B': //Bureau
            //         printSelectionToConsole(mRoomList.get(4));
            //         previousChoice = choice;
            //         choice = sc.nextLine().charAt(0);
            //         break;
            //
            //     case 'K': //Cuisine
            //         printSelectionToConsole(mRoomList.get(5));
            //         previousChoice = choice;
            //         choice = sc.nextLine().charAt(0);
            //         break;
            //
            //     case 'G': //Jardin
            //         printSelectionToConsole(mRoomList.get(6));
            //         previousChoice = choice;
            //         choice = sc.nextLine().charAt(0);
            //         break;
            //
            //     case 'L': // Biblio
            //         printSelectionToConsole(mRoomList.get(7));
            //         previousChoice = choice;
            //         choice = sc.nextLine().charAt(0);
            //         break;
            //
            //     case 'Q': // Quitter
            //         return;
            //
            //     default:
            //         System.out.println("Cette pièce n'existe pas.\n");
            //         choice = previousChoice;
            //         break;
            // }


        //}
    }

    private static void printSelectionToConsole(Room roomOption)
    {
      String str = roomOption.toString();
        System.out.println(str);
    }
}
