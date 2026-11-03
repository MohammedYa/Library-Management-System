package services.bookService;

import Entities.Book;
import Entities.Library;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {
    private   Library library ;
    public  BookServiceImpl(  Library library){
        this.library=library;
    }

    @Override
    public void addBook(int bookId, String title, String author, String category, boolean isAvailable) {
        Book book = new Book(bookId, title, author, category, isAvailable);
        boolean isExistBook = library.getBooks().stream().anyMatch(libraryBook->libraryBook.getId()==bookId);
        if(!isExistBook){
            library.getBooks().add(book);
            System.out.print("Book Added Successfully . \n");
        }
        else {
            System.out.print("Book Already Exists .");

        }
    }

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
            System.out.println("Book Not Found.\n");
        }
    }

    @Override
    public Book searchBook(int id) {
        Optional<Book> book = library.getBooks().stream().filter(libraryBook -> libraryBook.getId() == id).findFirst();
        return book.orElse(null);

    }

    @Override
    public void displayAllBooks() {
        if (!library.getBooks().isEmpty()) {
            library.getBooks().stream()
                    .forEach(System.out::println);
        } else {
            System.out.print("Library Is Empty .... \n ");
        }

    }

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


}
