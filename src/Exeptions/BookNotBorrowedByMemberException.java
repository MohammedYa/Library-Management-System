package Exeptions;

public class BookNotBorrowedByMemberException extends RuntimeException {

    public BookNotBorrowedByMemberException(String message) {
        super(message);
    }
}