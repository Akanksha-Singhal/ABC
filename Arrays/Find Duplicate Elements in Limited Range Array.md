## Find Duplicate Elements in a Limited Range Array

#### Source :: https://leetcode.com/problems/find-the-duplicate-number/
Problem : Given a limited range array of size n containing elements between 1 and n-1 with one element repeating, find the duplicate number in it without using any extra space.

For example,
```
Input:  { 1, 2, 3, 4, 4 }
Output: The duplicate element is 4
``` 
```
Input:  { 1, 2, 3, 4, 2 }
Output: The duplicate element is 2
```
#### Approach 1 : Hashing :: Time O(n), Space O(n)

#### Approach 2 : Check for duplicates by marking the array elements as 
-ve by using array index as key

	- Array contains all distinct elements but one
	- This approach modifies the Array elements
	- if a[i] is found => mark the value of a[a[i]-1] as -ve 
	                       i.e. a[a[i]-1] => -a[a[i]-1]
	- if a[i] is found again
			-if (a[a[i]-1] is -ve) => the value is repeated

```java
	int findDuplicates(int a[])
	{
		for(int i=0; i<a.length; i++)
		{
		   int val = Math.abs(a[i]);
		   if(a[val-1] > 0)
		      a[val-1] = -1*a[val-1];
		    else
				return val;
		}
		return -1;
	}
```
** Note : The above mentioned Approach works when the array has non-zero non-negative elements.

Approach 3: XOR   Time :: O(n) Space : O(n)
Take the XOR of all array elements from 1 to n-1. Since the same elements will cancel out
each other. We will be left with the Duplicate Element

```java
int findDuplicate(int a[], int n)
{
	int xor =0;
	// take xor of all array elements
	for(int i=0; i<n; i++)
		xor^=a[i];

	// take xor of nos. from 1 to n-1
	for(int i=1; i<n; i++)
		{ xor^=i; }
	return xor;
}
```
Approach 4: Time :: O(n) Space O(1)
Find    the sum of all the array elements - n*(n-1)/2
```
int findDuplicate(int a[])
{
	int sum =0;
	for(int i=0; i<a.length; i++)
		{ sum += a[i];}

	int n = a.length; 
	int expectedSum = n*(n-1)/2;
	return n - expectedSum;
}
```


