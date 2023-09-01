public class Member {

    private int ID;

    private int Age;

    private String Name;
    private int PhoneNumber;

    public static void printMenu(){
        System.out.print(
                "---------------------------------\n" +
                        "1. List Available Books\n" +
                        "2. List My Books\n" +
                        "3. Issue book\n" +
                        "4. Return book\n" +
                        "5. Pay Fine\n" +
                        "6. Back\n" +
                        "---------------------------------\n"
        );
    }


}