## Find the missing and Repeated Number

You are given a read-only array of N integers with values also in the range [1,N] 
both inclusive. 
Each integer appears exactly once 
except A which appears twice and B which is missing. 
The task is to find the repeating and missing numbers A and B 
where A repeats twice and B is missing.


## Approach 1 :: Time :: O(2N) Space :: O(N)
- Since the nos are from 1 to N in the arr[]
- Take a count array count[] of size N+1 and initialize it with 0
- Traverse the given arr[] and increase the value of count[arr[i]] by 1
- Then again traverse the count[] arr
    - if count[i] > 1 => Repeating element
    - if count[i] = 0 => missing element 

# We have 2 Optimal Approaches

### Approach 1 :: Mathematical  
- We know that we have nos. 1 to n
sum 1 to n = sum(1+2+3+..+n) = ((n)*(n+1))/2  
sum of squares of 1 to n = 1<sup>2</sup> +  2<sup>2</sup> +  3<sup>2</sup> + ... +  n<sup>2</sup> = (n*(n+1)*(2*n+1))/6  

 <img src="https://github.com/Akanksha-Singhal/ABC/blob/master/Uploads/repeat_and_missing_2.jpeg" width="842" height="1280">




```java
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] repeatedNumber(final int[] a) {
        
        
        long n = (long)(a.length); // imp to convert to long
        long sum = (n*(n+1))/2l;
        long sum_squares = (n*(n+1)*((2*n+1)))/6l;
        
        long sum_of_elements = 0, sum_squares_of_elements =0;
        
        for(int i=0; i<n; i++)
        {
            sum_of_elements+=(long)a[i];
            sum_squares_of_elements+=((long)a[i]*(long)a[i]);
            
        }

        // (Missing-Repeating) = (M-R)
        long m_minus_r= sum-sum_of_elements;
        
        // (M*M - R*R) = (M-R)*(M+R)
        long  m_sq_minus_r_sq= sum_squares-sum_squares_of_elements;
        
        // (M+R) = (M*M-R*R)/(M-R)
        long m_plus_r = (m_sq_minus_r_sq/m_minus_r);
        long m = (m_plus_r + m_minus_r)/2l;
        long r = m-(m_minus_r);
        return new int[]{(int)r, (int)m};
    }
}

````