## Longest substring with all unique characters

#### Source :: https://leetcode.com/problems/longest-substring-without-repeating-characters/

Given a string s, find the length of the longest substring without repeating characters.

Example 1:
```
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
```


Example 2:
```
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
```

Example 3:
```
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
```

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        // Map Character and the last Index At which the character occured
        char ch[] = s.toCharArray();
        int maxLength =0;
        int lastindex = 0;
        int i=0;
        for(; i<ch.length; i++)
        {
          if(hm.get(ch[i])==null|| hm.getOrDefault(ch[i], 0)<lastindex)
            hm.put(ch[i], i);
          else
            {
               maxLength = Math.max(maxLength, i-lastindex );

              int index = hm.getOrDefault(ch[i], 0);
              lastindex = index+1;
              hm.put(ch[i],  i);
            }
        }
        return maxLength = Math.max(maxLength, i-lastindex);
        
    }
}
```