## Merge Two SORTED Arrays withouut Extra Space

#### Source :: https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1

We are given two sorted arrays.  
We need to merge these two arrays such that  
initial numbers after complete sorting are in the first array.  
Extra space allowed is O(1)  

Eg. 
```
Input :
   ar1[] ={10}
   ar2[] = {2, 3}

Output:
   ar1[] = {2}
   ar2[] = {3, 10}
```

```
Input :
   ar1[] ={1, 5, 9, 10, 15, 20}
   ar2[] = {2, 3, 8, 13}

Output:
   ar1[] = {1, 2, 3, 5, 8, 9}
   ar2[] = {10, 13, 15, 20}
```

#### If Extra space was allowed:
We could take an array of size M+N and sort it and place the elements back in original arrays
O(M+N)log(M+N) + O(M) + O(N)

####  If Extra space wasn't allowed:
- We can think of Iterating in arr1
	- whenever we encounter an element is greater than the first element of array2
	- swap it
	- Rearrange the arr2 in a sorted manner [ Insertion sort for the misplaced element ]


Time :: O(N*M) {(Iteration through array1)*(ReOrder of 2nd array)} 
Space :: O(1)

a1 = {(1), 4, 7, 8, 10}  n1=5  
a2 = {(2), 3, 9}         n2=3  
1<2 hence no swap 

a1 = {1, (4), 7, 8, 10}  
a2 = {(2), 3, 9} 
4>2 hence swap -> {1, (2), 7, 8, 10}
               -> {(4), 3, 9} --> insertion sort --> {3, 4, 9}

a1 = {1, 2, (7), 8, 10}
a2 = {(3), 4, 9}
7>3 hence swap -> {1, 2, (3), 8, 10}
               -> {(7), 4, 9} --> insertion sort --> {4, 7, 9}

a1 = {1, 2, 3, (8), 10}  
a2 = {(4), 7, 9}  
8>4 hence swap -> {1, 2, 3, (4), 10} 
               -> {(8), 7, 9} --> insertion sort --> {7, 8, 9}

a1 = {1, 2, 3, 4, (10)}  
a2 = {(7), 8, 9}  
7<10 hence no swap 

we reached the end of the a1, hence we stop


```java
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
```
## Gaps Algorithm

Time :: O(log<sub>2</sub>N)*O(N)   
{(No. of times we perform the gap operations)*O(N)}  

- gaps = Math.ceil((M+N)/2.0)  
- swaps a[i] --- a[i + gap]
- gaps = gaps/2
- do while gaps == 0

{(1), 4,  7,  8, (10)}   { 2,  3,  9 }  
{ 1, (4), 7,  8,  10 }   {(2), 3,  9 }  
{ 1,  4, (7), 8,  10 }   { 2, (3), 9 }  
{ 1,  4,  7, (8), 10 }   { 2,  3, (9)}  


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
       int gap = (int)Math.ceil((m+n)/2.0);;

       while(gap!=0)
       {
           int i=0, j = gap;
           while(j<n+m)
           {
               if(i<n && j<n && a1[i]>a1[j])
               {
                   swap(a1, i, a1, j);
               }
               else if(i<n && j>=n  && a1[i]>a2[j-n])
               {
                   swap(a1, i, a2, j-n);
               }
               else if(i>=n && j>=n && a2[i-n]>a2[j-n])
               {
                   swap(a2, i-n, a2, j-n);
               }
               i++; j++;
           }
           
           if(gap==1)
                gap =0;
           else
                gap = (int)Math.ceil(gap/2.0);
       }
       
       
    }
}
```