## Count subarrays with given xor

Given an array of integers A and an integer k.
Find the total number of subarrays having bitwise XOR of all elements equals to k.

Example Input
```
Input 1:

 A = [4, 2, 2, 6, 4]
 B = 6

Output 1:

 4
  The subarrays having XOR of their elements as 6 are:
 [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], [6]
```
```
Input 2:

 A = [5, 6, 7, 8, 9]
 B = 5

Output 2:

 2

The subarrays having XOR of their elements as 2 are [5] and [5, 6, 7, 8, 9]

```

#### Approach :: Hashing :: Time :: O(n) Space :: O(n)
- xor_till_i = a[0]^a[1]^a[2]^...^a[i]   
- xor_till_j = a[0]^a[1]^a[2]^...^a[i]^a[i+1]^a[i+2]^...^a[j]  
- xor_till_i ^ xor_till_j = a[i+1]^a[i+2]^...^a[j] 

- xor_till_i ^ xor_till_j ^ xor_till_j = k ^ xor_till_j  
- xor_till_i = k ^ xor_till_j  

- So this means 
- xor = 0
- keep taking xor_till_now i.e. xor = xor^a[i]
- create a HashMap (xor_till_now--> no of endpoints where you find xor_till_now)
- if xor_till_now^k is found at n indices 
- then all subarrays b/w those n indices as starting point and current index as ending point have xor = k


```java
public class Solution {
    public int solve(ArrayList<Integer> a, int k) {
        
        int n = a.size();
        
        //HashMap (xorTillNow--> no of EndPoint where we find xorTillNow)
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int xor=0, count=0;
        hm.put(0, 1); //null set
        for(int i=0; i<n; i++)
        {
            xor^=a.get(i);
            if(hm.get(xor^k)!=null)
            {
                count+= hm.get(xor^k);
            }

            hm.put(xor, hm.getOrDefault(xor, 0)+1);
        }
        return count;
    }
}
```



