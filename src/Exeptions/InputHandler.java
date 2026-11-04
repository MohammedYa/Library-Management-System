package Exeptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {

    private Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readInt(String message, String errorMessage) {
        int attempts = 0;

        while (attempts < 3) {
            try {
                System.out.print(message);
                return scanner.nextInt();

            } catch (InputMismatchException e) {
                attempts++;

                System.out.println(errorMessage);

                scanner.nextLine();

                if (attempts == 3) {
                    throw new RuntimeException("Maximum attempts exceeded.");
                }
            }
        }

        return 0;
    }

    public String readValidString(String message, String errorMessage, int minLength) {

        while (true) {
            System.out.print(message);

            String value = scanner.nextLine().trim();

            if (ValidationUtils.validText(value, minLength)) {
                return value;
            }

            System.out.println(errorMessage);
        }
    }
    public String readValidEmail() {
        int attempts = 0;

        while (attempts < 3) {
            System.out.print("Enter Member Email: ");

            String value = scanner.nextLine().trim();

            if (ValidationUtils.validEmail(value)) {
                return value;
            }

            attempts++;
            System.out.println("Invalid Email. Attempts left: " + (3 - attempts));
        }

        throw new RuntimeException("Maximum attempts exceeded.");
    }

}