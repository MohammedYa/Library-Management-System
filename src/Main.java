import Entities.Book;
import Entities.Library;
import Entities.Member;
import services.BorrowingService.BorrowingServiceImpl;
import services.MembersService.MemberServiceImpl;
import services.bookService.BookServiceImpl;


Library library=new Library();
BookServiceImpl bookService=new BookServiceImpl(library);
MemberServiceImpl memberService=new MemberServiceImpl(library);
BorrowingServiceImpl borrowingService= new BorrowingServiceImpl(library);

Scanner scanner =new Scanner(System.in);

void main() {
    Start ();
}


public  void Start (){
int coutOfTry=1;
boolean status=true;
    while (status){
        System.out.print("========== LIBRARY MANAGEMENT SYSTEM ==========\n" +
                "\n" +
                "1. Add Book\n" +
                "2. Remove Book\n" +
                "3. Search Book\n" +
                "4. Display All Books\n" +
                "5. Display Available Books\n" +
                "6. Display Borrowed Books\n" +
                "\n" +
                "7. Register Member\n" +
                "8. Remove Member\n" +
                "9. Search Member\n" +
                "10. Display All Members\n" +
                "\n" +
                "11. Borrow Book\n" +
                "12. Return Book\n" +
                "\n" +
                "13. Sort Books\n" +
                "14. Exit\n" +
                "\n" +
                "===============================================\n" +
                "Enter your choice: ");
        try {
            int numOfOperation =scanner.nextInt();

            switch (numOfOperation){
                case 1:
                    coutOfTry = 1;
                    System.out.print("\n  Welcome  to  Add Book page \n");
                    addBook();
                    break;
                case 2:
                    coutOfTry = 1;
                    System.out.print(" Welcome  to Remove Book page");
                    removeBook();
                    break;
                case 3:
                    coutOfTry = 1;
                    System.out.print("Welcome  to Search Book page ");
                    searchBook();
                    break;
                case 4:
                    coutOfTry = 1;
                    System.out.print(" Welcome Display All Book page");
                    displayBooks();
                    break;
                case 5:
                    coutOfTry = 1;
                    System.out.print(" Welcome Display Available Books page");
                    displayAvailableOrBorrowedBooks(true);
                    break;
                case 6:
                    coutOfTry = 1;
                    System.out.print("welcome Display Borrowed Books page");
                    displayAvailableOrBorrowedBooks(false);
                    break;
                case 7:
                    coutOfTry = 1;
                    System.out.print(" welcome Register Member");
                    registerMember();
                    break;
                case 8:
                    coutOfTry = 1;
                    System.out.print("Remove Member");
                    removeMember();
                    break;
                case 9:
                    coutOfTry = 1;
                    System.out.print("Search Member");
                    searchMember();
                    break;
                case 10:
                    coutOfTry = 1;
                    System.out.print("Display All Members");
                    displayAllMembers();
                    break;
                case 11:
                    coutOfTry = 1;
                    System.out.print("Borrow Book Page");
                    borrowBook();
                    break;
                case 12:
                    coutOfTry = 1;
                    System.out.print("Return Book");
                    break;
                case 13:
                    coutOfTry = 1;
                    System.out.print("Sort Book");
                    break;
                case 14:
                    System.out.print("Exist :");
                    status=false;
                    break;
                default:
                    System.out.print("\n Your Number is not valid Please Enter number Relate perviouis Operation : \n ");
                    if (coutOfTry<3){
                        System.out.print("\n  You have "+(3-coutOfTry)+" chance: \n ");
                        coutOfTry++;

                    }
                    else {
                        System.out.print("\n  Thank you ------->  Try again next Time   : \n ");
                        status= false;
                    }


            }
        }
        catch (InputMismatchException e){
            if (coutOfTry<3){
                System.out.print("\n Enter Number between 1 - 14 \n");
                System.out.print("\n  You have "+(3-coutOfTry)+" chance: \n ");
                coutOfTry++;
                scanner.nextLine();
            }
            else {
                System.out.print("\n  Thank you ------->  Try again next Time   : \n ");
                status= false;
            }

        }


    }







}
public void  addBook(){
    System.out.print("\n  Enter Book Id :  \n");
    int id = scanner.nextInt();
    System.out.print("\n  Enter Book title :  \n");
    String title = scanner.next();
    System.out.print("\n  Enter Book Author :  \n");
    String author = scanner.next();
    System.out.print("\n  Enter Book category :  \n");
    String category= scanner.next();
    bookService.addBook(id,title,author,category,true);


}
public void removeBook( ){
    System.out.print("\n  Enter Book Id :  \n");
    int id = scanner.nextInt();
    bookService.removeBook(id);
}
public void searchBook( ){
    System.out.print("\n  Enter Book Id :  \n");
    int id = scanner.nextInt();
   Book book= bookService.searchBook(id);
   if(book==null){
       System.out.print("Book Not found ");

   }
   else{
       System.out.print(book+"\n");

   }
}
public void  displayBooks(){
    bookService.displayAllBooks();
}
public void displayAvailableOrBorrowedBooks(boolean isAvailable) {
    bookService.displayAvailableOrBorrowedBooks(isAvailable)
            .forEach(System.out::println);
}


public  void registerMember(){
    System.out.print("\n  Enter Member Id :  \n");
    int id = scanner.nextInt();
    System.out.print("\n  Enter Member Name :  \n");
    String name = scanner.next();
    System.out.print("\n  Enter Member Email :  \n");
    String email = scanner.next();
    memberService.registerMember(id,name,email);

}
public  void removeMember(){
    System.out.print("\n  Enter Member Id :  \n");
    int id = scanner.nextInt();
    memberService.removeMember(id);
}
public  void searchMember(){
    System.out.print("\n  Enter Member Id :  \n");
    int id = scanner.nextInt();
    Member member= memberService.searchMember(id);
    if(member!=null){
        System.out.print(member);

    }
    else{
        System.out.print("Member Not found ");

    }
}
public  void displayAllMembers(){

     memberService.displayAllMembers();
}
public  void borrowBook(){
    System.out.print("\n  Enter Member Id :  \n");
    int memberId = scanner.nextInt();
    System.out.print("\n  Enter Book Id :  \n");
    int bookId = scanner.nextInt();
    borrowingService.borrowBook(bookId,memberId);
}

