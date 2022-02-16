### String to Integer (atoi)

#### Source:: https://leetcode.com/problems/string-to-integer-atoi/solution/

Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).



* The algorithm for myAtoi(string s) is as follows:
	1. Read in and ignore any leading whitespace.

	2. Check if the next character (if not already at the end of the string) is '-' or '+'.  
		* Read this character in if it is either.  
			*  This determines if the final result is negative or positive respectively. 
			*  Assume the result is positive if neither is present.  
		
	3. Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.

		* Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32).
			1. If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
			2. If the integer is out of the 32-bit signed integer range [-2<sup>31</sup>, 2<sup>31</sup> - 1], then clamp the integer so that it remains in the range.
				* Specifically, integers less than -2<sup>31</sup> should be clamped to -2<sup>31</sup>, and 
				* integers greater than 2<sup>31</sup> - 1 should be clamped to 2<sup>31</sup> - 1.
	4. Return the integer as the final result.


> Note:
> Only the space character ' ' is considered a whitespace character.
> Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.


Approach :: Time :: O(n)  Space:: O(1)

Algorithm is already mentioned
- trim white spaces
- read the sign, num = 1
- read the digit 

    - Take care that num should not be greater > (Integer.MAX_VALUE  = 2147483647)
        - Case 1 : num == 2147483647, dont add the digit, return 2147483647
        - Case 2 : (num/10) < (2147483647/10), add any digit to num , result < 2147483647
        - Case 3 : (num/10) = (2147483647/10), add only 0-7 , result <= 2147483647, else for digits 8-9 return  2147483647;

        Similarly for underflow also 
 - num = num*10 + digit



```java
class Solution {
    
    public boolean checkDigit(char c)
    {
        if(c>='0' && c<='9')
            return true;
        return false;
    }
    public int myAtoi(String s) {
        
        int sign = 1;                
        int i=0;
        
        // trim all the white spaces
        while(i< s.length() && s.charAt(i)==' ')
            i++;

        if(i== s.length())
            return 0;
        
        char ch[] = s.toCharArray(); // avoid creating this array for O(1) space solution

        //check for the sign
        if(ch[i]=='+'||ch[i]=='-')
        {
            if(ch[i]=='-')
                sign = -1;
            i++;
        }
        
        int num =0;
        
        while(i < s.length() && checkDigit(s.charAt(i)))
        {
            char c = s.charAt(i);
            int digit = (c-'0'); 
            
             // Check overflow and underflow conditions. 
            if ((num > Integer.MAX_VALUE / 10) || 
                (num == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {     
                // If integer overflowed return 2^31-1, otherwise if underflowed return -2^31.    
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            num  = num*10 + digit;    
            i++;
        }
        num = num*sign;
        return num;                 
        
    }
}
```
