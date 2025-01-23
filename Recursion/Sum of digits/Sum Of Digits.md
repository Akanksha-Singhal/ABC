Sum Of Digits


```
Example 1:

Input: num = 38
Output: 11
Explanation: The process is
38 --> 3 + 8 --> 11

Example 2:

Input: num = 0
Output: 0
```



```java
class Solution {
    public int addDigits(int num) {

        if(num==0)
            return 0;
        
        return addDigits(num/10)+(num%10);
        
    }
}
```