## Count Subarrays with Sum equal to K

#### Source :: https://leetcode.com/problems/subarray-sum-equals-k/

Given an array of integers nums and an integer k, 
return the total number of subarrays whose sum equals to k.

 

Example 1:
```
Input: nums = [1,1,1], k = 2
Output: 2
```
Example 2:
```
Input: nums = [1,2,3], k = 3
Output: 2
```

### Approach :: Time :: O(n) Space :: O(n)

- create a Hashmap of sumTillNow and count of Endpoints of subarrays having that sumTillNow
- Initially we have only 1 endpoint i.e. -1 for sum = 0
- Iterate through the array and update the count of Endpoints having that sumTillNow


```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int n = nums.length;
        // HashMap(sumTillNow --> Endpoints of subarrays having that sumTillNow)
        HashMap<Integer, Integer> hm= new HashMap<Integer, Integer>();
        hm.put(0, 1); // null set
        
        int count =0, sum=0;
        for(int i=0; i<n; i++)
        {
            sum += nums[i];
            if(hm.get(sum-k)!=null)
                count+=hm.get(sum-k);
            
            hm.put(sum, hm.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}
```