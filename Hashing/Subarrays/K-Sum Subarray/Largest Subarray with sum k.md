## Longest Sub-Array with Sum K

#### Source :: https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1

Given an array containing N integers and an integer K., 
Your task is to find the length of the longest Sub-Array 
with the sum of the elements equal to the given value K.

Example 1:
 
```
Input :
A[] = {10, 5, 2, 7, 1, 9}
K = 15
Output : 4
Explanation:
The sub-array is {5, 2, 7, 1}.
```
Example 2:
```
Input : 
A[] = {-1, 2, 3}
K = 6
Output : 0
```

#### Approach :: Time :: O(N) Space :: O(n)
- Create a HashMap (sumTillNow --> first Endpoint where the sumTillNow was found)  
- if an old sumTillNow-k is found, subarray from [Endpoint of (sumTillNow-k), current index] has sum = k


```java
class Solution{
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int a[], int N, int k) {
        //Complete the function
        
        // HashMap (sumTillNow --> first Endpoint where the sumTillNow was found)
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(0, -1);
        int sum = 0, maxLength=0;
        for(int i=0; i<N; i++)
        {
            sum +=a[i];
            if(hm.get(sum-k)!=null)
            {
                int start = hm.get(sum-k);
                int end = i;
                maxLength = Math.max(maxLength, end-start);
            }
            
            if(hm.get(sum)==null)
                hm.put(sum, i);
        }
        return maxLength;
        
    }
}


```