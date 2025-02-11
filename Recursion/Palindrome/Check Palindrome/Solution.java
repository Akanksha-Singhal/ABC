
import java.util.*;
import java.lang.*;

class Solution
{
    static boolean checkPalindrome(String str, int i)
    {
        int n = str.length();
        if(i==n/2)
            return true;
        else if(str.charAt(i) != str.charAt(n-1-i))
            return false;
        else
            return checkPalindrome(str, i+1);
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String str = sc.next();
        boolean isPalindrome = checkPalindrome(str, 0);
        System.out.println(isPalindrome?"Palindrome": "Not a Palindrome");

    }
}