## Count Pairs With Given Xor

#### Source :: https://www.interviewbit.com/old/problems/pairs-with-given-xor/

Given an 1D integer array A containing N distinct integers.
Find the number of unique pairs of integers in the array whose XOR is equal to B.

NOTE:
Pair (a, b) and (b, a) is considered to be same and should be counted once.

Example 1
```
Input 1:
 A = [5, 4, 10, 15, 7, 6]
 B = 5

Output 1: 1
Explanation 1: (10 ^ 15) = 5
```

Example 2
```
Input 2:
 A = [3, 6, 8, 10, 15, 50]
 B = 5

Output 2: 2
Explanation 2:  (3 ^ 6) = 5 and (10 ^ 15) = 5 

```

#### Approach :: Hashing :: Time :: O(n) Space :: O(n)

```java
public class Solution {
    public int solve(int[] a, int k) {
        
        int n = a.length;
        HashSet<Integer> hs = new HashSet<Integer>();
        
        int count =0;
        for(int i=0; i<n; i++)
        {   if(hs.contains(a[i]^k))
                count++; // Pair(a[i]^k, a[i])
            hs.add(a[i]);
        }
        return count;
    }
}
```