Factorial using Recursion

```
4 -> 4x3x2x1 = 24
5 -> 5x4x3x2x1 = 120
```


```java
public static long fact(int n)
    {
        if(n==1||n==0)
            return 1;
        return n * fact(n-1);        
    }
```