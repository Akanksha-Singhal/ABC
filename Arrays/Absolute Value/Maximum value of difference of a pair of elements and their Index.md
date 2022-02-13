# Maximum value of difference of a pair of elements and their Index 

## Source :: https://practice.geeksforgeeks.org/problems/maximum-value-of-difference-of-a-pair-of-elements-and-their-index/1

```
Given an array arr[] of N positive integers. Find maximum value of |arr[i] – arr[j]| + |i – j|, (0 <= i, j <= N – 1)

Example 1:

Input:
N = 4 
arr[] = {1, 2, 3, 1}
Output:
4
Explanation:
Choosing i=0 and j=2, will result in
|1-3|+|0-2| = 4, which is the maximum
possible value.
```

```java
class Solution {
    static int maxValue(int[] arr, int N) {
        // code here
    // |arr[i] – arr[j]| + |i – j|   
    // =  (arr[i] – arr[j]) + (i – j) =  (arr[i]+i) - (arr[j] + j)
    // = -(arr[i] – arr[j]) - (i – j) = -(arr[i]+i) + (arr[j] + j)
    // = -(arr[i] – arr[j]) + (i – j) = -(arr[i]-i) + (arr[j] - j)
    // =  (arr[i] – arr[j]) - (i – j) =  (arr[i]-i) - (arr[j] - j)
    
         int maxadd = Integer.MIN_VALUE;
         int maxsub = Integer.MIN_VALUE;
         int minadd = Integer.MAX_VALUE;
         int minsub = Integer.MAX_VALUE;
         
        for(int i=0; i<N; i++)
        {
            maxadd = Math.max(maxadd,  arr[i]+i);
            maxsub = Math.max(maxsub, arr[i]-i);
            
            minadd = Math.min(minadd, arr[i]+i);
            minsub = Math.min(minsub, arr[i]-i);
        }
        return Math.max(maxadd - minadd, maxsub - minsub);
    }
};
```
