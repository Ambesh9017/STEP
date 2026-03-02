import java.util.Stack;
public class UseCase5PalindromeCheckerApp
{
    public static void main(String[] args)
    {
        System.out.println("Palindrome Checker App");
        System.out.println("UC5: Stack-Based Palindrome Checker");
        System.out.println();
        String word = "madam";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed = reversed + stack.pop();
        }
        if (word.equals(reversed))
        {
            System.out.println(word + " is a Palindrome.");
        } else
        {
            System.out.println(word + " is not a Palindrome.");
        }
    }
}