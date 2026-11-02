package Entities;

import java.util.Arrays;
import java.util.Objects;

public class Member {


    private  int  id ;
    private  String name;
    private  String  email ;
    private Book[] borrowedBooks = new Book[3];

public Member(int id , String name , String  email ){
setId(id);
setName(name);
setEmail(email);
}
     public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }





  public  boolean addBorrowedBook(Book book){
    for( int i =0 ;i<borrowedBooks.length;i++){
        if(borrowedBooks[i]==null){
            borrowedBooks[i]=book;
            return  true;
        }

    }

          return false;

  }

  public  boolean returnBorrowedBook(Book book){
        for( int i =0 ;i<borrowedBooks.length;i++){
            if(borrowedBooks[i].equals(book)){
                borrowedBooks[i]=null;
                return  true;
            }

        }

        return false;

    }

  public  Book[] getBorrowedBooks()
  {
     return Arrays.copyOf(borrowedBooks, borrowedBooks.length);
  }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Member member = (Member) obj;

        return this.id == member.id ;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public String toString() {

        return "Member Name is: " + getName()+ " | Member Email is: " + getEmail();

    }
}
