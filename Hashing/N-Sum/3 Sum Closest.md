## 3Sum Closest

#### Source :: https://leetcode.com/problems/3sum-closest/

Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
Return the sum of the three integers.
You may assume that each input would have exactly one solution.


Example 1:
```
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
```
Example 2:
```
Input: nums = [0,0,0], target = 1
Output: 0
```

#### Approach :: Time :: O(n<sup>2</sup>) Space :: O(1)

```java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        int minDiff_sum = 0;
        
        Arrays.sort(nums);
        
        for(int i=0; i<n-2; i++)
        {
            if(i==0 || nums[i]!=nums[i-1])
            {
                int n1 = nums[i];
                int low = i+1;
                int high = n-1;
                
                int sum = target-n1;
                while(low < high)
                {
                    int diff = Math.abs(n1+nums[low]+nums[high]-target);
                    if(diff < minDiff)
                    {
                        minDiff = diff;
                        minDiff_sum = n1+nums[low]+nums[high];
                    }
                    
                    if(nums[low]+nums[high]==sum)
                    {
                        return n1+nums[low]+nums[high];
                    }
                    else if(nums[low]+nums[high]<sum)
                        low++;
                    else
                        high--;
                        
                }
            }
           
        }
        
        return minDiff_sum;
        
    }
}

```