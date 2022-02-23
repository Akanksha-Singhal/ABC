## Sort a String 

#### Source :: https://practice.geeksforgeeks.org/problems/sort-a-string2943/1/


Given a string consisting of lowercase letters, arrange all its letters in ascending order. 

Example 1:
```
Input:
S = "edcab"
Output: "abcde"
Explanation: characters are in ascending order in "abcde".
```
Example 2:

```
Input:
S = "xzy"
Output: "xyz"
Explanation: characters are in ascending order in "xyz".
```

Expected Time Complexity: O(|S| * log |S|)
Expected Auxiliary Space: O(1)

```java
class Solution 
{ 
    String sort(String s) 
    {
        // code here
        char ch[] = new char[26];
        
        for(int i=0; i<s.length(); i++)
        {
            int c = s.charAt(i)-'a';
            ch[c]++;
        }
        
        String str="";
        for(int i=0; i<ch.length; i++)
        {
            for(int k=0; k<ch[i]; k++)
                str+=((char)('a'+i));
        }
        return str;
    }
} 
```