import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class UseCase7PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Palindrome Checker (Deque-Based) ---");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("Result: '" + input + "' is a palindrome.");
        } else {
            System.out.println("Result: '" + input + "' is NOT a palindrome.");
        }

        scanner.close();
    }

    public static boolean isPalindrome(String input) {
        // Clean the input: lowercase and remove non-alphanumeric
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (cleanInput.length() <= 1) return true;

        // Step 1: Insert all characters into the Deque
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : cleanInput.toCharArray()) {
            deque.addLast(ch); // Add to the back
        }

        // Step 2: Compare front and rear simultaneously
        // A palindrome must match from both ends moving inward
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                return false; // Symmetries broken
            }
        }

        return true; // If we get here, it's a palindrome
    }
}