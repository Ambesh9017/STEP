import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Use Case 7: Deque Based Optimized Palindrome Checker
 * Description:
 * This class validates a palindrome using a Deque (Double Ended Queue). [cite: 67, 69]
 * Characters are inserted into the deque and then compared by removing
 * elements from both ends: removeFirst() and removeLast(). [cite: 70, 71, 72, 73]
 * This avoids reversing the string and provides an efficient
 * front-to-back comparison approach. [cite: 74, 75]
 * * @author Ambesh
 * @version 7.0
 */
public class PalindromeCheckerApp
{
    public static void main(String[] args)
    {
        String input = "refer"; [cite: 86]
        System.out.println("Input: " + input); [cite: 97]
        Deque<Character> deque = new ArrayDeque<>(); [cite: 88]
        for (char c : input.toCharArray()) { [cite: 90, 91]
            deque.addLast(c);
        }
        boolean isPalindrome = true; [cite: 93]
        while (deque.size() > 1) { [cite: 95]

            char first = deque.removeFirst(); [cite: 72]
            char last = deque.removeLast(); [cite: 73]
            if (first != last) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println("Is Palindrome?: " + isPalindrome); [cite: 98]
    }
}