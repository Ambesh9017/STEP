public class PalindromeCheckerApp
{
    public static void main(String[] args)
    {
        System.out.println("Palindrome Checker App");
        System.out.println("UC4: Character Array Based Palindrome Check");
        System.out.println();
        String word = "radar";
        char[] characters = word.toCharArray();
        int start = 0;
        int end = characters.length - 1;
        boolean isPalindrome = true;
        while (start < end) {
            if (characters[start] != characters[end])
            {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        if (isPalindrome)
        {
            System.out.println(word + " is a Palindrome.");
        } else
        {
            System.out.println(word + " is not a Palindrome.");
        }
    }
}