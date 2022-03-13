## Merge two Sorted Arrays Without Extra Space

Problem statement: Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. 
Merge them in sorted order. 
Modify arr1 so that it contains the first N elements and 
modify arr2 so that it contains the last M elements.

Source :: https://leetcode.com/problems/merge-sorted-array/

Input: 
```
ar1[] = {10};
ar2[] = {2, 3};
```
Output: 
```
ar1[] = {2}
ar2[] = {3, 10}  
```

Input: 
```
ar1[] = {1, 5, 9, 10, 15, 20};
       ar2[] = {2, 3, 8, 13};
```
Output: 
```
ar1[] = {1, 2, 3, 5, 8, 9}
ar2[] = {10, 13, 15, 20}
```

```java
class Solution
{
    public static void swap(long a1[], int i, long a2[], int j)
    {
        long temp = a1[i];
        a1[i] = a2[j];
        a2[j] = temp;
    }
    //Function to merge the arrays.
    public static void merge(long a1[], long a2[], int n, int m) 
    {
        // code here 
        int i=0, j=0;
        for(i=0; i<n; i++)
        {
            if(a1[i]>=a2[j]) 
            {
                swap(a1, i, a2, j);
                
                
                //insert the newly swapped element into the correct position of array 2
                long temp = a2[j];
                while(j<m-1 && temp>a2[j+1])
                {
                    a2[j] = a2[j+1];
                    j++;
                }
                a2[j] = temp;
                j=0;
            }
        }
    }
}


```