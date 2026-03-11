import java.util.Scanner;

public class UseCase10PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC10: Case-Insensitive & Space-Ignored Checker ---");
        System.out.print("Enter a string (e.g., 'A man a plan a canal Panama'): ");
        String input = scanner.nextLine();

        if (isNormalizedPalindrome(input)) {
            System.out.println("Result: Success! It is a palindrome (ignoring spaces/case).");
        } else {
            System.out.println("Result: Not a palindrome.");
        }

        scanner.close();
    }

    public static boolean isNormalizedPalindrome(String input) {
        if (input == null) return false;

        // Step 1: Normalize the string
        // [^a-zA-Z0-9] means "anything that is NOT a letter or number"
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        System.out.println("Normalized String: " + cleanInput);

        // Step 2: Use Two-Pointer logic to verify
        int left = 0;
        int right = cleanInput.length() - 1;

        while (left < right) {
            if (cleanInput.charAt(left) != cleanInput.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}