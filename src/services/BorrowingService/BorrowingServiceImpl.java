
package services.BorrowingService;

import Entities.Book;
import Entities.Library;
import Entities.Member;

import java.util.Optional;

/**
 * Implements the borrowing and returning operations for library books.
 * Uses a shared Library instance to manage books and members.
 */
public class BorrowingServiceImpl implements BorrowingService {

    private Library library;

    /**
     * Constructs the borrowing service using a shared library instance.
     *
     * @param library the library containing books and registered members
     */
    public BorrowingServiceImpl(Library library) {
        this.library = library;
    }

    /**
     * Allows a member to borrow an available book.
     * Checks whether the member and book exist, whether the book is available,
     * and whether the member has reached the maximum borrowing limit of three books.
     *
     * @param bookId   the ID of the book to borrow
     * @param memberId the ID of the member borrowing the book
     */
    @Override
    public void borrowBook(int bookId, int memberId) {

        boolean isExistMember = library.getMembers().stream()
                .anyMatch(librarymember -> librarymember.getId() == memberId);

        if (isExistMember) {

            boolean isExistBook = library.getBooks().stream()
                    .anyMatch(libraryBook -> libraryBook.getId() == bookId);

            Optional<Book> book = library.getBooks().stream()
                    .filter(libraryBook -> libraryBook.getId() == bookId)
                    .findFirst();

            if (isExistBook) {

                if (book.get().isAvailable()) {

                    Optional<Member> member = library.getMembers().stream()
                            .filter(libraryMember -> libraryMember.getId() == memberId)
                            .findFirst();

                    if (member.isPresent()) {

                        boolean statusOfAdded = member.get().addBorrowedBook(book.get());

                        if (statusOfAdded) {
                            book.get().setAvailable(false);
                            System.out.print("\nBook Borrowed successfully ....\n");
                        } else {
                            System.out.print("\nMember Cannot Borrow More Than 3 Books\n");
                        }
                    }

                } else {
                    System.out.print("\nBook Not Available \n");
                }

            } else {
                System.out.print("\nBook Not Exist \n");
            }

        } else {
            System.out.print("\n Member is not Exist ...... \n");
        }
    }

    /**
     * Allows a member to return a previously borrowed book.
     * Checks whether the member and book exist and whether the specified
     * member has actually borrowed the book.
     *
     * @param bookId   the ID of the book to return
     * @param memberId the ID of the member returning the book
     */
    @Override
    public void returnBook(int bookId, int memberId) {

        boolean isExistMember = library.getMembers().stream()
                .anyMatch(librarymember -> librarymember.getId() == memberId);

        if (isExistMember) {

            boolean isExistBook = library.getBooks().stream()
                    .anyMatch(libraryBook -> libraryBook.getId() == bookId);

            if (isExistBook) {

                Optional<Book> book = library.getBooks().stream()
                        .filter(libraryBook -> libraryBook.getId() == bookId)
                        .findFirst();

                Optional<Member> member = library.getMembers().stream()
                        .filter(libraryMember -> libraryMember.getId() == memberId)
                        .findFirst();

                Book[] memberBorrowBooks = member.get().getBorrowedBooks();

                boolean isReturned = false;

                for (int i = 0; i < memberBorrowBooks.length; i++) {

                    if (memberBorrowBooks[i] != null &&
                            memberBorrowBooks[i].getId() == bookId) {

                        boolean statusReturnedBook =
                                member.get().returnBorrowedBook(memberBorrowBooks[i]);

                        if (statusReturnedBook) {
                            book.get().setAvailable(true);
                            isReturned = true;

                            System.out.println("Book Returned Successfully ....");
                        }
                    }
                }

                if (!isReturned) {
                    System.out.println("This Member Did Not Borrow This Book ....");
                }

            } else {
                System.out.print("\nBook Not Exist \n");
            }

        } else {
            System.out.print("\n Member is not Exist ...... \n");
        }
    }
}
