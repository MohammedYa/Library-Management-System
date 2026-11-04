
package services.BorrowingService;

import Entities.Book;
import Entities.Library;
import Entities.Member;

import Exeptions.BookNotFoundException;
import Exeptions.MemberNotFoundException;
import Exeptions.BookNotAvailableException;
import Exeptions.BorrowingLimitExceededException;
import Exeptions.BookNotBorrowedByMemberException;

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
     *
     * @param bookId the ID of the book to borrow
     * @param memberId the ID of the member borrowing the book
     */
    @Override
    public void borrowBook(int bookId, int memberId) {

        Optional<Member> member = library.getMembers().stream()
                .filter(libraryMember -> libraryMember.getId() == memberId)
                .findFirst();

        if (member.isEmpty()) {
            throw new MemberNotFoundException("Member Not Found.");
        }

        Optional<Book> book = library.getBooks().stream()
                .filter(libraryBook -> libraryBook.getId() == bookId)
                .findFirst();

        if (book.isEmpty()) {
            throw new BookNotFoundException("Book Not Found.");
        }

        if (!book.get().isAvailable()) {
            throw new BookNotAvailableException("Book Not Available.");
        }

        boolean statusOfAdded = member.get().addBorrowedBook(book.get());

        if (statusOfAdded) {
            book.get().setAvailable(false);
            System.out.println("\nBook Borrowed Successfully ....\n");
        } else {
            throw new BorrowingLimitExceededException(
                    "Member Cannot Borrow More Than 3 Books."
            );
        }
    }

    /**
     * Allows a member to return a previously borrowed book.
     *
     * @param bookId the ID of the book to return
     * @param memberId the ID of the member returning the book
     */
    @Override
    public void returnBook(int bookId, int memberId) {

        Optional<Member> member = library.getMembers().stream()
                .filter(libraryMember -> libraryMember.getId() == memberId)
                .findFirst();

        if (member.isEmpty()) {
            throw new MemberNotFoundException("Member Not Found.");
        }

        Optional<Book> book = library.getBooks().stream()
                .filter(libraryBook -> libraryBook.getId() == bookId)
                .findFirst();

        if (book.isEmpty()) {
            throw new BookNotFoundException("Book Not Found.");
        }

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
                    break;
                }
            }
        }

        if (!isReturned) {
            throw new BookNotBorrowedByMemberException(
                    "This Member Did Not Borrow This Book."
            );
        }
    }
}
