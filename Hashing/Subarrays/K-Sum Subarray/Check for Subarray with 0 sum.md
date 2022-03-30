## Check if Subarray with 0 Sum exists or not

#### Source :: https://practice.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1/

Given an array of positive and negative numbers. 
Find if there is a subarray (of size at-least one) with 0 sum.

Example1
```
Input:
5
4 2 -3 1 6

Output: 
Yes

Explanation: 
2, -3, 1 is the subarray 
with sum 0.
```

Approach :: Hashing :: Time :: O(n)  Space :: O(n)

- HashSet stores the "sum till now"

```java
class Solution{
    //Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[],int n)
    {
        //Your code here
        HashSet<Integer> hs = new HashSet<Integer>();
        int sum = 0;
        hs.add(0);
        
        for(int i=0; i<n; i++)
        {
            sum += arr[i];
            if(hs.contains(sum))
                return true;
            hs.add(sum);
        }
        return false;
    }
}
```