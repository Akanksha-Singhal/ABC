## Maximum difference between two elements such that larger element appears after the smaller number
#### Source :: https://leetcode.com/problems/maximum-difference-between-increasing-elements/

```
Given an array arr[] of integers, find out the maximum difference between any two elements 
such that larger element appears after the smaller number. 

Examples : 

Input : arr = {2, 3, 10, 6, 4, 8, 1}
Output : 8
Explanation : The maximum difference is between 10 and 2.

Input : arr = {7, 9, 5, 6, 3, 2}
Output : 2
Explanation : The maximum difference is between 9 and 7.
```

#### Primary Application :: Maximum profit by buying and selling of share atmost once.


##### Approach 1  :: maintain lmin   Time :: O(n) Space :: O(1)

```java
class Solution {
    public int maximumDifference(int[] nums)
    {
        int diff = -1;
        int min =nums[0];
        for(int i= 1; i<=nums.length-1; i++)
        {
            if(nums[i] > min)
                diff = Math.max(nums[i]-min, diff);
            
            min = Math.min(min, nums[i]);
        }
        return diff;
    }
}
```



##### Approach 2  :: maintain rmax

a[i] =   <&nbsp><&nbsp><&nbsp><&nbsp>         {2, 7, 9, 5, 1, 3, 5}  
rmax[i]=          {9, 9, 9, 5, 5, 5, 5}  
rmax[i] - a[i] =  {7, 2, 0, 0, 4, 2, 0}  

```java
int findMaxDiff(int a[], int n)
    {
	// Your code here	
	int maxDiff = -1;
     
        // Initialize max element from right side
        int rmax = a[n-1];
     
        for (int i = n-2; i >= 0; i--)
        {
            if (a[i] > rmax)
                rmax = a[i];
            else
            {
                int diff = rmax - a[i];
                if (diff > maxDiff)
                {
                    maxDiff = diff;
                }
            }
        }
        return maxDiff;
	    
    }
```
