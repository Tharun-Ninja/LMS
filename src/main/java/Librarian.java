import java.util.Scanner;

public class Librarian{
    public static void printMenu(){
        System.out.print(
                "---------------------------------\n" +
                        "1. Register a member\n" +
                        "2. Remove a member\n" +
                        "3. Add a book\n" +
                        "4. Remove a book\n" +
                        "5. View all members along with their books and fines to be paid\n" +
                        "6. View all books\n" +
                        "7. Back\n" +
                        "---------------------------------\n"
        );
    }

    public static void registerMember(){
        // Do input validation
        // Update in maps
        System.out.print("Name: ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("Age: ");
        int age = new Scanner(System.in).nextInt();
        System.out.print("Phone no: ");
        int phone = new Scanner(System.in).nextInt();


    }

    public static void removeMember(){
        // Do input validation
        // Update in maps
        System.out.print("Name: ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("Phone no: ");
        int phone = new Scanner(System.in).nextInt();
    }

    public static void addBook(){
        // Do input validation
        // Update in maps
        System.out.print("Book title: ");
        String title = new Scanner(System.in).nextLine();
        System.out.print("Author: ");
        String author = new Scanner(System.in).nextLine();
        System.out.print("Copies: ");
        int Copies = new Scanner(System.in).nextInt();
    }
}