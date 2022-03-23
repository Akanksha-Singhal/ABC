## Maximum Subarray or Kadane's Algorithm

#### Source :: https://leetcode.com/problems/maximum-subarray/

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

Solution 1: Naive Approach 

Approach: Time :: O(N<sup>3</sup>)  Space :: O(1)
Using three for loops, we will get all possible subarrays in two loops and their sum in another loop, and then return the maximum of them.


Approach 2 :: Time :: O(n2) Space :: O(1)


check [0, n-1], considering 0 to be a starting point, find the ending point for maxSum
then [1, n-1], ..
```java
int maxSubArray(int[] nums) {
  int max_sum = Integer,MIN_VALUE;
  for (int i = 0; i < nums.length; i++) {
    int curr_sum = 0;
    for (int j = i; j < nums.length; j++) {
      curr_sum += nums[j];
      if (curr_sum > max_sum) {
      // subarray (i, j) is the max subArray
        max_sum = curr_sum;
      }
    }
  }
  return max_sum;
}
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