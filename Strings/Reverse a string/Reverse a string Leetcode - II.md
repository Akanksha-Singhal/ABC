## Reverse String II

Given a string s and an integer k, reverse the first k characters for every 2k characters 
counting from the start of the string. 
If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater 
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
    public String reverseStr(String s, int k) {
        
         char ch[] = s.toCharArray();
         int start =0, end = Math.min(k-1, s.length()-1);
        
        while(start < ch.length)
        {
            for(int i=0; i<=(end-start)/2; i++ )
            {
                char c = ch[start+i];
                ch[start+i] = ch[end -i];
                ch[end - i] = c;
                
            }
            start = start+k+k;
            end = Math.min(start + k-1, s.length()-1);

        }        
        return new String(ch);
    }
}
```