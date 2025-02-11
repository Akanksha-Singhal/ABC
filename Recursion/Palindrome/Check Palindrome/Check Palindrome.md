Check Palindrome

Using recursion
#### Space - O(n/2)


```java
    boolean checkPalindrome(String str, int i)
    {
        int n = str.length();
        if(i==n/2)
            return true;
        else if(str.charAt(i) != str.charAt(n-1-i))
            return false;
        else
            return checkPalindrome(str, i+1);
    }
```
Calling code
```java
boolean isPalindrome = checkPalindrome(str, 0);
```

