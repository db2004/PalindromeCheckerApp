import java.util.Scanner;

public class UseCase9PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC9: Recursive Palindrome Checker ---");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Normalize string: lowercase and remove non-alphanumeric
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (isPalindromeRecursive(cleanInput, 0, cleanInput.length() - 1)) {
            System.out.println("Result: '" + input + "' is a palindrome.");
        } else {
            System.out.println("Result: '" + input + "' is NOT a palindrome.");
        }

        scanner.close();
    }

    /**
     * Recursive method to check palindrome
     * Uses the Call Stack to manage comparisons
     */
    public static boolean isPalindromeRecursive(String str, int start, int end) {
        // Base Condition: If pointers cross or meet, it's a palindrome
        if (start >= end) {
            return true;
        }

        // Check if characters at current pointers match
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive Call: Move pointers inward
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
}