import java.util.ArrayList;
import java.util.Scanner;

public class Member {

    private final int ID;

    private final int Age;

    private final String Name;
    private final int Phone;

    private int totalFines = 0;
    private final Database database;

    public Member(int id, String name, int age, int phone) {
        this.Name = name;
        this.Age = age;
        this.Phone = phone;
        this.ID = id;
        this.database = Database.getDatabase();
    }

    private final Scanner input = new Scanner(System.in);

    public int getID() {
        return ID;
    }

    public int getAge() {
        return Age;
    }

    public String getName() {
        return Name;
    }


    public int getPhone() {
        return Phone;
    }

    public int getTotalFines() {
        return totalFines;
    }

    public void setTotalFines(int totalFines) {
        this.totalFines += totalFines;
    }

    private final ArrayList<Book> Books = new ArrayList<>();

    public int getBooksCount(){
        return Books.size();
    }

    public ArrayList<Book> getBooks(){
        return Books;
    }

    public void addBooks(Book book) {
        if(this.Books.size() < 2){
            this.Books.add(book);
        }
        else{
            System.out.println("Book limit reached");
        }
    }

    public void viewAvailableBooks(){
        database.viewAvailableBooks();
    }

    public void viewMyBooks(){
        if(Books.isEmpty()){
            System.out.println("You don't own any books");
        }
        else {
            for (Book book : Books) {
                System.out.println();
                System.out.println("Book ID: " + book.getID());
                System.out.println("Book Name: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
            }
        }
    }
    public void issueBook(){
        int bookID = database.validateInt("Book ID", input);
        String name = database.validateName("Book Name", input);

        database.issueBook(this,bookID, name);
    }
    public void returnBook(){
        int bookID = database.validateInt("Book ID", input);

        int deleteIndex = -1;
        for(int i = 0; i < Books.size(); i++){
            if(Books.get(i).getID() == bookID){
                deleteIndex = i;
            }
        }

        if(deleteIndex != -1){
            Books.remove(deleteIndex);
            database.returnBook(this, bookID);
        }
        else{
            System.out.printf("You don't own Book ID: %s%n", bookID);
        }
    }
    public void payFine(){
        if(this.totalFines != 0){
            System.out.println("---------------------------------");
            System.out.printf("You had a total fine of Rs. %d. It has been paid successfully!%n", this.totalFines);
            this.totalFines = 0;
        }
        else{
            System.out.println("You Don't have any fine to be paid. Return a book to calculate fine.");
        }

    }


}