import java.util.Scanner;

class Node {
    char data;
    Node next;
    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class UseCase8PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- UC8: Linked List Based Palindrome ---");
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
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if (clean.isEmpty()) return true;

        // Step 1: Create Singly Linked List
        Node head = new Node(clean.charAt(0));
        Node current = head;
        for (int i = 1; i < clean.length(); i++) {
            current.next = new Node(clean.charAt(i));
            current = current.next;
        }

        // Step 2: Find middle (Fast/Slow)
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 3: Reverse second half

        Node prev = null, nextNode;
        while (slow != null) {
            nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }

        // Step 4: Compare halves
        Node left = head, right = prev;
        while (right != null) {
            if (left.data != right.data) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }
}