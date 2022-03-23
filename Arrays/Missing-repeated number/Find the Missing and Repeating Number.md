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

### Approach 1 :: XOR Property

e.g. arr[] = {4, 3, 6, 2, 1, 1}  
- Step 1 :: Take the xor of all elements of an array - XOR<sub>1</sub>  
    -  XOR<sub>1</sub> = 4^3^6^2^1^1  
- Step 2 :: Take the xor of all elements of an array - XOR<sub>2</sub>
    -  XOR<sub>2</sub> = 1^2^3^4^5^6  

- Step 3 : XOR<sub>1</sub> ^ XOR<sub>2</sub> = Missing^Repeating = M^R  
    - ( 4^3^6^2^1^1)^(1^2^3^4^5^6) = 1^5  

- since we are sure that M and R are different numbers, atleast one bit will be different in binary representation.  
- Let's take the rightmost bit that is different in M and R  
- M ^ R = 1 0 0  
- here the 2nd bit is different   
- -> either 2nd bit in M is (1) and R is (0) or vice-versa  

- Step 4 : Classify the array nos in 2 sets  ( one where the bit(here 2nd) is set, other where it is not)
    - B1 : [4^6]
    - B2 : [3^2^1^1]

- Step 4 : Classify the nos 1 to n in 2 sets  ( one where the bit(here 2nd) is set, other where it is not)
    - B1 : [4^6]^[4^5^6] = 5
    - B2 : [3^2^1^1]^[1^2^3] = 1

- Step 5: From one set we get the missing no, from another we get the repeating no. 
          - Linearly traverse the array to check which one amongst the two is missing no.


```java

public class Solution {
    
    public int checkBit(int k, int n)
    {
        if( (n & 1<<(k-1)) == (1<<(k-1)) )
            return 1;
        else
            return 0;
    }
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] repeatedNumber(final int[] a) {
        
        int n = a.length;
        int xor =0;
        for(int i=0; i<n; i++)
            xor^=a[i];
            
        for(int i=1; i<=n; i++)
            xor^=i;
            
        int bit_pos=0;
        for(int i=32; i>=0; i--)
        {
            if(checkBit(i, xor)==1)
                {bit_pos = i; break;}
        }

        int xor1=0, xor2=0;
        for(int i=0; i<n; i++)
        {
            if(checkBit(bit_pos, a[i])==1)
                xor1^=a[i];
            else
                xor2^=a[i];
        }
        
        for(int i=1; i<=n; i++)
        {
            if(checkBit(bit_pos, i)==1)
                xor1^=i;
            else
                xor2^=i;
        }
        
        
        for(int i=0; i<n; i++)
        {
            if(a[i]==xor1)
                {return new int[]{xor1, xor2};}
        }
        return new int[]{xor2, xor1};
    }
}

```