## 3Sum

Source :: https://leetcode.com/problems/3sum/

Given an integer array nums, 
return all the triplets [nums[i], nums[j], nums[k]]   
such that i != j, i != k, and j != k,   
and nums[i] + nums[j] + nums[k] == 0.  
  
Notice that the solution set must not contain duplicate triplets  

Example 1:
```
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
```
Example 2:
```
Input: nums = []
Output: []
```
Example 3:
```
Input: nums = [0]
Output: []
```

Time :: O(n<sup>2</sup>) Space :: O(1)

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i=0; i<nums.length-2; i++)
        {
            int low = i+1;
            int high = nums.length-1;
            int sum = nums[i];
            int target = 0-sum;
            if(i==0|| nums[i]!=nums[i-1])
            {
                while(low < high)
                {
                    if(nums[low]+nums[high]==target)
                    {
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while(low < high && nums[low]==nums[low+1])
                            low++;
                        while(low < high && nums[high]==nums[high-1])
                            high--;
                        low++; high--;
                    }
                    else if(nums[low]+nums[high]<target)
                        low++;
                    else
                        high--;
                    
                }
                
            }
            
        }
        return res;
    }
}
```