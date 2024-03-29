## Sort Colors
## Sort an array of 0's 1's 2's
##### Source :: https://leetcode.com/problems/sort-colors/

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects 
of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

Example 1:
```
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
```
Example 2:
```
Input: nums = [2,0,1]
Output: [0,1,2]
```

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.

##### Approach :: Optimal (uses Dutch National Flag Algorithm)
Time :: O(N)  Space :: O(1)
One pass Algorithm

```java
class Solution {
    
    public void swap(int nums[], int a, int b)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    public void sortColors(int[] nums) {
        
        int pivotStart = 0, pivotEnd = nums.length-1;
        int pivot =1;
        
        for(int curr=0; curr<=pivotEnd; )
        {
            if(nums[curr] <  pivot)
            {
                swap(nums, curr, pivotStart); curr++; pivotStart++;
            }
            else if(nums[curr] == pivot)
            {
                curr++;
            }
            else
            {
                swap(nums, curr, pivotEnd); pivotEnd--;
            }
        }
        
    }
}
```