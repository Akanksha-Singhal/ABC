## Remove All Adjacent Duplicates In String 

#### Source:: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

You are given a string s consisting of lowercase English letters.
A duplicate removal consists of choosing two adjacent and equal letters and removing them.
We repeatedly make duplicate removals on s until we no longer can.
Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

 

Example 1:

Input: s = "abbaca"  
Output: "ca"

Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  T
he result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".

Example 2:

Input: s = "azxxzy"  
Output: "a


```java
class Solution {
    public String removeDuplicates(String str) {
        
       if(str.length()<=1)
            return str;
        char ch[] = str.toCharArray();
        Stack<Character> s = new Stack<Character>();
        int count =0; boolean dupAvailable = false;
        
        for(int i=0; i<ch.length; i++)
        {
            if(!s.empty() && s.peek()==ch[i])
                count++;
            else
                count = 1;
            
            s.push(ch[i]);
            
            if(count>1)
            {
                dupAvailable = true;
                while(count > 0)
                {
                    s.pop();
                    count--;
                }
                count =1;
            }
        }

        String res ="";
        while(!s.empty())
        {
            // prepend
            res=s.pop()+res;
        }
        if(dupAvailable)
            return removeDuplicates(res);
        return res;
        
    }
}
```