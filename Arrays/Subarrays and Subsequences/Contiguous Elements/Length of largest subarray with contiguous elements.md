### Length of the largest subarray with contiguous elements


1. You are given an array(arr) of integers. Values are distinct.
2. You have to find the length of the largest subarray with contiguous elements.

Note -> The contiguous elements can be in any order(not necessarily in increasing order).

Example::
```
[10, 12, 11] -> length of the longest contiguous subarray = 3
[14, 12, 11, 20] -> length of the longest contiguous subarray = 2
[1, 56, 58, 90, 92, 94, 93, 91, 45]-> length of the longest contiguous subarray = 5
```

### Approach
- all elements are distinct  
- if all the elements are distinct, then a subarray has the contiguous elements if and only if the
- difference between maximum and minimum elements in subarray = (last_index-first_index)
- So the idea is to keep track of minimum in every subarray


```java

int findLength(int a[], int n)
{
	int maxlen = 1;
	for(int i=0; i<n; i++)
	{
		//Initialize min and max for all the subarrays starting with i
		int mn = a[i], mx = a[i];
		for(int j=i+1; j<n; j++)
		{
			//update min and max in this subarray if needed
			mn = Math.min(mn, a[i]);
			mx = Math.max(mx, a[i]);

			//Check if the current subarray has all contiguous elements
			if((mx-mn)==(j-i))
				maxlen = Math.max(maxlen, mx-mn+1);
		}
		return maxlen;
	}
}

```