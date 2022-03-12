## Merge Sort

#### Source :: https://practice.geeksforgeeks.org/problems/merge-sort/1

Time :: O(NlogN)    Space :: O(N)

```java
 static void mergeSort(int arr[], int l, int r)
    {
        if (l < r)
        {
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr , m+1, r);
            merge(arr, l, m, r);
        }
    }

  // Merges two subarrays of arr[].  First subarray is arr[l..m]
   // Second subarray is arr[m+1..r]
    void merge(int arr[], int beg, int mid, int end)
    {
         // Your code here
         int n1 = mid-beg+1, n2 = end-mid;
         int l[] = new int[n1+1];   l[n1] = Integer.MAX_VALUE;
         int r[] = new int[n2+1];   r[n2] = Integer.MAX_VALUE;
         int i=0, j=0;
         
         for(i=0; i<n1; i++)
         {
             l[i] = arr[beg+i];
         }
         for(j=0; j<n2; j++)
         {
             r[j] = arr[mid+1+j];
         }
     
         int k=beg; i=0; j=0;
         for( ; k<=end; k++)
         {
             if(l[i]<=r[j])
             {
                 arr[k] = l[i]; i++;
             }
             else
             {
                 arr[k] = r[j]; j++;
             }
         }
         
     }
```