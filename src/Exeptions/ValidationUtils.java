package Exeptions;

public class ValidationUtils {
    public static boolean validId(int id){
        return id>0;
    }

    public static boolean validName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static boolean validEmail(String email) {
        if (email == null || email.isBlank()) {
            return false;
        }

        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }

    public static boolean validText(String text, int minLength) {
        return text != null && text.trim().length() >= minLength;
    }
}
