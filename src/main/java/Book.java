public class Book {

    private final int ID;
    private final String Title;
    private final String Author;

    public Book(int id, String title, String author){
        this.ID = id;
        this.Title = title;
        this.Author = author;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

}
