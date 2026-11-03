package Entities;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();

    public Library(){

    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
