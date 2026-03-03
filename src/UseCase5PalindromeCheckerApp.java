import java.util.Scanner;
import java.util.Stack;

public class UseCase5PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Palindrome Checker (Stack-Based) ---");
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
        // Clean the input: remove spaces/punctuation and convert to lowercase
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (cleanInput.isEmpty()) return true;

        // Step 1: Push all characters onto the Stack
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < cleanInput.length(); i++) {
            stack.push(cleanInput.charAt(i));
        }

        // Step 2: Pop characters and compare with original cleanInput
        // Since Stack is LIFO, popping gives the string in reverse order
        StringBuilder reversedInput = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedInput.append(stack.pop());
        }

        // Step 3: Compare original vs reversed
        return cleanInput.equals(reversedInput.toString());
    }
}