import javax.xml.crypto.Data;
import java.util.Scanner;

public class Member {

    private int ID;

    private int Age;

    private String Name;
    private int Phone;

    public Member(int id, String name, int age, int phone) {
        this.Name = name;
        this.Age = age;
        this.Phone = phone;
        this.ID = id;
    }

    Database database = new Database();


    public void viewAvailableBooks(){

    }

    public void viewMyBooks(){

    }
    public void issueBook(){

    }
    public void returnBook(){

    }
    public void payFine(){

    }

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
}