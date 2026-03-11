import java.util.Scanner;

/**
 * Service class to encapsulate Palindrome logic (Encapsulation)
 */
class PalindromeService {

    /**
     * Logic to check if a string is a palindrome.
     * This follows the Single Responsibility Principle.
     */
    public boolean checkPalindrome(String input) {
        if (input == null) return false;

        // Normalization (Internal logic hidden from the user)
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = clean.length() - 1;

        while (left < right) {
            if (clean.charAt(left++) != clean.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}

public class UseCase11PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instantiate the service (Object Creation)
        PalindromeService service = new PalindromeService();

        System.out.println("--- UC11: Object-Oriented Palindrome Service ---");
        System.out.print("Enter string: ");
        String input = scanner.nextLine();

        // Using the service object to perform the check
        if (service.checkPalindrome(input)) {
            System.out.println("Result: '" + input + "' is a Valid Palindrome.");
        } else {
            System.out.println("Result: Not a Palindrome.");
        }

        scanner.close();
    }
}