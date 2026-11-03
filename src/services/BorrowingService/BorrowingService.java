
package services.BorrowingService;

/**
 * Defines the operations for borrowing and returning books
 * in the library management system.
 */
public interface BorrowingService {

    /**
     * Allows a library member to borrow a book.
     *
     * @param bookId   the ID of the book to borrow
     * @param memberId the ID of the member borrowing the book
     */
    void borrowBook(int bookId, int memberId);

    /**
     * Allows a library member to return a previously borrowed book.
     *
     * @param bookId   the ID of the book to return
     * @param memberId the ID of the member returning the book
     */
    void returnBook(int bookId, int memberId);
}
