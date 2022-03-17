## Move Zeroes Towards the End of Array

Source :: https://leetcode.com/problems/move-zeroes/

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

 

Example 1:
```
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
```

Example 2:
```
Input: nums = [0]
Output: [0]
```


#### Approach 2 :: Time :: O(N) Single Pass Space :: O(1)

Follow up: Could you minimize the total number of operations done?


```java
   public void moveZeroes(int[] nums) {
        int nonzero=0;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]!=0)
            {   nums[nonzero] = nums[i];
                nonzero++;
            }            
        }        
        for(int i=nonzero; i<nums.length; i++ )
        {
            nums[i] = 0;             
        }
    }
```