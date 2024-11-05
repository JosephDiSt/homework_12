import java.util.regex.*;

public class PasswordValidator {

    public static boolean isValidPassword(String password) {
        // Check if password length is between 8 and 16
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        // Define patterns for each category
        Pattern lowerCasePattern = Pattern.compile("[a-z]");
        Pattern upperCasePattern = Pattern.compile("[A-Z]");
        Pattern digitPattern = Pattern.compile("[0-9]");
        Pattern specialCharPattern = Pattern.compile("[~!@#$%^&*()\\-=+_]");

        // Check for the presence of each category
        boolean hasLower = lowerCasePattern.matcher(password).find();
        boolean hasUpper = upperCasePattern.matcher(password).find();
        boolean hasDigit = digitPattern.matcher(password).find();
        boolean hasSpecial = specialCharPattern.matcher(password).find();

        // Count the number of categories present
        int categoryCount = 0;
        if (hasLower) categoryCount++;
        if (hasUpper) categoryCount++;
        if (hasDigit) categoryCount++;
        if (hasSpecial) categoryCount++;

        // Password is valid if it contains at least 3 out of 4 categories
        return categoryCount >= 3;
    }

    public static void main(String[] args) {
        // Test cases
        String[] passwords = {"joebuckets1", "Joebuckets1", "Joebuckets!", "Joebuckets1!", "Pass1!"};

        for (String password : passwords) {
            System.out.println("Password: " + password + " is valid: " + isValidPassword(password));
        }
    }
}


