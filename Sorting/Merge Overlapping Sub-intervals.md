## Merge Intervals

Source :: https://leetcode.com/problems/merge-intervals/

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
```
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
```
Example 2:
```
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
```

Follow up Questions::
 - are the intervals given in sorted order ?? 


### Brute Force Approach :: Time :: O(Nlog) + O(N<sup>2</sup>) [Sorting + Brute Force]
- sort all the given intervals -> [[1,3],[2,6],[8,10],[15,18]]
- linearly iterate through every given interval 
	- and check which of the remaining interval merges with the curr interval
	- e.g. [[1,3],[2,6]] -> [1,6]


### Better Approach  Time:: O(NlogN)  Space :: O(N) [ Sorting + Linear Array Traversal]
e.g. [[1,3],[2,6],[8,10],[8,9],[9,11],[15,18],[2,4],[16,17]]
- sort all the given intervals ->   
   [[1,3],[2,4],[2,6],[8,9],[8,10],[9,11],[15,18],[16,17]]
- i=0
- take the i'th pair e.g. for i=0 [1,3] and convert to a Pair p = new Pair(1, 3)
- for j=i and j < n
	- check if the j'th Pair merges with i'th Pair (e.g. i=0 && j=1 [li,ri] and [lj,rj])
		- if it merges into ( l, r)
			- then l = l1 (since the array of pairs is already sorted)
			- then r = Max(ri, rj)
			- [li, ri] = [l, r]; change the first pair as result
		- if it doesnot merge to (l,r) or if j==n
			- add (l, r) to a data structure
			- i = j
	- j++
  
```java
class Solution {
    public int[][] merge(int[][] intervals) {
        
        List<int[]> res = new ArrayList<int[]>();

        if(intervals.length==0 || intervals==null)
            return res.toArray(new int[1][]);
        
        
        Arrays.sort(intervals, (a, b) -> (a[0]-b[0]));
        
        
        int[] curr = intervals[0];
        int merged_interval_start = curr[0];
        int merged_interval_end = curr[1];
        
        for(int[] interval : intervals)
        {
            int curr_start = interval[0];
            int curr_end = interval[1];

            if(curr_start <= merged_interval_end)
            {
                merged_interval_end = Math.max(merged_interval_end, curr_end);
            }
            else
            {
                res.add(new int[]{merged_interval_start, merged_interval_end});
                merged_interval_start = curr_start;
                merged_interval_end = curr_end;
            }
        }
        
        res.add(new int[]{merged_interval_start, merged_interval_end});
        
        return res.toArray(new int[1][]);
        
    }
}
```