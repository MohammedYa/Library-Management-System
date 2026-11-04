
package services.bookService;

import Entities.Book;
import Entities.Library;
import Exeptions.BookAlreadyExistsException;
import Exeptions.BookNotFoundException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implements the book management operations defined in BookService.
 * Uses a shared Library instance to manage books.
 */
public class BookServiceImpl implements BookService {

    private Library library;

    /**
     * Constructs the service using the shared library instance.
     *
     * @param library the library whose books will be managed
     */
    public BookServiceImpl(Library library) {
        this.library = library;
    }

    /**
     * Adds a new book if its ID does not already exist.
     *
     * @param bookId      the unique identifier of the book
     * @param title       the title of the book
     * @param author      the author of the book
     * @param category    the category of the book
     * @param isAvailable the availability status of the book
     */
    @Override
    public void addBook(int bookId, String title, String author,
                        String category, boolean isAvailable) {

        Book book = new Book(bookId, title, author, category, isAvailable);

        boolean isExistBook = library.getBooks().stream()
                .anyMatch(libraryBook -> libraryBook.getId() == bookId);

        if (!isExistBook) {
            library.getBooks().add(book);
            System.out.print("Book Added Successfully . \n");
        } else {
            throw new BookAlreadyExistsException("Book Already Exists.");
        }
    }

    /**
     * Removes a book from the library using its ID.
     *
     * @param id the ID of the book to remove
     */
    @Override
    public void removeBook(int id) {

        boolean isExistBook = library.getBooks().stream()
                .anyMatch(libraryBook -> libraryBook.getId() == id);

        if (isExistBook) {
            Iterator<Book> iterator = library.getBooks().iterator();

            while (iterator.hasNext()) {
                Book book = iterator.next();

                if (book.getId() == id) {
                    iterator.remove();
                    System.out.println("Book Removed Successfully.\n");
                    break;
                }
            }
        } else {

            throw new BookNotFoundException("Book Not Found. Cannot remove it.");        }
    }

    /**
     * Searches for a book using its ID.
     *
     * @param id the ID of the book to search for
     * @return the matching book, or null if it does not exist
     */
    @Override
    public Book searchBook(int id) {

        Optional<Book> book = library.getBooks().stream()
                .filter(libraryBook -> libraryBook.getId() == id)
                .findFirst();

        return book.orElseThrow(() ->
                new BookNotFoundException("Book Not Found.")
        );
    }

    /**
     * Displays all books currently stored in the library.
     * Prints a message if the library is empty.
     */
    @Override
    public void displayAllBooks() {

        if (!library.getBooks().isEmpty()) {
            library.getBooks().stream()
                    .forEach(System.out::println);
        } else {
            System.out.print("Library Is Empty .... \n ");
        }
    }

    /**
     * Retrieves books according to their availability status.
     *
     * @param isAvailable true to retrieve available books,
     *                    false to retrieve borrowed books
     * @return an ArrayList containing the matching books,
     *         or an empty list if the library is empty
     */
    @Override
    public ArrayList<Book> displayAvailableOrBorrowedBooks(boolean isAvailable) {

        if (!library.getBooks().isEmpty()) {
            return library.getBooks().stream()
                    .filter(book -> book.isAvailable() == isAvailable)
                    .collect(Collectors.toCollection(ArrayList::new));
        } else {
            System.out.print("Library Is Empty ....");
        }

        return new ArrayList<>();
    }

    /**
     * Sorts the library books according to the selected option.
     *
     * @param sortOption 1 to sort by title,
     *                   2 to sort by author,
     *                   any other number to sort by book ID
     */
    @Override
    public void sortBooks(int sortOption) {

        if (sortOption == 1) {
            Comparator<Book> comparator = (book1, book2) -> {
                return book1.getTitle().compareTo(book2.getTitle());
            };

            library.getBooks().sort(comparator);

        } else if (sortOption == 2) {
            Comparator<Book> comparator = (book1, book2) -> {
                return book1.getAuthor().compareTo(book2.getAuthor());
            };

            library.getBooks().sort(comparator);

        } else {
            Comparator<Book> comparator = (book1, book2) -> {
                return Integer.compare(book1.getId(), book2.getId());
            };

            library.getBooks().sort(comparator);
        }
    }
}
