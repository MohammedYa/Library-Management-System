
package Entities;

import java.util.ArrayList;

/**
 * Represents a library that manages books and registered members.
 * Stores and provides access to the library's books and members.
 */
public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();

    /**
     * Constructs an empty library.
     */
    public Library() {
    }

    /**
     * Returns the list of registered members.
     *
     * @return the list of members
     */
    public ArrayList<Member> getMembers() {
        return members;
    }

    /**
     * Replaces the current list of members.
     *
     * @param members the new list of members
     */
    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    /**
     * Replaces the current list of books.
     *
     * @param books the new list of books
     */
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    /**
     * Returns the list of books in the library.
     *
     * @return the list of books
     */
    public ArrayList<Book> getBooks() {
        return books;
    }
}
