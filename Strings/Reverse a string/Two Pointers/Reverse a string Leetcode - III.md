Reverse Words in a String III

Given a string s, reverse the order of characters in each word within a sentence while still 
preserving whitespace and initial word order.


Example 1:
```
Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
```
Example 2:
```
Input: s = "God Ding"
Output: "doG gniD"
```

```java
class Solution {
    
    public void reverse(char ch[], int start, int end)
    {
        for(int i=0; i<=(end-start)/2; i++)
        {
            char c = ch[start+i];
            ch[start+i] = ch[end-i];
            ch[end-i] = c;
        }
        
    }
    
    public String reverseWords(String s) {
        
        int n = s.length();
        int start = 0;
        int end =0;
        
        char ch[] = s.toCharArray();
        
        while (end < n)
        {
            start = end;
            while(start<n && end<n && ch[start]==' ')
                start++;
            end = start;
            while(end < n && ch[end]!=' ')
                end++;
            
            reverse(ch, start, end-1);                      
        }
        
        return new String(ch);
    }
}
```