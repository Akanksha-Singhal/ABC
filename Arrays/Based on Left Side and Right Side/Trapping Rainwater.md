## Trapping Rain Water
##### Source :: https://leetcode.com/problems/trapping-rain-water/

Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it can trap after raining.

```
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array
[0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped
```


#### Approach :  Time :: O(n) Space :: O(n)
            water = Math.min(lmax, rmax) - height

```java
class Solution {
    public int trap(int[] height) {
     
        int n = height.length;
        int lmax[] = new int[n];
        int rmax[] = new int[n];
        
        int max =0;
        for(int i=0; i<n; i++)
        {
            lmax[i] = max;
            if(max < height[i])
                max = height[i];
        }
        
        max =0;
        for(int i=n-1; i>=0; i--)
        {
            rmax[i] = max;
            if(max < height[i])
                max = height[i];
        }
        
        int totalWater=0;
        for(int i=0; i<n; i++)
        {
            int water = Math.min(lmax[i], rmax[i]) -  height[i];
            if(water >=0)
                totalWater += water;
        }
        return totalWater;
    }
}
```