
package Entities;

import java.util.Objects;

/**
 * Represents a book in the library management system.
 * Each book has a unique ID, title, author, category, and availability status.
 */
public class Book {

    private int id;
    private String author;
    private String title;
    private String category;
    private boolean isAvailable;

    /**
     * Constructs a new Book with the specified information.
     *
     * @param id          the unique identifier of the book
     * @param title       the title of the book
     * @param author      the author of the book
     * @param category    the category of the book
     * @param isAvailable the availability status of the book
     */
    public Book(int id, String title, String author, String category, boolean isAvailable) {
        setId(id);
        setTitle(title);
        setAuthor(author);
        setCategory(category);
        setAvailable(isAvailable);
    }

    /**
     * Sets the book ID.
     *
     * @param id the unique identifier of the book
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the book title.
     *
     * @param title the title of the book
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the book author.
     *
     * @param author the author of the book
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Sets the book category.
     *
     * @param category the category of the book
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Sets the availability status of the book.
     *
     * @param available true if the book is available, otherwise false
     */
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    /**
     * Returns the book ID.
     *
     * @return the unique identifier of the book
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the book title.
     *
     * @return the title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the book author.
     *
     * @return the author of the book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns the book category.
     *
     * @return the category of the book
     */
    public String getCategory() {
        return category;
    }

    /**
     * Checks whether the book is available.
     *
     * @return true if the book is available, otherwise false
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * Compares this book with another object based on its ID.
     *
     * @param obj the object to compare with
     * @return true if both objects are books with the same ID
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Book book = (Book) obj;

        return this.id == book.id;
    }

    /**
     * Generates a hash code based on the book ID.
     *
     * @return the hash code of this book
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Returns a formatted string containing the book information.
     *
     * @return a string representation of the book
     */
    @Override
    public String toString() {
        return "\n Book Id is: " + getId()
                + "|   Book Name is: " + getTitle()
                + "   | Author Name is: " + getAuthor()
                + " |   Category is: " + getCategory()
                + " |   " + (isAvailable() ? "Book Available" : "Book Not Available \n");
    }
}
