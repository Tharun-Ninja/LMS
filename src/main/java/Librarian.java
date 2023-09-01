import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Scanner;

public class Librarian{

    private String validateName(String q, Scanner in){
        System.out.print(q + ": ");
        String name = in.nextLine();
        while(!name.matches("[a-zA-Z ]+")) {
            System.out.println("Invalid "+q);
            System.out.print(q + ": ");
            name = in.nextLine();
        }

        return name;
    }


    private int validateInt(String q, Scanner in) {
        System.out.print(q + ": ");
        while (!in.hasNextInt()) {
            System.out.println("Invalid " + q);
            System.out.print(q + ": ");
            in.next();
        }

        return in.nextInt();
    }

    private int validatePhone(String q, Scanner in) {
        System.out.print(q + ": ");
        while (true) {
            String phoneNumber = in.next();

            if (phoneNumber.length() == 10 && phoneNumber.matches("\\d+")) {
                return Integer.parseInt(phoneNumber);
            } else {
                System.out.println("Invalid " + q + ". Please enter a 10-digit phone number.");
                System.out.print(q + ": ");
            }
        }
    }


    Database database = new Database();

    public void registerMember(){
        System.out.println("---------------------------------");
        Scanner input = new Scanner(System.in);

        String name = this.validateName("Name", input);
        int age = this.validateInt("Age", input);
        int phone = this.validatePhone("Phone no", input);

        System.out.println("---------------------------------");

        database.registerMember(name, age, phone);
    }

    public void removeMember(){
        Scanner input = new Scanner(System.in);

        String name = this.validateName("Name", input);
        int id = this.validateInt("Member ID", input);

        database.removeMember(name, id);
    }

    public void addBook(){
        Scanner input = new Scanner(System.in);

        String title = this.validateName("Book title", input);
        String author = this.validateName("Author", input);
        int copies = this.validateInt("Copies", input);

        database.addBook(title, author, copies);

        System.out.println("Book Added Successfully!");
    }

    public void removeBook() {
        Scanner input = new Scanner(System.in);
        int bookID = this.validateInt("Book ID", input);

        database.removeBook(bookID);
    }

    public void viewAllMembers(){
        database.viewAllMembers();
    }

    public void viewAllBooks() {
        database.viewAllBooks();
    }
}