### Length of Last Word

#### Source :: https://www.interviewbit.com/problems/length-of-last-word/
#### Source :: https://leetcode.com/problems/length-of-last-word/

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
return the length of last word in the string.

If the last word does not exist, return 0.
Note: A word is defined as a character sequence consists of non-space characters only.

Example:
Given s = "Hello World", return 5 as length("World") = 5.
Please make sure you try to solve this problem without using library functions.
Make sure you only traverse the string once.

Approach :: Time :: O(n)

```java
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int lengthOfLastWord(final String str) 
    {
       // String s[] = str.split(" ");
         List<String> l = new ArrayList<String>();
         String splitstr="";
        
         for(int i=0; i<str.length();)
         {
            // skip all white spaces
            while(i<str.length() && str.charAt(i)==' ')
                i++;

            // add all the characters till we get the next white space
            int start = i;
            while(i<str.length() && str.charAt(i)!=' ')
                            i++;                            
            if(start <str.length() &&  str.charAt(start)!=' ')
                splitstr = str.substring(start, i);
            l.add(splitstr);
         }
         
        if(l.size()==0)
            return 0;
        return l.get(l.size()-1).length();
    }
}

```