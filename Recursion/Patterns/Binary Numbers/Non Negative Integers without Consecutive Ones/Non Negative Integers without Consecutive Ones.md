Non Negative Integers without Consecutive Ones

https://leetcode.com/problems/non-negative-integers-without-consecutive-ones/description/


Given a positive integer n, return the number of the integers in the range [0, n] whose binary representations do not contain consecutive ones.

```
Example 1:

Input: n = 5
Output: 5
Explanation:
Here are the non-negative integers <= 5 with their corresponding binary representations:
0 : 0
1 : 1
2 : 10
3 : 11
4 : 100
5 : 101
Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule. 
Example 2:

Input: n = 1
Output: 2
Example 3:

Input: n = 2
Output: 3
```

```java
class Solution {

    int binary(int n, int num, char lastDigit)
    {
        if(n>num)
            return 0;
        if(n==num)
            return 1;

        int count = 1;
        if(lastDigit == '1' && n!=0)
            count += binary(n<<1, num, '0');
        else
        {
            if(n!=0)
                count += binary(n<<1, num, '0');
            count+=binary((n<<1)+1, num, '1');
        }
    return count;
    }
    public int findIntegers(int n) {

          return binary(0, n, '0');
        
    }
}
```