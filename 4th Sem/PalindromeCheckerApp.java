public class PalindromeCheckerApp
{
    public static void main(String[] args)
    {
        System.out.println("Palindrome Checker App");
        System.out.println("UC3: Palindrome Check Using String Reverse");
        System.out.println();
        String word = "level";
        String reversed = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i);
        }
        if (word.equals(reversed)) {
            System.out.println(word + " is a Palindrome.");
        } else {
            System.out.println(word + " is not a Palindrome.");
        }
    }
}