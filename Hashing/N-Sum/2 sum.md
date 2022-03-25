## Find Pair with a given sum

#### Source :: https://leetcode.com/problems/two-sum

Given an array of integers nums and an integer target, 
return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, 
and you may not use the same element twice.

You can return the answer in any order.

 
```
Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
```
```
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
```
```
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
```

#### Approach :: 2 Pointer solution using Sorting:: Time :: O(nlogn)  Space :: O(1)

```java

void findPair(int a[], int sum)
{
	Arrays.sort(a);
	int low =0, high = a.length-1;
	while(low < high)
	{
		if(a[low]+a[high]==sum)
		{
			System.out.println("Pair found");
			return;
		}
		else if(a[low]+a[high]<sum)
			low++;
		else
			high--;
	}
	System.out.println("Pair not found");
}

```


#### Approach :: Solution using Hashing  Time :: O(n) Space :: O(n)

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        
        for(int i=0; i<nums.length; i++)
        {
            if(hm.get(target - nums[i])!=null)
            {               
                      res[0] = hm.get(target-nums[i]);
                      res[1] = i;
                return res;
            }
            hm.put(nums[i], i);
        }
        return res;
    }
}
```