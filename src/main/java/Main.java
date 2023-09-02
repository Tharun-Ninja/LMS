import javax.xml.crypto.Data;

public class Main{

    public static void main(String[] args) {
        Menu menu = new Menu();
        Librarian librarian = new Librarian();
        Database database = Database.getDatabase();

        System.out.println("\nLibrary Portal Initialized….");

        while(true){
            switch (menu.InitMenu()) {
                case 1 -> runLibrarianMenu(librarian, menu);
                case 2 -> runMemberMenu(database, menu);
                case 3 -> {
                    menu.exit();
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Please choose a valid option.");
            }

        }

    }

    public static void runLibrarianMenu(Librarian librarian, Menu menu){
        while(true){
            switch (menu.librarianMenu()) {
                case 1 -> librarian.registerMember();
                case 2 -> librarian.removeMember();
                case 3 -> librarian.addBook();
                case 4 -> librarian.removeBook();
                case 5 -> librarian.viewAllMembers();
                case 6 -> librarian.viewAllBooks();
                case 7 -> {
                    return;
                }
            }
        }
    }


    public static void runMemberMenu(Database database, Menu menu){
        Member currentUser = database.memberLogin();
        if(currentUser == null){
            return;
        }

        while(true){
            switch (menu.memberMenu()) {
                case 1 -> currentUser.viewAvailableBooks();
                case 2 -> currentUser.viewMyBooks();
                case 3 -> currentUser.issueBook();
                case 4 -> currentUser.returnBook();
                case 5 -> currentUser.payFine();
                case 6 -> {
                    return;
                }
            }
        }

    }


}
