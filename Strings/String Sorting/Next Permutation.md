## Next Permutation

Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.

Example 1:
```
Input: nums = [1,2,3]
Output: [1,3,2]
```
Example 2:
```
Input: nums = [3,2,1]
Output: [1,2,3]
```
Example 3:
```
Input: nums = [1,1,5]
Output: [1,5,1]
```

#### Approach 1 :: Brute Force
Time :: O(N!*N)
	- Generate all possible n! combinations 
	- linearly iterate and check which combination at which index is the given combination 
	- return the combination at (index+1)%n
	

