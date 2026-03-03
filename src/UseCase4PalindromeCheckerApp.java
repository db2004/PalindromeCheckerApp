import java.util.Scanner;

public class UseCase4PalindromeCheckerApp {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("Welcome to Palindrome Checker App - UC4");
        System.out.println("Version 1.0");
        System.out.println("=================================");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string to check palindrome (UC4): ");
        String input = sc.nextLine();

        // Convert string to char array
        char[] chars = input.toCharArray();
        boolean isPalindrome = true;

        // Two-pointer approach
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        // Display result
        if (isPalindrome) {
            System.out.println("'" + input + "' is a Palindrome.");
        } else {
            System.out.println("'" + input + "' is NOT a Palindrome.");
        }

        sc.close();
    }
}