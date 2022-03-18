## Insertion Sort 

| Sorted Array | | unsorted array|

- Initially the sorted array contains only 1 element
- then in each iteration
Insertion sort removes the first element from the unsorted array
and finds the location within thee sorted subset

i=0 [3] [8 5 4]  
i=1 [3 8] [5 4]  
i=2 [3 5 8] [4]
i=3 [3 4 5 8]

Time :: Best Case :: O(n) [ already sorted array ]  
Time :: Worst Case :: O(n) [ reverse sorted array ]  


```java
void insertionSort(int a[], int n)
{
	for(int i=1; i<n; i++)
	{
		int value = a[i];
		int j=i; // index where the unsorted array starts
		while(j > 0 && a[j-1] > value)
		{
			a[j] = a[j-1];
			j--;
		}
		a[j] = value;

	}
}
```
