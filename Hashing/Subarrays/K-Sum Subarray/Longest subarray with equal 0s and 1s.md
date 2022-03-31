## Longest subarray with equal number of 0s and 1s

#### Source :: https://leetcode.com/problems/contiguous-array/

Given a binary array nums, return the maximum length 
of a contiguous subarray with an equal number of 0 and 1.

Example 1:
```
Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
```

Example 2:
```
Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
```

#### Approach :: Time :: O(n) Space :: O(n)
Replace all 0s with -1 and find the largest 0 sum subarray

```java
class Solution {
    public int findMaxLength(int[] nums) {
        
        int n = nums.length;
        int sum =0, maxLength=0;
        
        // HashMap ( sumTillNow --> first Endpoint where we got the sumTillNow)
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(0, -1);
        for(int i=0; i<n; i++)
        {
            if(nums[i]==0)
                sum+=-1;
            else          
                sum+=nums[i];
            
            if(hm.get(sum)!=null)
            {
                int start = hm.get(sum);
                int end = i;
                maxLength = Math.max(end-start, maxLength);
            }
            
            if(hm.get(sum)==null)
                hm.put(sum, i);                
        }
        return maxLength;
        
    }
}
```