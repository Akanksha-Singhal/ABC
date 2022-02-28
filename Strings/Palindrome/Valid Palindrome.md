## Valid Palindrome

Source :: https://leetcode.com/problems/valid-palindrome/

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and 
removing all non-alphanumeric characters, it reads the same forward and backward. 
Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
 ```
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
```
Example 2:
```
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
```
Example 3:
```
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
```

Approach :: O(n/2) Two Pointer Approach

```java
class Solution {
    
    public boolean isAlnum(char c)
    {
        return (c>='A' && c<='Z')||(c>='a' && c<='z')||(c>='0' && c<='9');
    }
    public boolean isPalindrome(String s) {
        
        int n = s.length();
        int i=0, j = n-1;
        
        char ch[] = s.toCharArray();       
        
        while(i<j)
        {

            while(i<j && !isAlnum(ch[i])) i++;
            while(i<j && !isAlnum(ch[j])) j--;           
            
            if(Character.toLowerCase(ch[i]) != Character.toLowerCase(ch[j]))
                return false;
                
            i++; j--;
        }
        return true;
    }
}
```