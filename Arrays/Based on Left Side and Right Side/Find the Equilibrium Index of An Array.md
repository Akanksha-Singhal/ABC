## Find Equilibrium Index of an array
#### Source :: https://leetcode.com/problems/find-pivot-index/

For an array consisting of n elements, index i is equilibrium index  
if sum of elements of subarray A[0...i-1] = sum of elements of subarray A[i+1...n-1] 

E.g. 
```
arr = [0, -3, 5, -4, -2, 3, 1, 0]
The  Equilibrium Index is found at index 0, 3 and 7
```

#### Approach 1: Brute Force: O(n2)

#### Approach 2: Linear  Time:: O(n) Space:: O(n) 
- calculate sum of elements to the left of each element lsum = new int[n];
- calculate sum of elements to the right of each element rsum = new int[n];
- if( lsum[i] == rsum[i])
    return i;

#### Approach 3: Optimized Solution Time:: O(n) Space:: O(1)
Sum of right Subarray A[i+1.. n] = total Sum - a[i] -Sum of left Subarray A[0.. i-1] 

```java
class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum =0;
        int n = nums.length;
        
        for(int i=0; i<n; i++)
            totalSum += nums[i];
        
        int leftSum =0;
        for(int i=0; i<n; i++)
        {
            int rightSum = totalSum-nums[i]- leftSum;
            if(leftSum== rightSum)
                    return i;
            leftSum += nums[i];
            
        }
        return -1;
    }
}
```