package services.BorrowingService;

import Entities.Book;
import Entities.Library;
import Entities.Member;

import java.util.Optional;

public class BorrowingServiceImpl implements BorrowingService {

    private   Library library ;
    public BorrowingServiceImpl(Library library){
        this.library=library;
    }

    @Override
    public void borrowBook(int bookId, int memberId) {
        boolean isExistMember=  library.getMembers().stream().anyMatch(librarymember-> librarymember.getId()==memberId);
        if(isExistMember){
            boolean isExistBook = library.getBooks().stream().anyMatch(libraryBook->libraryBook.getId()==bookId);
            Optional<Book> book = library.getBooks().stream().filter(libraryBook -> libraryBook.getId() == bookId).findFirst();
            if(isExistBook){

                if (book.get().isAvailable()){
                    Optional<Member> member= library.getMembers().stream()
                            .filter(libraryMember -> libraryMember.getId() == memberId).findFirst();
                    if(member.isPresent()){
                        boolean statusOfAdded=  member.get().addBorrowedBook(book.get());

                        if(statusOfAdded){
                            book.get().setAvailable(false);
                            System.out.print("\nBook Borrowed successfully ....\n");

                        }
                        else {
                            System.out.print("\nMember Cannot Borrow More Than 3 Books\n");
                        }
                    }
                }
                else{
                    System.out.print("\nBook Not Available \n");

                }

            }
            else{
                System.out.print("\nBook Not Exist \n");
            }
        }
        else{
            System.out.print("\n Member is not Exist ...... \n");
        }

    }

    @Override
    public void returnBook(int bookId, int memberId) {

    }
}
