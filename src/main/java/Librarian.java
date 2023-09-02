import java.util.Scanner;

public class Librarian{

    private final Database database;
    public Librarian() {
        this.database = Database.getDatabase();
    }

    private final Scanner input = new Scanner(System.in);

    public void registerMember(){

        String name = database.validateName("Name", input);
        int age = database.validateInt("Age", input);
        int phone = database.validatePhone("Phone no", input);


        database.registerMember(name, age, phone);
    }

    public void removeMember(){
        String name = database.validateName("Name", input);
        int id = database.validateInt("Member ID", input);

        database.removeMember(name, id);
    }

    public void addBook(){

        String title = database.validateName("Book title", input);
        String author = database.validateName("Author", input);
        int copies = database.validateInt("Copies", input);

        database.addBook(title, author, copies);

        System.out.println("Book Added Successfully!");
    }

    public void removeBook() {
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