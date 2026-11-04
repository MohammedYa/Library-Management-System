package Exeptions;

public class MemberHasBorrowedBooksException extends RuntimeException {
    public MemberHasBorrowedBooksException(String message) {
        super(message);
    }
}
