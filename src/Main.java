//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    static String[] guests = new String[10];
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        insetTestNames();
        System.out.println();

        do {
            displayGuests();
            displayMenu();
            int option = getOption();

            if (option == 1) {
                addGuest();

            } else if (option == 2) {
                removeGuest();
            }
            else if (option == 3) {
                renameGuest();
            }
            else if (option == 4) {
                insertGuest();
            }
            else if (option == 5) {
                break;
            }


        } while (true);

        System.out.println("Exiting...");
    }

    static void displayGuests() {
        System.out.println("____________________\n- Guests -\n");

        int num = 0;
        for (int i = 0; i < guests.length; i++) {

            if(guests[i] != null) {
                num++;
                System.out.print(num + ". " );
                System.out.println(guests[i]);

            }
        }
        if (num==0) {
            System.out.println("Guest list is empty.");
        }


    }

    static void displayMenu() {
        System.out.println("____________________\n- Menu -\n");
        System.out.println("1 - Add Guest");
        System.out.println("2 - Remove Guest");
        System.out.println("3 - Rename Guest");
        System.out.println("4 - Enter a spot and guest");
        System.out.println("5 - Exit");
    }

    static int getOption() {
        System.out.print("Option : ");
        int option = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return option;
    }

    static void addGuest() {
        for(int i = 0; i < guests.length; i++) {
            if(guests[i] == null) {
                System.out.print("Name: ");
                guests[i] = scanner.nextLine();
                break;
            }
        }
    }
    static void renameGuest() {
        System.out.print("Number of rename: ");
        int numOfGuest = scanner.nextInt();
        scanner.nextLine();
        if (guests[numOfGuest -1] != null) {
            System.out.print("RE-Name: ");
            guests[numOfGuest -1] = scanner.nextLine();
        }
        else {
            System.out.println("Error: There is no guest with that number.");
        }
    }

    static void insertGuest() {
        System.out.print("Which number do you want to add?: ");
        int spot = scanner.nextInt();
        scanner.nextLine();
        if (spot >= 1 && spot <= 10 && guests[spot - 1] != null) {
            System.out.print("Enter name of the guest: ");
            String name = scanner.nextLine();

            for(int i = guests.length - 1; i > spot - 1; i--) {
                guests[i] = guests[i - 1];
            }
            guests[spot - 1] = name;
        } else {
            System.out.println("Error: There is a guest with that number.");
        }
    }

    static void insetTestNames() {
        guests[0] = "jacob jones";
        guests[1] = "edward jones";
        guests[2] = "debora kwon";
        guests[3] = "molly jones";
        guests[4] = "chris null";
    }

    static void removeGuest() {
        System.out.print("Number of the name: ");
        int num = scanner.nextInt();
        if (num >= 1 && num <= 10 && guests[num -1] != null) {

            for (int i = 0; i < guests.length; i++) {
                if (guests[i] != null && i == num - 1) {
                    while (i < guests.length - 1) {
                        guests[i] = guests[i + 1];
                        i++;
                    }


                }
            }

        }
        else {
            System.out.println("Error: There is no guest with that number.");
        }
    }
}