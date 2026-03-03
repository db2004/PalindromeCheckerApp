import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class UseCase6PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Palindrome Checker (Queue + Stack) ---");
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
        // Normalize the string: remove non-alphanumeric and convert to lowercase
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Handle empty strings or single characters
        if (cleanInput.isEmpty()) return true;

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Step 1: Enqueue and Push characters
        for (char c : cleanInput.toCharArray()) {
            queue.add(c);
            stack.push(c);
        }

        // Step 2: Compare Dequeue (FIFO) vs Pop (LIFO)
        while (!queue.isEmpty()) {
            char fromQueue = queue.remove(); // Removes from head
            char fromStack = stack.pop();    // Removes from top

            if (fromQueue != fromStack) {
                return false; // Mismatch found
            }
        }

        return true; // All characters matched
    }
}