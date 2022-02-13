## Maximum of Absolute Value Expression

#### Source :: https://leetcode.com/problems/maximum-of-absolute-value-expression/

```
Given two arrays of integers with equal lengths, return the maximum value of:
|arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
where the maximum is taken over all 0 <= i, j < arr1.length.

Example 1:

Input: arr1 = [1,2,3,4], arr2 = [-1,4,5,6]
Output: 13
Example 2:

Input: arr1 = [1,-2,-5,0,10], arr2 = [0,-2,-1,-7,-4]
Output: 20

Constraints:
2 <= arr1.length == arr2.length <= 40000
-10^6 <= arr1[i], arr2[i] <= 10^6
```

Approach :: Time:: O(n) Space: O(1)

```java
class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        
        
     // |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
    /* 
     == (arr1[i] - arr1[j]) + (arr2[i] - arr2[j]) + (i - j) = (arr1[i] + arr2[i] + i) - (arr1[j] + arr2[j]) + j)
        
     == (arr1[i] - arr1[j]) - (arr2[i] - arr2[j]) + (i - j) = (arr1[i] - arr2[i] + i) - (arr1[j] - arr2[j]) + j)
        
     == (arr1[i] - arr1[j]) - (arr2[i] - arr2[j]) - (i - j) = (arr1[i] - arr2[i] - i) - (arr1[j] - arr2[j]) - j)
        
     == (arr1[i] - arr1[j]) + (arr2[i] - arr2[j]) - (i - j) = (arr1[i] + arr2[i] - i) - (arr1[j] + arr2[j]) - j) */
        
        
        int n = arr1.length;
        int maxVal1 = Integer.MIN_VALUE, maxVal2= Integer.MIN_VALUE, maxVal3= Integer.MIN_VALUE, maxVal4= Integer.MIN_VALUE;    
        int minVal1 = Integer.MAX_VALUE, minVal2= Integer.MAX_VALUE, minVal3= Integer.MAX_VALUE, minVal4= Integer.MAX_VALUE;
    
        
        for(int i=0; i<n; i++)
        {
            int val1 = (arr1[i] + arr2[i] + i); 
            int val2 = (arr1[i] - arr2[i] + i); 
            int val3 = (arr1[i] - arr2[i] - i); 
            int val4 = (arr1[i] + arr2[i] - i); 
            
            
            // Maximum
            maxVal1 = Math.max(maxVal1, val1);
            maxVal2 = Math.max(maxVal2, val2);
            maxVal3 = Math.max(maxVal3, val3);
            maxVal4 = Math.max(maxVal4, val4);
            
            
            // Minimum
            minVal1 = Math.min(minVal1, val1);
            minVal2 = Math.min(minVal2, val2);
            minVal3 = Math.min(minVal3, val3);
            minVal4 = Math.min(minVal4, val4);
            
        }
        
        int maxDiff1 = Math.max (maxVal1- minVal1,  maxVal2-minVal2);
        int maxDiff2 = Math.max (maxVal3- minVal3,  maxVal4-minVal4);
        int diff = Math.max ( maxDiff1, maxDiff2);
        return diff;
        
    }
}
```