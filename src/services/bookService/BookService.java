package services.bookService;

import Entities.Book;

import java.util.ArrayList;

public interface BookService {
     void addBook(int id ,String title ,String author,String category,boolean  isAvailable);
     void removeBook(int id);
     Book SearchBook(int id);
     void displayAllBooks();
    ArrayList<Book> displayAvailableOrBorrowedBooks(boolean isAvailable);}
