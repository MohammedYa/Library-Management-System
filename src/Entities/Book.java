package Entities;

import java.util.Objects;

public class Book {
private  int  id ;
private  String author;
private  String  title ;
private  String category;
private boolean  isAvailable;
 public  Book(int id ,String title ,String author,String category,boolean  isAvailable){
 setId(id);
 setTitle(title);
 setAuthor(author);
 setCategory(category);
 setAvailable(isAvailable);

 }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getCategory() {
        return category;
    }
    public boolean isAvailable() {
        return isAvailable;
    }


    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Book book = (Book) obj;

        return this.id == book.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public String toString() {

            return"\n Book Id is: " + getId()+ "|   Book Name is: " + getTitle()+ "   | Author Name is: " + getAuthor()
                    + " |   Category is: " + getCategory() + " |   " + (isAvailable() ? "Book Available" : "Book Not Available \n");

    }
}
