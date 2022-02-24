## Reverse String II

Source :: https://leetcode.com/problems/reverse-string-ii/

Given a string s and an integer k,
reverse the first k characters for every 2k characters counting from the start of the string.  
If there are fewer than k characters left, reverse all of them.  
If there are less than 2k but greater 
than or equal to k characters, then reverse the first k characters and leave the other as original.


Example 1:
```
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
```
Example 2:
```
Input: s = "abcd", k = 2
Output: "bacd"
``` 

Constraints:
```
1 <= s.length <= 104
s consists of only lowercase English letters.
1 <= k <= 104
```

```java
class Solution {
    
    String reverse(int start, int end, String s)
    {
        char ch[] = s.toCharArray();
        for(int i=0; i<=(end-start)/2; i++ )
            {
                char c = ch[start+i];
                ch[start+i] = ch[end -i];
                ch[end - i] = c;
                
            }
        return new String(ch);
    }
    
    public String reverseStr(String s, int k) {
        
        int n = s.length();
        int start =0, end = Math.min(k-1, n-1);
        
        while(start < n)
        {
            s = reverse(start, end, s);
            start = start+k+k;
            end = Math.min(start + k-1, n-1);

        }        
        return s;
    }
}
```