## Convert to Palindrome

#### Source :: https://leetcode.com/problems/valid-palindrome-ii/

Given a string s, return true if the s can be palindrome after deleting at most one character from it.

 

Example 1:
```
Input: s = "aba"
Output: true
```
Example 2:
```
Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
```
Example 3:
```
Input: s = "abc"
Output: false
```

```java
class Solution {
    
    public boolean checkPalindrome(String s, int start, int end)
    {
        char ch[] = s.toCharArray();
        for(int i=0; i<=(end-start)/2; i++)
        {
            if(ch[start+i] != ch[end-i])
                return false;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        
        
        int start =0, end = s.length()-1;
        char ch[] = s.toCharArray();
        
        while(start < end)
        {
            if(ch[start]!=ch[end])
                if(checkPalindrome(s, start+1, end)||checkPalindrome(s, start, end-1))
                    return true;
                else
                    return false;
                
            start++; end--;
            
        }
        return true;
        
    }
}
```