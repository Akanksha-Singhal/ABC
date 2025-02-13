Count Palindromic Substrings

Given a string count how many palindromic substrings are in this string. The subtrings with different start or end indexes are counted as different substrings.

```java

// Time Complexity - O(n)
    static String palindromesAroundCenter(String str, int i, int j)
    {
        String maxLenStr="";
        while(i>=0 && j<str.length())
        {
            if(str.charAt(i)!=str.charAt(j))
                return maxLenStr;

            maxLenStr = str.substring(i, j+1);
            i--; j++;
        }

        return maxLenStr;
    }

    // Time Complexity - O(n^2)
    public String longestPalindrome(String s)
    {
        String maxLenStr="", str1="", str2="";
        for(int i=0; i<s.length(); i++)
        {
            str1 = palindromesAroundCenter(s, i, i);

            if(i<s.length()-1)
            str2 = palindromesAroundCenter(s, i, i+1);

            str1 = (str1.length()>str2.length()) ? str1:str2;
            maxLenStr = (maxLenStr.length() > str1.length()) ? str1 : maxLenStr;
        }
        return maxLenStr;
    }

```