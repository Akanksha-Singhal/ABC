## Diff K II 

## Source :: https://www.interviewbit.com/old/problems/diffk-ii/

Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

Example 1
```
Input :
A : [1 5 3]
k : 2

Output :
1

as 3 - 1 = 2


```


```java
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int diffPossible(final int[] a, int k) {
        
        HashSet<Integer> hm = new HashSet<Integer>();
        
        for(int i=0; i<a.length; i++)
        {
            if(hm.contains(a[i]+k) || hm.contains(a[i]-k) )
                return 1;
            hm.add(a[i]);
        }
        return 0;
    }
}

```