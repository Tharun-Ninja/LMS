import java.util.Scanner;
public class Menu {

    Database database = new Database();

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

        return getInputOption();

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

        return getInputOption();
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

        return getInputOption();
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

    private int getInputOption() {
        Scanner scanner = new Scanner(System.in);
        return database.validateInt("", scanner);
    }

}

