import Entities.Book;
import Entities.Library;
import Entities.Member;
import Exeptions.BookAlreadyExistsException;
import Exeptions.BookNotFoundException;
import Exeptions.BookNotAvailableException;
import Exeptions.BorrowingLimitExceededException;
import Exeptions.BookNotBorrowedByMemberException;
import Exeptions.MemberAlreadyExistsException;
import Exeptions.MemberNotFoundException;
import Exeptions.MemberHasBorrowedBooksException;
import Exeptions.InputHandler;
import Exeptions.ValidationUtils;
import services.BorrowingService.BorrowingServiceImpl;
import services.MembersService.MemberServiceImpl;
import services.bookService.BookServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Represents the main console interface of the Library Management System.
 * Handles user input, displays the menu, and coordinates operations
 * between the user and the service classes.
 */
public class LibrarySystem {

    Library library = new Library();

    Scanner scanner = new Scanner(System.in);
    InputHandler inputHandler = new InputHandler(scanner);

    BookServiceImpl bookService = new BookServiceImpl(library);
    MemberServiceImpl memberService = new MemberServiceImpl(library);
    BorrowingServiceImpl borrowingService = new BorrowingServiceImpl(library);

    /**
     * Starts the library management system.
     * Displays the main menu and executes the operation selected by the user.
     * Allows up to three invalid menu selections before exiting.
     */
    public void Start() {

        int coutOfTry = 1;
        boolean status = true;

        while (status) {

            System.out.print("========== LIBRARY MANAGEMENT SYSTEM ==========\n" +
                    "\n" +
                    "1. Add Book\n" +
                    "2. Remove Book\n" +
                    "3. Search Book\n" +
                    "4. Display All Books\n" +
                    "5. Display Available Books\n" +
                    "6. Display Borrowed Books\n" +
                    "\n" +
                    "7. Register Member\n" +
                    "8. Remove Member\n" +
                    "9. Search Member\n" +
                    "10. Display All Members\n" +
                    "\n" +
                    "11. Borrow Book\n" +
                    "12. Return Book\n" +
                    "\n" +
                    "13. Sort Books\n" +
                    "14. Exit\n" +
                    "\n" +
                    "===============================================\n");

            int numOfOperation;

            try {
                numOfOperation = inputHandler.readInt(
                        "Enter your choice: ",
                        "Please enter a valid integer"
                );

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Thank you! Try again next time.");
                break;
            }

            switch (numOfOperation) {

                case 1:
                    coutOfTry = 1;
                    System.out.print("\n Welcome to Add Book page \n");
                    addBook();
                    break;

                case 2:
                    coutOfTry = 1;
                    System.out.print("Welcome to Remove Book page");
                    removeBook();
                    break;

                case 3:
                    coutOfTry = 1;
                    System.out.print("Welcome to Search Book page");
                    searchBook();
                    break;

                case 4:
                    coutOfTry = 1;
                    System.out.print("Welcome Display All Book page");
                    displayBooks();
                    break;

                case 5:
                    coutOfTry = 1;
                    System.out.print("Welcome Display Available Books page");
                    displayAvailableOrBorrowedBooks(true);
                    break;

                case 6:
                    coutOfTry = 1;
                    System.out.print("Welcome Display Borrowed Books page");
                    displayAvailableOrBorrowedBooks(false);
                    break;

                case 7:
                    coutOfTry = 1;
                    System.out.print("Welcome Register Member");
                    registerMember();
                    break;

                case 8:
                    coutOfTry = 1;
                    System.out.print("Remove Member");
                    removeMember();
                    break;

                case 9:
                    coutOfTry = 1;
                    System.out.print("Search Member");
                    searchMember();
                    break;

                case 10:
                    coutOfTry = 1;
                    System.out.print("Display All Members");
                    displayAllMembers();
                    break;

                case 11:
                    coutOfTry = 1;
                    System.out.print("Borrow Book Page");
                    borrowBook();
                    break;

                case 12:
                    coutOfTry = 1;
                    System.out.print("Return Book page");
                    returnBook();
                    break;

                case 13:
                    coutOfTry = 1;
                    System.out.print("Sort Book");
                    sortBooks();
                    break;

                case 14:
                    System.out.println("Exit");
                    status = false;
                    break;

                default:
                    System.out.println(
                            "Your number is not valid. Please enter a number related to a previous operation."
                    );

                    if (coutOfTry < 3) {
                        System.out.println(
                                "You have " + (3 - coutOfTry) + " chance(s) left."
                        );
                        coutOfTry++;
                    } else {
                        System.out.println("Thank you! Try again next time.");
                        status = false;
                    }
            }
        }
    }

    /**
     * Reads book information from the user and adds a new book to the library.
     * Validates the book ID, title, author, and category before adding.
     */
    public void addBook() {

        int id;

        do {
            try {
                id = inputHandler.readInt(
                        "Enter your Book Id : ",
                        "Please enter a valid integer"
                );

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Thank you! Try again next time.");
                return;
            }

            if (!ValidationUtils.validId(id)) {
                System.out.println("ID must be greater than 0");
            }

        } while (!ValidationUtils.validId(id));

        scanner.nextLine();

        String title = inputHandler.readValidString(
                "Enter Book Title: ",
                "Title must contain at least 3 characters.",
                3
        );

        String author = inputHandler.readValidString(
                "Enter Book Author: ",
                "Author must contain at least 3 characters.",
                3
        );

        String category = inputHandler.readValidString(
                "Enter Book Category: ",
                "Category must contain at least 3 characters.",
                3
        );

        try {
            bookService.addBook(id, title, author, category, true);
            System.out.println("Book Added Successfully.");

        } catch (BookAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Reads a book ID and removes the corresponding book from the library.
     * Validates the ID before performing the removal.
     */
    public void removeBook() {

        int id;
        int attempts = 0;

        do {
            try {
                id = inputHandler.readInt(
                        "Enter your Book Id: ",
                        "Please enter a valid integer"
                );

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Thank you! Try again next time.");
                return;
            }

            if (!ValidationUtils.validId(id)) {
                attempts++;

                System.out.println("ID must be greater than 0");

                if (attempts == 3) {
                    System.out.println("Maximum attempts exceeded.");
                    return;
                }
            }

        } while (!ValidationUtils.validId(id));

        try {
            bookService.removeBook(id);
            System.out.println("Book Removed Successfully.");

        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Searches for a book using its ID and displays the result.
     */
    public void searchBook() {

        int id;
        int attempts = 0;

        do {
            try {
                id = inputHandler.readInt(
                        "Enter your Book Id: ",
                        "Please enter a valid integer"
                );

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Thank you! Try again next time.");
                return;
            }

            if (!ValidationUtils.validId(id)) {
                attempts++;

                System.out.println("ID must be greater than 0");

                if (attempts == 3) {
                    System.out.println("Maximum attempts exceeded.");
                    return;
                }
            }

        } while (!ValidationUtils.validId(id));

        try {
            Book book = bookService.searchBook(id);
            System.out.println(book);

        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Displays all books registered in the library.
     */
    public void displayBooks() {
        bookService.displayAllBooks();
    }

    /**
     * Displays books according to their availability status.
     *
     * @param isAvailable true to display available books,
     *                    false to display borrowed books
     */
    public void displayAvailableOrBorrowedBooks(boolean isAvailable) {
        bookService.displayAvailableOrBorrowedBooks(isAvailable)
                .forEach(System.out::println);
    }

    /**
     * Reads member information and registers a new member.
     * Validates the member ID, name, and email before registration.
     */
    public void registerMember() {

        int id;
        int attempts = 0;

        do {
            try {
                id = inputHandler.readInt(
                        "\n Enter Member Id : ",
                        "Please enter a valid integer"
                );

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Thank you! Try again next time.");
                return;
            }

            if (!ValidationUtils.validId(id)) {
                attempts++;
                System.out.println("ID must be greater than 0");

                if (attempts == 3) {
                    System.out.println("Maximum attempts exceeded.");
                    return;
                }
            }

        } while (!ValidationUtils.validId(id));

        scanner.nextLine();

        String name = inputHandler.readValidString(
                "Enter Member Name : ",
                "Member Name must contain at least 3 characters.",
                3
        );

        String email;

        try {
            email = inputHandler.readValidEmail();

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Thank you! Try again next time.");
            return;
        }

        try {
            memberService.registerMember(id, name, email);
            System.out.println("Member Registered Successfully.");

        } catch (MemberAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Reads a member ID and removes the corresponding member.
     * The member must not have any borrowed books.
     */
    public void removeMember() {

        int id;
        int attempts = 0;

        do {
            try {
                id = inputHandler.readInt(
                        "\n Enter Member Id : ",
                        "Please enter a valid integer"
                );

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Thank you! Try again next time.");
                return;
            }

            if (!ValidationUtils.validId(id)) {
                attempts++;
                System.out.println("ID must be greater than 0");

                if (attempts == 3) {
                    System.out.println("Maximum attempts exceeded.");
                    return;
                }
            }

        } while (!ValidationUtils.validId(id));

        scanner.nextLine();

        try {
            memberService.removeMember(id);
            System.out.println("Member Removed Successfully.");

        } catch (MemberNotFoundException | MemberHasBorrowedBooksException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Searches for a registered member using their ID.
     */
    public void searchMember() {

        int id;
        int attempts = 0;

        do {
            try {
                id = inputHandler.readInt(
                        "\n Enter Member Id : ",
                        "Please enter a valid integer"
                );

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Thank you! Try again next time.");
                return;
            }

            if (!ValidationUtils.validId(id)) {
                attempts++;
                System.out.println("ID must be greater than 0");

                if (attempts == 3) {
                    System.out.println("Maximum attempts exceeded.");
                    return;
                }
            }

        } while (!ValidationUtils.validId(id));

        scanner.nextLine();

        try {
            Member member = memberService.searchMember(id);
            System.out.println(member);

        } catch (MemberNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Displays all registered members in the library.
     */
    public void displayAllMembers() {
        memberService.displayAllMembers();
    }

    /**
     * Reads member and book IDs, then performs the borrowing operation.
     */
    public void borrowBook() {

        int memberId;
        int attempts = 0;

        do {
            try {
                memberId = inputHandler.readInt(
                        "\nEnter Member Id : ",
                        "Please enter a valid integer"
                );

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Thank you! Try again next time.");
                return;
            }

            if (!ValidationUtils.validId(memberId)) {
                attempts++;
                System.out.println("ID must be greater than 0");

                if (attempts == 3) {
                    System.out.println("Maximum attempts exceeded.");
                    return;
                }
            }

        } while (!ValidationUtils.validId(memberId));

        scanner.nextLine();

        int bookId;
        attempts = 0;

        do {
            try {
                bookId = inputHandler.readInt(
                        "\nEnter your Book Id : ",
                        "Please enter a valid integer"
                );

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Thank you! Try again next time.");
                return;
            }

            if (!ValidationUtils.validId(bookId)) {
                attempts++;
                System.out.println("ID must be greater than 0");

                if (attempts == 3) {
                    System.out.println("Maximum attempts exceeded.");
                    return;
                }
            }

        } while (!ValidationUtils.validId(bookId));

        scanner.nextLine();

        try {
            borrowingService.borrowBook(bookId, memberId);
            System.out.println("Book Borrowed Successfully.");

        } catch (MemberNotFoundException |
                 BookNotFoundException |
                 BookNotAvailableException |
                 BorrowingLimitExceededException e) {

            System.out.println(e.getMessage());
        }
    }

    /**
     * Reads member and book IDs, then performs the book return operation.
     */
    public void returnBook() {

        int memberId;
        int attempts = 0;

        do {
            try {
                memberId = inputHandler.readInt(
                        "\nEnter Member Id : ",
                        "Please enter a valid integer"
                );

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Thank you! Try again next time.");
                return;
            }

            if (!ValidationUtils.validId(memberId)) {
                attempts++;
                System.out.println("ID must be greater than 0");

                if (attempts == 3) {
                    System.out.println("Maximum attempts exceeded.");
                    return;
                }
            }

        } while (!ValidationUtils.validId(memberId));

        scanner.nextLine();

        int bookId;
        attempts = 0;

        do {
            try {
                bookId = inputHandler.readInt(
                        "\nEnter your Book Id : ",
                        "Please enter a valid integer"
                );

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Thank you! Try again next time.");
                return;
            }

            if (!ValidationUtils.validId(bookId)) {
                attempts++;
                System.out.println("ID must be greater than 0");

                if (attempts == 3) {
                    System.out.println("Maximum attempts exceeded.");
                    return;
                }
            }

        } while (!ValidationUtils.validId(bookId));

        scanner.nextLine();

        try {
            borrowingService.returnBook(bookId, memberId);
            System.out.println("Book Returned Successfully.");

        } catch (MemberNotFoundException |
                 BookNotFoundException |
                 BookNotBorrowedByMemberException e) {

            System.out.println(e.getMessage());
        }
    }

    /**
     * Displays sorting options and sorts books according to the user's selection.
     * Supports sorting by title, author, or book ID.
     */
    public void sortBooks() {

        int countTry = 1;
        boolean status = true;

        while (status) {
            try {
                System.out.print("\n Enter Number of Option Sort : \n");
                System.out.print("\n 1 ---------> Sort By Title : \n");
                System.out.print("\n 2 ---------> Sort By Author : \n");
                System.out.print("\n 3 ---------> Sort By Book Id : \n");

                int number = scanner.nextInt();

                bookService.sortBooks(number);
                displayBooks();
                break;

            } catch (InputMismatchException e) {

                if (countTry < 3) {
                    System.out.print("\n Enter Number between 1 - 2 - 3 \n");
                    System.out.print("\n You have " + (3 - countTry) + " chance: \n ");

                    countTry++;
                    scanner.nextLine();

                } else {
                    System.out.print("\n Thank you -------> Try again next Time : \n ");
                    status = false;
                }
            }
        }
    }
}