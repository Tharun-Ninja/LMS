import java.util.Scanner;
public class Menu {

    Database database = new Database();
    private int option;

//    private int validateOption(Scanner in){
//        try {
//            option = in.nextInt();
//        }
//        catch (InputMismatchException e){
//            System.out.println("Invalid Input");
//            System.exit(1);
//        }
//
//        return option;
//    }


    public int InitMenu(){
        System.out.print(
                "---------------------------------\n" +
                        "1. Enter as a librarian\n" +
                        "2. Enter as a member\n" +
                        "3. Exit\n" +
                        "---------------------------------\n"
        );

        Scanner in = new Scanner(System.in);
        option = database.validateInt("",in);

        return option;

    }

    public int librarianMenu(){
        System.out.println("current time: "+ (System.currentTimeMillis()/ 1000L));
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

        Scanner in = new Scanner(System.in);
        option = database.validateInt("",in);

        return option;
    }

    public int memberMenu(){
        System.out.print(
                "---------------------------------\n" +
                        "1. List Available Books\n" +
                        "2. List My Books\n" +
                        "3. Issue book\n" +
                        "4. Return book\n" +
                        "5. Pay Fine\n" +
                        "6. Back\n" +
                        "---------------------------------\n"
        );

        Scanner in = new Scanner(System.in);
        option = database.validateInt("",in);

        return option;
    }

    public void exit(){
        System.out.print(
                "---------------------------------\n" +
                        "Thanks for visiting!\n" +
                        "---------------------------------\n"
        );
        System.exit(0);
    }


}

