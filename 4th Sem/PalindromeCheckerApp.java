import java.util.LinkedList;

/**
 * Use Case 8: Linked List Based Palindrome Checker
 * Description:
 * This class checks whether a string is a palindrome using a LinkedList. [cite: 119]
 * Characters are added to the list and then compared by removing elements
 * from both ends: removeFirst() and removeLast(). [cite: 120, 121, 122, 123]
 * * @author Ambesh
 * @version 8.0
 */
public class PalindromeCheckerApp
{
    public static void main(String[] args)
    {
        String input = "level"; [cite: 137]
        System.out.println("Input: " + input); [cite: 148]
        LinkedList<Character> list = new LinkedList<>();
        for (char c : input.toCharArray()) { [cite: 141, 142]
            list.add(c);
        }
        boolean isPalindrome = true; [cite: 144]
        while (list.size() > 1) { [cite: 146]
            char first = list.removeFirst(); [cite: 121, 122]
            char last = list.removeLast(); [cite: 121, 123]

            if (first != last) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println("Is Palindrome?: " + isPalindrome);
    }
}