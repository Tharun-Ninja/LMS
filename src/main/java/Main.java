import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        System.out.println("\nLibrary Portal Initialized….");
        System.out.print(
                "---------------------------------\n" +
                "1. Enter as a librarian\n" +
                "2. Enter as a member\n" +
                "3. Exit\n" +
                "---------------------------------\n"
        );
        Scanner in = new Scanner(System.in);
        int option = -1;
        try{
            option = in.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("Input not Valid");
            System.exit(1);
        }


        // Checking if Librarian
        if(option == 1){

        }
        // Checking if Member
        else if (option == 2){

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
