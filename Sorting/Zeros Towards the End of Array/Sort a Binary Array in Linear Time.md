## Sort a Binary Array in Linear Time

You are given an array of 0s and 1s in random order. Segregate 0s on left side and 1s on right side of the array 
[Basically you have to sort the array]. Traverse array only once.

Time :: O(n) Space :: O(1)

Input
```
{1,0,1,0,0,0,1}
```
Output
```
{0,0,0,0,1,1,1,1}
```


Approach 1 :: Time :: O(N) Two Pass   Space :: O(1)
First Pass, count no of zeros and no of ones
Second Pass ::  place the 0s then 1s

Approach 2:: Time :: O(N) Single Pass  Space :: O(1)


```java
 public int[] solve(int[] a) {
        
        int lastZeroPos = 0;
        int n = a.length;
        for(int i=0; i<n; i++)
        {
            if(a[i]==0)
            {
                a[lastZeroPos] = 0;
                lastZeroPos++;
            }
        }
        for(int i=lastZeroPos; i<n; i++)
        {
            a[i] =1;
        }
        return a;
    }
```