import java.util.Scanner;
import java.util.Stack;

public class UseCase5PalindromeCheckerApp {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("Welcome to Palindrome Checker App - UC5");
        System.out.println("Version 1.0");
        System.out.println("=================================");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string to check palindrome (UC5): ");
        String input = sc.nextLine();

        // Use stack to reverse
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        boolean isPalindrome = true;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("'" + input + "' is a Palindrome.");
        } else {
            System.out.println("'" + input + "' is NOT a Palindrome.");
        }

        sc.close();
    }
}