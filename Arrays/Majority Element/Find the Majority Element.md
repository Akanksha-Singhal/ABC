## Majority Element (>N/2)
#### Source :: https://leetcode.com/problems/majority-element/

Given an array nums of size n, return the majority element.
The majority element is the element that appears more than [n / 2] times. You may assume that the majority element always exists in the array.

Example 1:
```
Input: nums = [3,2,3]
Output: 3
```
Example 2:
```
Input: nums = [2,2,1,1,1,2,2]
Output: 2
```


#### Approach 1 :: Brute Force Solution :: Time :: O(n2)
```
- Find the frequency of the each element in the first half 
-   for(int i=0; i<n/2; i++)
    {
        for(int j=i+1; j<n; j++) //// some code
    }
```

#### Approach 2 :: Hashing :: Time O(n) Space O(n)
 - to store each element's frequency


#### Approach 3 :: Boyer-Moore's Majority Vote Algorithm :: Time O(n) Space O(1)

This solution is called Boyer-Moore's Majority Vote Algorithm
Approach or Idea::
```
If an element appears more than n/2 times then it will occur
    - atleast once consecutively (*_**_) [i.e. counting consecutive occurences >= 1]
    - OR alternately (*_*_*) [i.e. last occurenece will always be of the Majority element]
```

```java
 public int majorityElement(int[] nums) {
        
        int major =0, vote =1;
        for(int i=1; i<nums.length; i++)
        {
            if(nums[major]==nums[i])
                {  vote++;}
            else
                { vote--;}
            if(vote==0)
            {  vote =1;
                major = i;
            }                
        }
        

        // Verify once again if we have chosen the right element as the Majority element
        vote =0;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]==nums[major])
                vote++;
        }   
        if(vote>=nums.length/2)
            return nums[major];
        else
            return -1;
        
        
    }
```