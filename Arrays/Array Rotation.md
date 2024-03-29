## Array Rotation
#### Source :: https://leetcode.com/problems/rotate-array/

Given an array, rotate the array to right by k steps, where k is non-negative.

```
Input:  [1,2,3,4,5,6,7]  k=3
Output: [5,6,7,1,2,3,4]
```
Explanation:
```
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
```

#### Approach 1: Rotate the Array k times  Time :: O(k*n)


#### Approach 2: Time:: O(n) Space :: O(1)

    - array :: {     1, 2, 3, 4,      5, 6, 7} k=3

    Divide the array in 2 parts a[0.. n-k-1] and a[n-k.. n-1] and reverse the 2 parts   
    - array :: { Rev(1, 2, 3, 4), Rev(5, 6, 7)} k=3 => - { 4, 3, 2, 1, 7, 6, 5} k=3

    Reverse the whole array
    - array ::   Rev{ 4, 3, 2, 1, 7, 6, 5} k=3      =>   { 5, 6, 7, 1, 2, 3, 4} k=3


```java
class Solution {    
    void reverse(int[] nums, int start, int end)
    {
        for(int i=0; i<=(end-start)/2; i++)
        {
            int c = nums[start+i];
            nums[start+i] = nums[end-i];
            nums[end-i] = c;
        }
    }
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;
         k = k%n;
        if(n<=1 || k<=0)
            return;
        reverse(nums, 0, n-k-1);
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-1);
    }
}
```
  