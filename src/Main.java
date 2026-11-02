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
                    System.out.print("\n  Wellcome  to  Add Book page \n");
                    break;
                case 2:
                    coutOfTry = 1;
                    System.out.print("Remove Book");
                    break;
                case 3:
                    coutOfTry = 1;
                    System.out.print("Search Book");
                    break;
                case 4:
                    coutOfTry = 1;
                    System.out.print("Display All Book");
                    break;
                case 5:
                    coutOfTry = 1;
                    System.out.print("Display Available Books");
                    break;
                case 6:
                    coutOfTry = 1;
                    System.out.print("Display Borrowed Books");
                    break;
                case 7:
                    coutOfTry = 1;
                    System.out.print("Register Member");
                    break;
                case 8:
                    coutOfTry = 1;
                    System.out.print("Remove Member");
                    break;
                case 9:
                    coutOfTry = 1;
                    System.out.print("Search Member");
                    break;
                case 10:
                    coutOfTry = 1;
                    System.out.print("Display All Members");
                    break;
                case 11:
                    coutOfTry = 1;
                    System.out.print("Borrow Book");
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
    String title = scanner.nextLine();
    System.out.print("\n  Enter Book Author :  \n");
    String author = scanner.nextLine();
    System.out.print("\n  Enter Book category :  \n");
    String category= scanner.nextLine();



}