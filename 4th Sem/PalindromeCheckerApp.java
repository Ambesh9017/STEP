import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Use Case 6: Queue Stack Fairness Check
 * Description:
 * This class demonstrates palindrome validation using two different data structures:
 * Queue (FIFO - First In First Out) and Stack (LIFO - Last In First Out).
 * Characters are inserted into both structures and then compared by removing
 * from the front of the queue and the top of the stack. [cite: 18, 19, 21, 26]
 * * @author Ambesh
 * @version 6.0
 */
public class PalindromeCheckerApp
{
    public static void main(String[] args)
    {
        String input = "civic";
        System.out.println("Input: " + input);
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray())
        {
            queue.add(c);
            stack.push(c);
        }
        boolean isPalindrome = true;
        while (!queue.isEmpty())
        {
            char fromQueue = queue.remove();
            char fromStack = stack.pop();
            if (fromQueue != fromStack)
            {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Is Palindrome?: " + isPalindrome);
    }
}