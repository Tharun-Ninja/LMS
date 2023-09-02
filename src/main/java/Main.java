public class Main{

    public static void main(String[] args) {
        Menu menu = new Menu();
        Librarian librarian = new Librarian();
        Database database = Database.getDatabase();

        System.out.println("\nLibrary Portal Initialized….");
        int option;

        while(true){
            option = menu.InitMenu();

            // Checking if Librarian
            if(option == 1){
                loop: while(true){
                    switch (menu.librarianMenu()){
                        case 1:
                            librarian.registerMember();
                            break;

                        case 2:
                            librarian.removeMember();
                            break;

                        case 3:
                            librarian.addBook();
                            break;

                        case 4:
                            librarian.removeBook();
                            break;

                        case 5:
                            librarian.viewAllMembers();
                            break;

                        case 6:
                            librarian.viewAllBooks();
                            break;

                        case 7:
                            break loop;
                    }
                }
            }
            // Checking if Member
            else if (option == 2){
                Member currentUser = database.memberLogin();
                if(currentUser == null){
                    continue;
                }

                // check member if valid
                loop: while(true){
                    switch (menu.memberMenu()){
                        case 1:
                            currentUser.viewAvailableBooks();
                            break;

                        case 2:
                            currentUser.viewMyBooks();
                            break;

                        case 3:
                            currentUser.issueBook();
                            break;

                        case 4:
                            currentUser.returnBook();
                            break;

                        case 5:
                            currentUser.payFine();
                            break;

                        case 6:
                            break loop;
                    }
                }
            }
            // Exit
            else if(option == 3){
                menu.exit();
            }
            else {
                System.out.println("Invalid");
            }
        }

    }


}
