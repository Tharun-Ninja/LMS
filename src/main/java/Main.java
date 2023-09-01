import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        System.out.println("\nLibrary Portal Initialized….");
        int option = -1;

        while(true){
            Init();
            // Add input validation
            option = new Scanner(System.in).nextInt();

            // Checking if Librarian
            if(option == 1){
                loop: while(true){
                    Librarian.printMenu();
                    option = new Scanner(System.in).nextInt();
                    switch (option){
                        case 1:
                            Librarian.registerMember();
                            break;

                        case 2:
                            Librarian.removeMember();
                            break;

                        case 3:
                            Librarian.addBook();
                            break;

                        case 4:
                            Librarian.removeBook();
                            break;

                        case 5:
                            Librarian.viewAllMembers();
                            break;

                        case 6:
                            Librarian.veiwAllBooks();
                            break;

                        case 7:
                            break loop;
                    }
                }
            }
            // Checking if Member
            else if (option == 2){
                System.out.print("Name: ");
                System.out.print("Phone no: ");

                // check member if valid

                loop: while(true){
                    Member.printMenu();
                    option = new Scanner(System.in).nextInt();



                    switch (option){
                        case 1:
                            Member.viewAvailableBooks();
                            break;

                        case 2:
                            Member.viewMyBooks();
                            break;

                        case 3:
                            Member.issueBook();
                            break;

                        case 4:
                            Member.returnBook();
                            break;

                        case 5:
                            Member.payFine();
                            break;

                        case 6:
                            break loop;
                    }
                }
            }
            // Exit
            else if(option == 3){
                System.out.print(
                        "---------------------------------\n" +
                                "Thanks for visiting!\n" +
                                "---------------------------------\n"
                );
            }
            else {
                System.out.println("Invalid Input");
                System.exit(1);
            }
        }

    }


    public static void Init(){
        System.out.print(
                "---------------------------------\n" +
                        "1. Enter as a librarian\n" +
                        "2. Enter as a member\n" +
                        "3. Exit\n" +
                        "---------------------------------\n"
        );
    }

}
