import java.util.HashMap;
import java.util.Scanner;

public class Database{

    private static Database database;

    public static Database getDatabase(){
        if(database == null){
            database = new Database();
        }
        return database;
    }


    private int memberCount = 0;
    private int bookCount = 0;

    private final int finePerDay = 3;
    private final int dueDay = 10;

    private HashMap<Integer, Member> Members = new HashMap<>();
    private HashMap<Integer, Book> Books = new HashMap<>();
    private HashMap<Integer, Book> availableBooks = new HashMap<>();
    private HashMap<Integer, Long> Issues = new HashMap<>();



    public void registerMember(String name, int age, long phone){
        System.out.println("---------------------------------");

        if (this.isPhoneUsed(phone)){
            System.out.println("Phone number already registered");
        }
        else{
            int memberID = ++memberCount;
            Members.put(memberID, new Member(memberID, name, age, phone));
            System.out.printf("Member Successfully Registered with Member ID: %d!%n", memberID);
        }

    }

    public void viewAllMembers(){
        if(Members.isEmpty()){
            System.out.println("---------------------------------");
            System.out.println("No Members Yet!");
            return;
        }
        System.out.println("List of all members:");

        for (Member member : Members.values()) {
            int totalFine = 0;
            System.out.println("---------------------------------");

            System.out.println("Member ID: " + member.getID());
            System.out.println("Name: " + member.getName());
            System.out.println("Age: " + member.getAge());
            System.out.println("Phone: " + member.getPhone());
            if(!member.getBooks().isEmpty()){
                for(Book book: member.getBooks()){
                    System.out.println();
                    System.out.println("Book ID: "+book.getID());
                    System.out.println("Name: "+book.getTitle());
                    System.out.println("Fine per book: "+this.calculateFine(book.getID()));
                    totalFine += this.calculateFine(book.getID());
                }
            }
            else{
                System.out.println("Books holding: 0");
            }
            System.out.println();
            System.out.println("Total Fines: "+ (member.getTotalFines() + totalFine));

        }
    }

    private int calculateFine(int bookID){
        int due = (int) ((System.currentTimeMillis()/1000L) - Issues.get(bookID)) - dueDay;
        return Math.max(due, 0) * finePerDay;
    }

    public void removeMember(String name, int memberID) {
        System.out.println("---------------------------------");
        Member memberToRemove = Members.get(memberID);
        if (memberToRemove != null && memberToRemove.getName().equalsIgnoreCase(name)) {
            if(memberToRemove.getBooksCount() != 0){
                for(Book book: memberToRemove.getBooks()){
                    System.out.printf("Removing book ID: %d, titled: %s issued by the member%n", book.getID(), book.getTitle());
                    Issues.remove(book.getID());
                    Books.remove(book.getID());
                }
            }
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
            availableBooks.put(bookID, new Book(bookID, title, author));
        }
    }

    public void viewAllBooks(){
        System.out.println("---------------------------------");
        if(Books.isEmpty()){
            System.out.println("No books Added");
        }
        else{
            System.out.println("List of all Books:");

            for (Book book : Books.values()) {
                System.out.println();
                System.out.println("Book ID: " + book.getID());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
            }
        }

    }

    public void viewAvailableBooks(){
        System.out.println("List of available Books:");

        for (Book book : availableBooks.values()) {
            System.out.println();
            System.out.println("Book ID: " + book.getID());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
        }
    }

    public void removeBook(int bookID) {
        System.out.println("---------------------------------");
        Book bookToRemove = availableBooks.get(bookID);
        if (bookToRemove != null) {
            Books.remove(bookID);
            availableBooks.remove(bookID);

            System.out.printf("Book with ID %d removed successfully.%n", bookID);
        } else {
            System.out.printf("Book with ID %d not found.%n", bookID);
        }
    }

    public void issueBook(Member user,int bookID, String name){
        System.out.println("---------------------------------");

        Book bookToIssue = availableBooks.get(bookID);
        // book is available
        if(bookToIssue != null && bookToIssue.getTitle().equalsIgnoreCase(name)){
            // user hasn't reached book borrow limit
            if (user.getBooksCount() < 2) {

                int fine = user.getTotalFines();
                for(Book book: user.getBooks()){
                    fine += calculateFine(book.getID());
                }
                if(fine == 0){
                    user.addBooks(bookToIssue);
                    availableBooks.remove(bookID);
                    Issues.put(bookID, (System.currentTimeMillis() / 1000L));
                    System.out.println("Book issued Successfully");
                }
                else{
                    System.out.printf("Please pay pending fine: %d%n", fine);
                }

            }
            else {
                System.out.println("Book limit reached");
            }
        }
        else{
            System.out.println("Book not Found");

        }
    }

    public void returnBook(Member user, int bookID){
        System.out.println("---------------------------------");

        Book bookToRet = Books.get(bookID);
        if(bookToRet != null){
            if(availableBooks.get(bookID) == null){
                int fine = this.calculateFine(bookID);

                if(fine > 0){
                    user.setTotalFines(fine);
                    System.out.printf("Book ID: %d successfully returned.%n%d Rupees has been charged for a delay of %d days. %n", bookID, fine, (int)((System.currentTimeMillis()/1000L) - Issues.get(bookID)) - dueDay);
                }
                else{
                    System.out.printf("Book ID: %d successfully returned.%n", bookID);
                }
                availableBooks.put(bookID, bookToRet);
                Issues.remove(bookID);

            }
            else{
                System.out.printf("Book ID: %d already returned.", bookID);
            }
        }
        else{
            System.out.printf("Book ID: %d, not found.", bookID);
        }
    }



    private Member _isMember(String name, long phone) {

        for (Member member : Members.values()) {
            if(member.getName().equalsIgnoreCase(name) && (member.getPhone() == phone)){
                System.out.printf("Welcome %s. Member ID: <%d>%n", name, member.getID());
                return member;
            }
        }

        System.out.printf("Member with Name: %s and Phone No: %d doesn't exist.%n", name, phone);
        return null;
    }


    public Member memberLogin() {
        System.out.println("---------------------------------");

        Scanner input = new Scanner(System.in);

        String name = this.validateName("Name", input);
        long phone = this.validatePhone(input);

        return this._isMember(name, phone);
    }




    protected String validateName(String q, Scanner in){
        System.out.print(q + ": ");
        String name = in.nextLine().trim();
        while(!name.matches("[a-zA-Z ]+")) {
            System.out.println("Invalid "+q);
            System.out.print(q + ": ");
            name = in.nextLine().trim();
        }

        return name;
    }


    protected int validateInt(String q, Scanner in) {
        System.out.print(q + ": ");
        while (true) {
            while (!in.hasNextInt()) {
                System.out.println("Invalid " + q);
                System.out.print(q + ": ");
                in.next();
            }
            int option = in.nextInt();
            in.nextLine();

            if (option > 0) {
                return option;
            } else {
                System.out.println("Please enter a positive " + q);
                System.out.print(q + ": ");
            }
        }
    }


    protected long validatePhone(Scanner in) {
        System.out.print("Phone: ");
        while (true) {
            String phoneNumber = in.nextLine();

            if (phoneNumber.length() == 10 && phoneNumber.matches("\\d+")) {
                return Long.parseLong(phoneNumber);
            } else {
                System.out.println("Invalid Phone. Please enter a 10-digit phone number.");
                System.out.print("Phone: ");
            }
        }
    }

    private boolean isPhoneUsed(long phone){
        for(Member member: Members.values()){
            if(member.getPhone() == phone){
                return true;
            }
        }
        return false;
    }


}