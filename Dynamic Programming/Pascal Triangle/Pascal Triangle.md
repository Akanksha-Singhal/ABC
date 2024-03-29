Pascal's Triangle II

Youtube :: https://youtu.be/6FLvhQjZqvM

# Problem Type 2 : Print the value at a given Row and Column of Pascal's Triangle

Given an integer rowIndex and columnIndex, return the element at that part of the Pascal's triangle. (0-indexed)

#### Approach :: Time :: O(N) Space :: O(1)
given an index R, C  
value in Pascal Triangle is <sup>R-1</sup>C<sub>C-1</sub>


# Problem Type 3 : Print the n'th row of Pascal's Triangle
#### Source :: https://leetcode.com/problems/pascals-triangle-ii/

Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

<img src="https://github.com/Akanksha-Singhal/ABC/blob/master/Uploads/PascalTriangleAnimated2.gif" width="260" height="240">

###### Approach 3.1 :: Time :: O(N*N) Space :: O(N)
calculate <sup>R-1</sup>C<sub>C-1</sub> for every n element 


###### Approach 3.2 :: Time :: O(N) Space :: O(N)

4th Row - 1   &nbsp; &nbsp; <sup>4</sup>C<sub>0</sub>   &nbsp; &nbsp;  <sup>4</sup>C<sub>0</sub>(4-0)/(0+1)  &nbsp; &nbsp;   <sup>4</sup>C<sub>1</sub>(4-1)/(1+1)   &nbsp; &nbsp;  <sup>4</sup>C<sub>2</sub>(4-2)/(2+1)  &nbsp; &nbsp;  <sup>4</sup>C<sub>3</sub>(4-3)/(3+1)  


```java
class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        List<Integer> list = new ArrayList<Integer>();
        long num = 1;
        
        for(int i=0; i<=rowIndex; i++)
        {
            list.add((int)num);
            num  = (num*(rowIndex-i))/(i+1);
        }
        return list;
        
    }
}
```

# Problem Type 1 : Print all the rows of Pascal's Triangle
#### Source :: https://leetcode.com/problems/pascals-triangle/

#### Approach 1.1 :: Time :: O(N*N) Space :: O(N)

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
Example 1:
```
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
```
Example 2:
```
Input: numRows = 1
Output: [[1]]
```

```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> al = new ArrayList<List<Integer>>();
        
        for(int i=0; i<numRows; i++)
        {
            List<Integer> list = new ArrayList<Integer>();
            for(int j=0; j<=i; j++)
            {
                if(j==0||i==j)
                    list.add(1);
                else
                {
                    int num1 = al.get(i-1).get(j-1);
                    int num2 = al.get(i-1).get(j);
                    int sum = num1+num2;
                    list.add(sum);
                }
            }
            
            al.add(list);
        }
        return al;
        
    }
}
```






