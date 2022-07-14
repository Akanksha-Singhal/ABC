## Valid Sudoku

#### Source:: https://www.interviewbit.com/problems/

Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx
The Sudoku board could be partially filled, where empty cells are filled with the character ‘.’.

The input corresponding to the above configuration :

["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
A partially filled sudoku which is valid.

Note:

A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
Return 0 / 1 ( 0 for false, 1 for true ) for this problem


Approach :: 

```java
public class Solution {
    
    public boolean checkHashSet(HashSet<Integer> hs, int val)
    {
        if(!hs.contains(val))
            hs.add(val);
        else
            return false;
        return true;    
    }
    
    ArrayList<HashSet<Integer>> createHashSet()
    {
        ArrayList<HashSet<Integer>> alhs = new ArrayList<HashSet<Integer>>(9);
        for(int i=0; i<9; i++)
        {
            alhs.add(new HashSet<Integer>());
        }
        return alhs;
    }
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int isValidSudoku(final String[] a) {
        
        
        ArrayList<HashSet<Integer>> colsHs = createHashSet();
        ArrayList<HashSet<Integer>>  rowsHs = createHashSet();
        ArrayList<HashSet<Integer>>  sqHs = createHashSet();
        
        for(int i=0; i<9; i++)
        {
            for(int j=0; j<9; j++)
            {
                char ch = a[i].charAt(j);
                if(ch=='.')
                    continue;
                int val = ch-'0';
                
                if(!checkHashSet(colsHs.get(j), val))
                    return 0;
                if(!checkHashSet(rowsHs.get(i), val))
                    return 0;
                if(!checkHashSet(sqHs.get((i/3)*3 +(j/3)), val))
                    return 0;
                    
            }
        }
        return 1;
        
    }
}

```
