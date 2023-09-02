public class Book {

    private int ID;
    private String Title;
    private String Author;

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
