## Longest subarray with 0s and more 1s

#### Source :: https://www.interviewbit.com/old/problems/longest-subarray-length/

Given an integer array A of size N containing 0's and 1's only.
You need to find the length of the longest subarray 
having count of 1’s one more than count of 0’s.

### Example 1
```
Input 1:  A = [0, 1, 1, 0, 0, 1]
Output 1: 5
```

### Example 2
```
Input 2: 
A = [1, 0, 0, 1, 0]
Output 2: 1
```

```java
public class Solution {
    public int solve(int[] a) {
        int sum = 0;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(0, -1);
        int maxLen = 0;
        for(int i=0; i<a.length; i++)
        {
            int val = a[i];
            if(val == 0)
                val = -1;
            sum +=val;
            
            if(hm.get(sum-1)!=null) // gives the longest subarray with sum=1
            {
                int start = hm.get(sum-1);
                int end = i;
                maxLen = Math.max(end-start, maxLen);
            }
            
            if(hm.get(sum)==null)
                hm.put(sum, i);
        }
        return maxLen;
    }
}
```