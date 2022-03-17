## (Subarray / Substring) v/s Subsequence

A subarray is a contiguous part of an array

E.g. For array [1, 2, 3, 4]
there are 10 non empty subarrays
```
[1] [1,2] [1,2,3] [1,2,3,4]  
[2] [2,3] [2,3,4]  
[3] [3,4]  
[4]  
```

To generate all subarrays O(n<sup>3</sup>)
```java

void subarray(int a[])
{
	//Pick starting point
	for(int i=0; i<n; i++)
	{
		//Pick ending point
		for(int j=i; j<n; j++)
		{
			//Print subarray b/w starting and ending point
		}
	}
}
```

## Approach :: 