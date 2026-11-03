
package services.bookService;

import Entities.Book;
import java.util.ArrayList;

/**
 * Defines the operations available for managing books in the library.
 */
public interface BookService {

     /**
      * Adds a new book to the library.
      *
      * @param id          the unique identifier of the book
      * @param title       the title of the book
      * @param author      the author of the book
      * @param category    the category of the book
      * @param isAvailable the availability status of the book
      */
     void addBook(int id, String title, String author, String category, boolean isAvailable);

     /**
      * Removes a book from the library using its ID.
      *
      * @param id the ID of the book to remove
      */
     void removeBook(int id);

     /**
      * Searches for a book using its ID.
      *
      * @param id the ID of the book to search for
      * @return the matching book, or null if no book is found
      */
     Book searchBook(int id);

     /**
      * Displays all books registered in the library.
      */
     void displayAllBooks();

     /**
      * Retrieves books based on their availability status.
      *
      * @param isAvailable true to retrieve available books,
      *                    false to retrieve borrowed books
      * @return a list of books matching the specified availability status
      */
     ArrayList<Book> displayAvailableOrBorrowedBooks(boolean isAvailable);

     /**
      * Sorts the books according to the selected sorting option.
      *
      * @param sortOption the sorting option:
      *                   1 for title, 2 for author, and 3 for book ID
      */
     void sortBooks(int sortOption);
}
