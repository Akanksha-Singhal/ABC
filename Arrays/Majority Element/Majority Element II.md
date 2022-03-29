## Majority Element II ( > N/3 times)

#### Source :: https://leetcode.com/problems/majority-element-ii/


Given an integer array of size n, 
find all elements that appear more than ⌊ n/3 ⌋ times.

Example 1:
```
Input: nums = [3,2,3]
Output: [3]
```
Example 2:
```
Input: nums = [1]
Output: [1]
```
Example 3:
```
Input: nums = [1,2]
Output: [1,2]
```

#### Approach (Naive) :: Time :: O(n<sup>2</sup>) Space :: O(1)
- Pick up each element one by one and check it's frequency in the entire array
- if it occurs > n/3 times then it is a majority element

#### Approach (Naive) :: Time :: O(n) Space :: O(n)
- use Hashmaps to store the frequency
- if it occurs > n/3 times then it is a majority element


##### Approach :: Time :: O(N) Space :: O(1)
- Boyer Moore's Voting Algorithm

```java
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int n = nums.length;
        int count1=0, count2=0, major1=-1, major2=-1;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]==major1)
            {
                count1++;
            }
            else if(nums[i]==major2)
            {
                count2++;
            }
            else if(count1==0)
            {
                major1 = nums[i];
                count1=1;
            }            
             else if(count2==0)
            {
                major2 = nums[i];
                count2=1;
            }
            else 
            {
                count1--; count2--;
            }
            
            

        }
        
        ArrayList<Integer> al = new ArrayList<Integer>();
        
        count1=0; count2=0;
        
        for(int i=0; i<n; i++)
        {
            if(nums[i]==major1) count1++;
            
            if(nums[i]==major2) count2++;
        }
        
        if(count1 > n/3)
            al.add(major1);
        if(major1!=major2 && (count2 > n/3))
            al.add(major2);
        return al;
    }
}
```