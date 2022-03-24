## Maximum Sum Circular Subarray

#### Source :: https://leetcode.com/problems/maximum-sum-circular-subarray/

Given a circular array of integers, find the subarray which has the largest sum

```
Input:
[2, 1, -5, 4, -3, 1, -3, 4, -1]

Output:
[4, -1, 2, 1] is the subarray with the largest sum=6
```

There are many approaches for solving this problemm. Given is an O(N) approach using Kadane's algorithm

minSubarray sum = [-3, -2] = -5
Total array sum = 9
max subarray sum = total array sum - minSubarray sum = 9 - (-5) = 14


### Case 1 :: All positive Elements 
Consider the array [5 3 2 6 1 4]
```
minSubarraySum ( atleast one element) = 1
total SubArraySum = 21
max subarray sum = 21 - 1 = 20 (Incorrect !!!)

-----------------------------------------------
minSubarraySum ( considering null set) = 0
total SubArraySum = 21
max subarray sum = 21 - 0 = 21 (correct !!!)
```

### Case 2 :: All negative Elements 
Consider the array [-5 -3 -2 -6 -1 -4]
```
maxSubArraySum = -1
minSubarraySum ( atleast one element) = -21
total SubArraySum = -21
max subarray sum = -21 - (-21) = 0 (correct !!!)

-----------------------------------------------
minSubarraySum ( considering null set) = -21
total SubArraySum = -21
max subarray sum = -21 - (-21) = 0 (correct !!!) [Here note that max Sub Array Sum = 0 using Kadane's]
```

### Case 3 :: Some positive, some negative elements
Consider the array [5 -3 -2 6 -1 4]
```
Kadane's maximum subarray sum =  [6 -1 4] = 9 = ans1

Invert - [-5 3 2 -6 1 -4] max subarray sum = 5 
Therefore for original array ( non-inverted array) min Subarray sum = -5
total sum = 9
circular subarray sum = total sum - (min Subarray sum) = 9 - (-5) = 14 = ans2
i.e. array [6 -1 4 5]

ans - Max(ans1, ans2) = Max(9, 14) = 14
```
### Approach :: Time :: O(n) Space :: O(1)


#### To get the max subarray sum considering a Circular array
	- Get the total sum = total sum  
	- To get the minimum subarray sum   
		- apply Kadane on inverted array = ans  
		- negate the ans i.e ans = -ans  

	- Max Circular Array Sum = totalSum - minimum subarray sum   
							 = totalSum - (-ans)  
							 = totalSum +ans = ans1  

#### To get the max subarray sum considering a Normal array 
	- apply Kadane on normal array = ans2  

#### If null set is not considered   
	- if ans2 != 0
		return Max(ans1, ans2)
	- else
		return ans1


```java
class Solution {
    
    public static void invertArray(int nums[])
    {
        for(int i=0; i<nums.length; i++)
            nums[i] = - nums[i];
    }
    
    public int totalSum(int nums[])
    {
        int sum =0;
        for(int i=0; i<nums.length;i++)
            sum +=nums[i];
        return sum;
    }
    
    public static int kadane(int nums[])
    {
        int max = nums[0], prevMax = Integer.MIN_VALUE;
        for(int i=1; i<nums.length; i++)
        {
            if(prevMax<max)
                prevMax = max;
            if(max + nums[i] < nums[i])
                max = nums[i];
            else
                max = max + nums[i];
        }
        return Math.max(prevMax, max);
    }
    public int maxSubarraySumCircular(int[] nums) {
        
        //applying kadane considering a normal array ( not a circular array)
        int ans = kadane(nums);
        
        //applying kadane considering a circular array
        // minSubArraySum = -kadane(inverted array)
        // maxSubArraySum = totalSum - minSubArraySum
        int totalSum = totalSum(nums);
        invertArray(nums);
        int minSubArraySum = -1*kadane(nums);
        int maxSubArraySum = totalSum - minSubArraySum;

        if(maxSubArraySum!=0)
            return Math.max(ans, maxSubArraySum);
        else
            return ans;
        

    }
}

```




