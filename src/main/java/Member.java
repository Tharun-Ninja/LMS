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


    public static void viewAvailableBooks(){

    }

    public static void viewMyBooks(){

    }
    public static void issueBook(){

    }
    public static void returnBook(){

    }
    public static void payFine(){

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