## Colorful Number

For Given Number N find if its COLORFUL number or not

Return 0/1

COLORFUL number:

A number can be broken into different contiguous sub-subsequence parts. 
Suppose, 
a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
Example:
```
N = 23
2 3 23
2 -> 2
3 -> 3
23 -> 6
this number is a COLORFUL number since product of every digit of a sub-sequence are different. 

Output : 1
```

###Approach :: Time O(n<sup>3</sup>)  Space :: O(n)

```java
public class Solution {
    
    public int mul(String num)
    {
        char ch[] = num.toCharArray();
        int prod = 1;
        for(int i=0; i<ch.length; i++)
        {
            prod *= Integer.valueOf(ch[i]-48);
        }
        return prod;
        
    }
    public int colorful(int A) {
        String num = String.valueOf(A);
       
        HashSet<Integer> hs = new HashSet<Integer>();  
        for (int i = 0; i < num.length(); i++)  
           for (int j = i+1; j <= num.length(); j++) 
             {
                 int n = Integer.valueOf(mul(num.substring(i, j)));
                 if(hs.contains(n))
                    return 0;
                else
                    hs.add(n);
                    
             }
         return 1;
    }
}


```