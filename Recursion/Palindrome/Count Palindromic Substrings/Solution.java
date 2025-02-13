import java.util.*;
import java.lang.*;
class Solution
{
    static int countPalindromesAroundCenter(String str, int i, int j)
    {
        int count =0;
        while(i>=0 && j<str.length())
        {
            // comparing characters at positions i and j
            if(str.charAt(i)!=str.charAt(j))
                return count;
            count++;
            i--;  j++;
        }
        return count;
    }

    static int countSubstrings(String s)
    {
        int count =0;

        for(int i=0; i<s.length(); i++)
        {
            // the center is a single letter (odd length palindromes)
            count += countPalindromesAroundCenter(s, i, i);

            //the center is two letters (even length palindromes)
            if(i!=s.length()-1)
            count += countPalindromesAroundCenter(s, i, i+1);
        }

        return count;
    }
    public static void main (String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String str = sc.next();
        int res = countSubstrings(str);
        System.out.println("No of substrings : "+res);

    }
}