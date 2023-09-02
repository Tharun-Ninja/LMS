import java.util.Scanner;

public class Librarian{

    Database database = Database.getDatabase();

    public void registerMember(){
        System.out.println("---------------------------------");
        Scanner input = new Scanner(System.in);

        String name = database.validateName("Name", input);
        int age = database.validateInt("Age", input);
        int phone = database.validatePhone("Phone no", input);

        System.out.println("---------------------------------");

        database.registerMember(name, age, phone);
    }

    public void removeMember(){
        Scanner input = new Scanner(System.in);

        String name = database.validateName("Name", input);
        int id = database.validateInt("Member ID", input);

        database.removeMember(name, id);
    }

    public void addBook(){
        Scanner input = new Scanner(System.in);

        String title = database.validateName("Book title", input);
        String author = database.validateName("Author", input);
        int copies = database.validateInt("Copies", input);

        database.addBook(title, author, copies);

        System.out.println("Book Added Successfully!");
    }

    public void removeBook() {
        Scanner input = new Scanner(System.in);
        int bookID = database.validateInt("Book ID", input);

        database.removeBook(bookID);
    }

    public void viewAllMembers(){
        database.viewAllMembers();
    }

    public void viewAllBooks() {
        database.viewAllBooks();
    }
}