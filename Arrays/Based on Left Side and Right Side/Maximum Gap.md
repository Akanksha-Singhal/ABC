### Maximum Index
#### Source :: https://practice.geeksforgeeks.org/problems/maximum-index3307/1/

Given an array Arr[] of N positive integers. 
The task is to find the maximum of j - i subjected to the constraint of Arr[i] <= Arr[j].

Example 1:
```
Input:
N = 9
Arr[] = {34, 8, 10, 3, 2, 80, 30, 33, 1}
Output: 6
Explanation: In the given array Arr[1] <Arr[7]  satisfying the required condition
(Arr[i] <= Arr[j])  thus giving the maximum difference of j - i which is
6(7-1)
```

#### Approach -   Time :: O(n) Space :: O(n)

For each element in the array find it's maximum element to it's right - O(n) Space and Time
Maintain 2 pointers for comparing 2 values 
	- start with first and second element
		- Check if we can find a second element equal to higher than itself to right of first element
			- if second element > first element
				- mark the gap (j-i)
				- and keep looking if you can find higher or equal element ahead of second element
		          i.e. j++
		- else if no element is higher than first element , increment i


```java
class Solution {

    int maxIndexDiff(int a[], int n) {
        // code here
        
        int rmax[]= new int[n];
        int max=0;
        for(int j=n-1; j>=0; j--)
        {

            rmax[j] = max;
            if(max < a[j])
                max = a[j];
        }
        
        int maxGap = 0;
        for(int i=0, j=1; i<n && j<n;)
        {
            if((a[i]<= rmax[j]) ||(a[i] <= a[j]))
            {
                if(a[i] <= a[j])
                    maxGap = Math.max(maxGap, j-i);
                j++;
            }
            else
                i++;
        }
        return maxGap;
    }
}
```