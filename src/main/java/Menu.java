import java.util.Scanner;
public class Menu {

    Database database = new Database();
    private int option;

    public int InitMenu(){
        System.out.print(
                """
                        ---------------------------------
                        1. Enter as a librarian
                        2. Enter as a member
                        3. Exit
                        ---------------------------------
                        """
        );

        Scanner in = new Scanner(System.in);
        option = database.validateInt("",in);

        return option;

    }

    public int librarianMenu(){
        System.out.print(
                """
                        ---------------------------------
                        1. Register a member
                        2. Remove a member
                        3. Add a book
                        4. Remove a book
                        5. View all members along with their books and fines to be paid
                        6. View all books
                        7. Back
                        ---------------------------------
                        """
        );

        Scanner in = new Scanner(System.in);
        option = database.validateInt("",in);

        return option;
    }

    public int memberMenu(){
        System.out.print(
                """
                        ---------------------------------
                        1. List Available Books
                        2. List My Books
                        3. Issue book
                        4. Return book
                        5. Pay Fine
                        6. Back
                        ---------------------------------
                        """
        );

        Scanner in = new Scanner(System.in);
        option = database.validateInt("",in);

        return option;
    }

    public void exit(){
        System.out.print(
                """
                        ---------------------------------
                        Thanks for visiting!
                        ---------------------------------
                        """
        );
        System.exit(0);
    }


}

