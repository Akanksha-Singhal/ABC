## Reverse a string

#### Source:: https://leetcode.com/problems/reverse-string/

Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

 
```java
class Solution {
    public void reverseString(char[] s) {
        
        int start =0, end = s.length-1;
        for(int i=0; i<=(end-start)/2; i++ )
        {
            char c = s[start+i];
            s[start+i] = s[end -i];
            s[end - i] = c;
        }
        
    }
}
```