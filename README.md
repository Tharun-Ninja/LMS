# Library Management System

----


## How to Execute

To run this project, follow these steps:

1. **Clone the Repository**: Start by cloning this repository to your local machine using Git:

    ```bash
    git clone <repository_url>
    ```

2. **Compile and Run the Code**: Navigate to the project's root directory and use Maven to compile and run the code. Run the following commands:

    ```bash
    cd lms
    mvn compile
    mvn exec:java -Dexec.mainClass="Main"
    ```

That's it! You've successfully cloned the repository and executed the code using Maven.

----

## Project Structure

The project structure is as follows:

- `lms`: This is the root directory of your project.
- `src`: Contains your source code.
   - `main`: A typical source directory for main application code.
      - `java`: The directory where your Java source files are located.
         -  `Menu`: This class contains all the print statements for the interface and scans for the option
         - `Main`: This class contains the central logic of calling different methods according to user input.
         -  `Member`: This class contains all the member details and methods to access them.
         - `Librarian`: This class contains all the librarian methods to do librarian functionalities.
         -  `Book`: This contains all the attributes related to the book and methods to access them.
         - `Database`: This class is the backbone of the project. This class has all the list of members, book, Issues, Available books. It has the methods to modify the list according to the user input. It also has methods for validating user input. This Database class has only one instanciation making it a **Singleton class** so that all the data is synchronized among the other classes.

- `pom.xml`: This file is often used for defining project dependencies and configurations in Maven projects.
- `README.md`: Typically, a markdown file that provides information and documentation for your project.

----

## **Code Functionalities:** 
This Library Management System (LMS) is written in Java and provides various functionalities for efficient library management. The system allows users to log in as either a librarian or a member by entering a number associated with their role. The following actions can be performed:

**By the Librarian:**

1. **Register Member:**
   - Lets a librarian add a new member to the library.
   - Takes input for member details (name, age, phone number).
   - Assuming that the phone number is a 10-digit number and to be unique for every member.
   - So every member should have unique phone number.
   - Unique member ID is generated.

2. **Remove Member:**
   - Allows a librarian to remove a member from the library.
   - Takes input for the member name and ID to verify.
   - If not matching then throw error.
   - A member will be removed from the database even if he has a book not returned and fines to be paid.
       Since Librarian is in charge of this. And the book will be removed from the database and issue list.

3. **Add Book:**
    - Enables a librarian to add a new book to the library.
    - Collects input for book details (title, author, total copies).
    - Generates a unique book ID associated with the book.

4. **Remove Book:**
    - Allows a librarian to remove a book from the library.
    - Requires to be input for the book ID.
    - Even if multiple copies are there only the copy with book id will be removed.
    - If Librarian is trying to remove a book that is borrowed by a member and not yet returned 
   then it will throw error that book is not found in library.
   
5. **List Members:**
    - Displays a list of all registered members of the library along with their borrowed books and fines.

6. **List Books:**
    - Displays a list of all books available in the library.
   
7. **Back:**
    - To Go back to the previous menu.
   
**Log in as a Member:**
- Requires the member's name and phone number as input to log in as the respective member, provided they are already registered.

1. **List Available Books:**
    - Displays a list of available books in the library.

2. **List My Books:**
    - Displays a list of books borrowed by the member.

3. **Issue Book:**
    - Allows a member to borrow a book from the library, provided their fine amount is zero and doesn't hold a book which is more than 10 days without returning.
    - In that case the fine will be calculated instantaneously and printed for reference. But the fine amount can only be paid after returning the book.
    - If the member owes the library penalty money, they must clear the fines before issuing a new book.
    - Takes input for the book ID and name, and checks if the book is issued if it is available and valid and then if any fine
   is there for member, it may be previous fine or instantaneous fine.

4. **Return Book:**
    - Enables a member to return a borrowed book.
    - Takes input for the book ID to check if the member borrowed the book. 
    - Adjusts fine accordingly.


5. **Pay Fine:**
- *Calculate Fine:*
   - Calculates the fine amount for a book if it's returned after the due date (10 days).
   - In this calculation, 1 day is considered equal to 1 second.
- Clears all fines owed by the member which is calculated after member returns a book.

6. **Exit:**
    - Terminates the application.

----




