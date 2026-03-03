import java.util.Scanner;

public class UseCase3PalindromeCheckerApp {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("Welcome to Palindrome Checker App - UC3");
        System.out.println("Version 1.0");
        System.out.println("=================================");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string to check palindrome (UC3): ");
        String input = sc.nextLine();

        // Reverse the string using loop
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }

        // Compare original and reversed
        if (input.equals(reversed)) {
            System.out.println("'" + input + "' is a Palindrome.");
        } else {
            System.out.println("'" + input + "' is NOT a Palindrome.");
        }

        sc.close();
    }
}