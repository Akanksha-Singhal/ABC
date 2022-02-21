### Count all substrings that start with a vowel

#### Source :: https://www.interviewbit.com/problems/amazing-subarrays/

You are given a string S, and you have to find all the amazing substrings of S.
Amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).

Input

Only argument given is string S.
Output

Return a single integer X mod 10003, here X is number of Amazing Substrings in given string.

Input
    ABEC

Output
    6

Explanation
	Amazing substrings of given string are :
	1. A
	2. AB
	3. ABE
	4. ABEC
	5. E
	6. EC
	here number of substrings are 6 and 6 % 10003 = 6.


```java
public class Solution {
    public int solve(String str) {
        
        char ch[] = str.toCharArray();   
        int n = ch.length;
        int countSubstrings = 0;        
        
        for(int i=0; i<ch.length; i++)
        {
            if(ch[i]=='a'||ch[i]=='e'|| ch[i]=='i'||ch[i]=='o'||ch[i]=='u'||
               ch[i]=='A'||ch[i]=='E'|| ch[i]=='I'||ch[i]=='O'||ch[i]=='U')
                countSubstrings += n-i;            
        }
        return countSubstrings% 10003;
    }
}
```
