## Maximum Subarray


Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

Example 1:
```
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
```
Example 2:
```
Input: nums = [1]
Output: 1
```
Example 3:
```
Input: nums = [5,4,-1,7,8]
Output: 23
```

Approach Optimal :: Time :: O(N) Space :: O(1)

```java
class Solution {
    public int maxSubArray(int[] nums) {
     int prevMax = Integer.MIN_VALUE, max = nums[0];   
        for(int i=1; i<nums.length; i++)
        {
            if(prevMax < max)
                prevMax = max;           
            
            if(max + nums[i] < nums[i])
                max = nums[i];
            else
                max = max + nums[i];
        }
        return Math.max(max, prevMax);
    }
} 
```