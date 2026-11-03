package services.BorrowingService;

public interface BorrowingService {
    void borrowBook(int bookId,int memberId);
    void returnBook(int bookId,int memberId);
}
