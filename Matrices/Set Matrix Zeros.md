## Set Matrix Zeroes

Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.

#### Source :: https://leetcode.com/problems/set-matrix-zeroes/  
#### Explaination ::  https://www.youtube.com/watch?v=M65xBewcqcI&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=8

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


#### Approach 1 :: Brute Force  
Time :: O((n*m)*(n+m))  
Space :: O(1)

- Traverse the whole matrix
	- If you encounter a 0
		- Traverse for it's entire row and entire column
			- Change 1 to -1

- Once the entire matrix has been traversed 
- Traverse the whole matrix and Change -1 to 0

#### Approach 2 :: Optimized Approach :: Better Solution
Time :: O(n*m + n*m) = O(n*m)
Space :: O(n) + O(m) 

- Take 2 dummy arrays (1st array - size of columns, 2nd array - size of rows )  
- Traverse the whole matrix
	- If you encounter a 0 at ( r, c)
		- dummy_row[r] = -1
		- dummy_col[c] = -1

- Traverse the Matrix
	- for (r, c) if the dummy_row[r] == -1 || dummy_col[c] == -1
		- mark (r, c) in the matrix as 0

#### Approach 3 :: Optimized Approach :: Optimal Solution :: Constant Space Solution

Time :: O(n*m + n*m) = O(n*m)
Space :: O(1)

- Create 2 dummy arrays inside the 2-d matrix 
	- (1st row - Column dummy matrix)
	- (1st col - Row dummy matrix)

<img src="https://github.com/Akanksha-Singhal/ABC/blob/master/Uploads/set_matrix_zeros.jpeg" width="800" height="700">

- Boolean var :: no_zeros_in_dummy_col = true
- Traverse the whole matrix (r-> [0, m-1], c->[0, n-1])
	- If you encounter a 0 at ( r, c) 
		- if c!=0 
			- dummy_row[r] = 0
			- dummy_col[c] = 0
		- if c==0
			- no_zeros_in_dummy_col = false // do not make any changes in dummy_row


##### Since we do not want to modify our dummy_row array i.e. row1 , we start from back

#### - Backwards Traverse the whole matrix  (r-> [m-1, 0], c->[n-1, 0])
	- for (r, c) 
		- if the (dummy_row[r] == 0 || dummy_col[c] == 0) && c>=1
			- mark (r, c) in the matrix as 0
		- if no_zeros_in_dummy_col = true && c==0
			- mark (r, c) in the matrix as 0
		

```java
class Solution {
    public void setZeroes(int[][] matrix) {
        
        int rows = matrix.length; int cols = matrix[0].length;        
        boolean no_zeros_in_dummy_col = true;  
        
                
         for(int r=0; r<rows; r++)
            if(matrix[r][0]==0)
                no_zeros_in_dummy_col = false;
        
        //to mark 0s in the first row _dummy_row
        
         /* Note in dummy cols & rows -> matrix[0][0] is an intersection 
             * assume it has no effect on first rows and if it zero then record
              and no_zeros_in_dummy_col var will take care of effect on first column */
        for(int c=1; c<cols; c++)
            if(matrix[0][c]==0)
                matrix[0][0]=0;      
        
        // mark the dummy row and column as 0 if the cell is 0
        for(int r=1; r<rows; r++)
        {
            for(int c=1; c<cols; c++)
                if(matrix[r][c]==0)   //dummy_row[c]=0 and dummy_col[r]=0 i.e. 
                    matrix[0][c] =matrix[r][0] = 0;                  
        }

        
        // Traverse Backwards and mark the cell 0 if dummy col or dummy row is  0
        for(int r=rows-1; r>=1; r--)
        {
            for(int c=cols-1; c>=1; c--)
            {
                if(matrix[0][c] == 0 ||  matrix[r][0] == 0)
                    matrix[r][c] = 0;              
            }
        }        
        
         for(int c=cols-1; c>=0; c--)
              if(matrix[0][0] == 0)
                   matrix[0][c] = 0; 
        
        if(no_zeros_in_dummy_col == false)  // set dummy_col = 0
            for(int r=rows-1; r>=0; r--)
                matrix[r][0] = 0; 
        
    }
}

```


Shorter Code :: 

```java
class Solution {
    public void setZeroes(int[][] matrix) {
        
        int rows = matrix.length; int cols = matrix[0].length;        
        boolean no_zeros_in_dummy_col = true;
        
        for(int r=0; r<rows; r++)
        {
            if(matrix[r][0]==0) no_zeros_in_dummy_col = false;
            for(int c=1; c<cols; c++)
                if(matrix[r][c]==0)   //dummy_row[c]=0 and dummy_col[r]=0 i.e. 
                    matrix[0][c] =matrix[r][0] = 0;                  
        }
        
        for(int r=rows-1; r>=0; r--)
        {
            for(int c=cols-1; c>=1; c--)
            {
                if(matrix[0][c] == 0 ||  matrix[r][0] == 0)
                    matrix[r][c] = 0;              
            }
            if(no_zeros_in_dummy_col == false)  matrix[r][0] = 0;  
        }
        
    }
}
```
