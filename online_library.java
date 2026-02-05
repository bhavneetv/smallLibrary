bh

import java.util.Scanner;

final class library {
    Scanner sc = new Scanner(System.in);
    boolean isFirst = false;

    String ala_books[] = { "Hindi", "SST", "Maths" };
    String iss_books[] = { "Science", "Physics" };

    public library() {
        libraryFirst();
        // issueBook();
        // returnBook();
    }

    void libraryFirst() {
        if (!isFirst) {

            System.out.println("Welcome to Java library");
            isFirst = true;
        }

        System.out.print(
                "\nChoose the option to perform the operation \n 1. To show available books in library \n 2. To Show Issued books \n 3. To Add a book in library \n 4. To Issue a book from Library \n 5. To return a Issued Book \n 6. Exit \n");
        System.out.print("Enter your choose : ");
        int operation = sc.nextInt();
        sc.nextLine(); // important fix

        switch (operation) {
            case 1 -> displayArray(ala_books, true);
            case 2 -> displayArray(iss_books, true);
            case 3 -> addBooks();
            case 4 -> issueBook();
            case 5 -> returnBook();
            case 6 -> System.out.println("Exiting...");
            default -> throw new AssertionError();
        }

    }d

    void displafyArray(String a[], boolean b) {
        for (String element : a) {
            System.out.print(element + " ");

        }
        System.out.println(" ");
        if (b) {
            libraryFirst();
        }

    }
f
    void addBooks() {

        System.out.print("Enter the name of the book you want to add: ");

        String new_Book = sc.nextLine();

        String[] newArray = new String[ala_books.length + 1];

        System.arraycopy(ala_books, 0, newArray, 0, ala_books.length);

        newArray[ala_books.length] = new_Book;

        ala_books = newArray;

        libraryFirst();

    }
    //aas

    void issueBook() {
        System.out.print("Avaiable books in library :");
        displayArray(ala_books, false);
        Boolean isIssue = false;
        System.out.print("Enter the book you want to issue : ");
        String issu_b = sc.nextLine();
        for (int i = 0; i < ala_books.length; i++) {
            if (ala_books[i].contains(issu_b)) {
                ala_books[i] = " ";
                isIssue = true;

            } else {
                isIssue = false;

            }

        }

        if (isIssue) {
            String[] newArray = new String[iss_books.length + 1];

            System.arraycopy(iss_books, 0, newArray, 0, iss_books.length);

            newArray[iss_books.length] = issu_b;

            iss_books = newArray;

            System.out.println("Book issued");

        } else {
            System.out.println("Book Not Issued !");

        }
        // 4
        libraryFirst();
    }

    void returnBook() {
        System.out.print("All Issued books in library :");
        displayArray(iss_books, false);

        Boolean isIssue = false;
        System.out.println("Enter the book you want to return : ");
        String retrun_b = sc.nextLine();
        for (int i = 0; i < iss_books.length; i++) {
            if (iss_books[i].contains(retrun_b)) {
                iss_books[i] = " ";
                isIssue = true;

            } else {
                isIssue = false;

            }

        }
        if (isIssue) {
            String[] newArray = new String[ala_books.length + 1];

            System.arraycopy(ala_books, 0, newArray, 0, ala_books.length);

            newArray[ala_books.length] = retrun_b;

            ala_books = newArray;

            System.out.println("Book returned");

        } else {
            System.out.println("Book Not Returned !");

        }

        libraryFirst();

    }

}

public class online_library {

    public static void main(String[] args) {

        new library();

    }

}
