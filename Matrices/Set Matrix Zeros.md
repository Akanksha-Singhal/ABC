## Set Matrix Zeroes

Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.

Source :: https://leetcode.com/problems/set-matrix-zeroes/
 https://www.youtube.com/watch?v=M65xBewcqcI&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=8

Input: matrix = 
```
[[1,1,1],  
 [1,0,1],  
 [1,1,1]]  
```

Output: 
```
[[1,0,1],  
 [0,0,0],  
 [1,0,1]]
 ```


 Input: matrix = 
 ```
 [[0,1,2,0],  
  [3,4,5,2],  
  [1,3,1,5]]
 ```
Output: 
```
 [[0,0,0,0],  
  [0,4,5,0],  
  [0,3,1,0]]
```


Approach 1 :: Brute Force  
Time :: O((n*m)*(n+m)) 

- Traverse the whole matrix
	- If you encounter a 0
		- Traverse for it's entire row and entire column
			- Change 1 to -1

- Once the entire matrix has been traversed 
- Traverse the whole matrix and Change -1 to 0