
package Entities;

import java.util.Arrays;
import java.util.Objects;

/**
 * Represents a library member.
 * Each member has an ID, name, email, and can borrow up to three books.
 */
public class Member {

    private int id;
    private String name;
    private String email;
    private Book[] borrowedBooks = new Book[3];

    /**
     * Constructs a new member with the specified information.
     *
     * @param id    the unique identifier of the member
     * @param name  the member's name
     * @param email the member's email address
     */
    public Member(int id, String name, String email) {
        setId(id);
        setName(name);
        setEmail(email);
    }

    /**
     * Returns the member ID.
     *
     * @return the unique identifier of the member
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the member ID.
     *
     * @param id the unique identifier of the member
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the member's name.
     *
     * @return the member's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the member's name.
     *
     * @param name the member's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the member's email address.
     *
     * @return the member's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the member's email address.
     *
     * @param email the member's email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Adds a book to the member's borrowed books.
     *
     * @param book the book to be borrowed
     * @return true if the book was added, false if the member has reached
     *         the maximum borrowing limit
     */
    public boolean addBorrowedBook(Book book) {
        for (int i = 0; i < borrowedBooks.length; i++) {
            if (borrowedBooks[i] == null) {
                borrowedBooks[i] = book;
                return true;
            }
        }

        return false;
    }

    /**
     * Removes a book from the member's borrowed books.
     *
     * @param book the book to be returned
     * @return true if the book was found and removed, otherwise false
     */
    public boolean returnBorrowedBook(Book book) {
        for (int i = 0; i < borrowedBooks.length; i++) {
            if (borrowedBooks[i] != null && borrowedBooks[i].equals(book)) {
                borrowedBooks[i] = null;
                return true;
            }
        }

        return false;
    }

    /**
     * Returns a copy of the member's borrowed books array.
     *
     * @return a copy of the borrowed books array
     */
    public Book[] getBorrowedBooks() {
        return Arrays.copyOf(borrowedBooks, borrowedBooks.length);
    }

    /**
     * Compares this member with another object based on the member ID.
     *
     * @param obj the object to compare with
     * @return true if both objects are members with the same ID
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Member member = (Member) obj;

        return this.id == member.id;
    }

    /**
     * Generates a hash code based on the member ID.
     *
     * @return the hash code of this member
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Returns a formatted string containing the member information.
     *
     * @return a string representation of the member
     */
    @Override
    public String toString() {
        return "\n Member Name is: " + getName()
                + " | Member Email is: " + getEmail() + "\n";
    }
}
