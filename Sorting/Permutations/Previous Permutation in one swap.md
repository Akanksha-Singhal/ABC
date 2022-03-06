## Previous Permutation in One Swap

#### Source :: https://leetcode.com/problems/previous-permutation-with-one-swap/

Given an array of positive integers arr (not necessarily distinct), return the lexicographically largest permutation 
that is smaller than arr, that can be made with exactly one swap 
(A swap exchanges the positions of two numbers arr[i] and arr[j]).

 If it cannot be done, then return the same array.

 <img src="https://github.com/Akanksha-Singhal/ABC/blob/master/Uploads/Previous_Permutation_in_one_swap.PNG" width="94" height="346">

 Example 1:
```
Input: arr = [3,2,1]
Output: [3,1,2]
Explanation: Swapping 2 and 1.
```
Example 2:
```
Input: arr = [1,1,5]
Output: [1,1,5]
Explanation: This is already the smallest permutation.
```
Example 3:
```
Input: arr = [1,9,4,6,7]
Output: [1,7,4,6,9]
Explanation: Swapping 9 and 7.
```

```java
class Solution {
    public void swap(int a[], int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public void reverse(int a[], int start, int end)
    {
        for(int i=0; i<=(end-start)/2; i++)
        {
            int temp = a[start+i];
            a[start+i] = a[end-i];
            a[end-i] = temp;
        }
    }
    
    public int[] prevPermOpt1(int[] a) {
        // given the string or an array, linearly traverse from the back
        int n = a.length;
        
        int i = n-2;
        while(i>=0 && a[i] <= a[i+1]) i--;
        
        int index1 = i; // here a[index] > a[index+1]
        if(index1!=-1)
        {
            int index2 = index1+1;
            for(int j=index1+1; j<n; j++)
                if(a[j] > a[index2] && a[j]<a[index1])
                    index2 = j;
                    
            swap(a, index1, index2);     
        }
        return a;
    }
}
```