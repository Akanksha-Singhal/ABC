## Maximum Sum Circular Subarray

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
minSubarraySum ( atleast one element) = -1
total SubArraySum = -21
max subarray sum = -21 - (1-) = -20 (Incorrect !!!)

-----------------------------------------------
minSubarraySum ( considering null set) = -21
total SubArraySum = -21
max subarray sum = -21 - (-21) = 0 (correct !!!)
```