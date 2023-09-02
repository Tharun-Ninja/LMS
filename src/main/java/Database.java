import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Database{

    private static Database database;

    public static Database getDatabase(){
        if(database == null){
            database = new Database();
        }
        return database;
    }


    int memberCount = 0;
    int bookCount = 0;

    HashMap<Integer, Member> Members = new HashMap<>();
    HashMap<Integer, Book> Books = new HashMap<>();

    public void registerMember(String name, int age, int phone){
        int memberID = ++memberCount;
        Members.put(memberID, new Member(memberID, name, age, phone));
        System.out.printf("Member Successfully Registered with Member ID: %d!%n", memberID);

    }

    public void viewAllMembers(){
        System.out.println("List of all members:");

        for (Member member : Members.values()) {
            System.out.println("Member ID: " + member.getID());
            System.out.println("Name: " + member.getName());
            System.out.println("Age: " + member.getAge());
            System.out.println("Phone: " + member.getPhone());
            System.out.println();
        }
    }

    public void removeMember(String name, int memberID) {
        Member memberToRemove = Members.get(memberID);
        if (memberToRemove != null && memberToRemove.getName().equals(name)) {
            Members.remove(memberID);
            System.out.printf("Member with ID %d and name %s removed successfully.%n", memberID, name);
        } else {
            System.out.printf("Member with ID %d and name %s not found.%n", memberID, name);
        }
    }



    public void addBook(String title, String author, int copies){
        for(; copies > 0; copies--) {

            int bookID = ++bookCount;
            Books.put(bookID, new Book(bookID, title, author));
        }
    }

    public void viewAllBooks(){
        System.out.println("List of all Books:");

        for (Book book : Books.values()) {
            System.out.println("Book ID: " + book.getID());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println();
        }
    }

    public void removeBook(int bookID) {
        Book boolToRemove = Books.get(bookID);
        if (boolToRemove != null) {
            Books.remove(bookID);
            System.out.printf("Book with ID %d removed successfully.%n", bookID);
        } else {
            System.out.printf("Book with ID %d not found.%n", bookID);
        }
    }

    private Member _isMember(String name, int phone) {

        for (Member member : Members.values()) {
            if(member.getName().equals(name) && (member.getPhone() == phone)){
                System.out.printf("Welcome %s. Member ID: <%d>%n", name, member.getID());
                return member;
            }
        }

        System.out.printf("Member with Name: %s and Phone No: %d doesn't exist.%n", name, phone);
        return null;
    }


    public Member memberLogin() {
        Scanner input = new Scanner(System.in);

        String name = this.validateName("Name", input);
        int phone = this.validatePhone("Phone no", input);

        return this._isMember(name, phone);
    }




    protected String validateName(String q, Scanner in){
        System.out.print(q + ": ");
        String name = in.nextLine();
        while(!name.matches("[a-zA-Z ]+")) {
            System.out.println("Invalid "+q);
            System.out.print(q + ": ");
            name = in.nextLine();
        }

        return name;
    }


    protected int validateInt(String q, Scanner in) {
        System.out.print(q + ": ");
        while (!in.hasNextInt()) {
            System.out.println("Invalid " + q);
            System.out.print(q + ": ");
            in.next();
        }

        return in.nextInt();
    }

    protected int validatePhone(String q, Scanner in) {
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


}