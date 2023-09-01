import java.util.HashMap;

public class Database{

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
            System.out.printf("Member with ID %d removed successfully.%n", bookID);
        } else {
            System.out.printf("Member with ID %d not found.%n", bookID);
        }
    }


}