## Next Permutation

Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.

#### Source :: https://leetcode.com/problems/next-permutation/
#### Source :: https://youtu.be/LuLCLgMElus

Example 1:
```
Input: nums = [1,2,3]
Output: [1,3,2]
```
Example 2:
```
Input: nums = [3,2,1]
Output: [1,2,3]
```
Example 3:
```
Input: nums = [1,1,5]
Output: [1,5,1]
```

#### Approach 1 :: Brute Force
Time :: O(N!*N)
	- Generate all possible n! combinations 
	- linearly iterate and check which combination at which index is the given combination 
	- return the combination at (index+1)%n
	
#### Optimal Approach :: uses linear time complexity
###### Step 1
	- given this string or an array, linearly traverse it from the back
		- till you find an index auch that a[i] < a[i+1]
		- index1 = i

<img src="https://github.com/Akanksha-Singhal/ABC/blob/master/Uploads/next_permutation.PNG" width="100" height="50">
```
This is because all dictionary order increase from back till a certain point
```

###### Step 2
	- again linearly traverse it from the back
		- till you find an index auch that a[j] > a[index1]
		- index2 = j

<img src="https://github.com/Akanksha-Singhal/ABC/blob/master/Uploads/next_permutation_2.PNG" width="200" height="100">


###### Step 3
 - swap values at index1 and index2
<img src="https://github.com/Akanksha-Singhal/ABC/blob/master/Uploads/next_permutation_3.PNG" width="200" height="100">

###### Step 4
- reverse everything from n-1 to index1+1  
 <img src="https://github.com/Akanksha-Singhal/ABC/blob/master/Uploads/next_permutation_4.PNG" width="500" height="157">

 Result - 1 4 2 3 5 

 ###### Edge Case
 if Index1 = -1 i.e.  for e.g. 5 4 3 2 1
 do not execute steps 1, 2 and 3
 but execute step 4 : reverse the permutation :: 1 2 3 4 5 


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
    
    public void nextPermutation(int[] a) {
        
        // given the string or an array, linearly traverse from the back
        int n = a.length;
        
        int i = n-2;
        while(i>=0 && a[i] >= a[i+1]) i--;
        
        int index1 = i; // here a[index] < a[index+1]
        if(index1!=-1)
        {
            i = n-1;
            while(i>0 && a[i] <= a[index1]) i--;
            int index2 = i;   // here a[index2] > a[index1]

            swap(a, index1, index2);     
        }       
           
        reverse(a, index1+1, n-1);
        
        
    }
}
 ```