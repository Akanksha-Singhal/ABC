Fibonacci

```

    fib(0)       = 0
    fib(1)       = 1
    fib(2) = 0+1 = 1
    fib(3) = 1+1 = 2
    fib(4) = 1+2 = 3
    fib(5) = 2+3 = 5
    fib(6) = 3+5 = 8

```

```java
public static long fib(int n)
    {
        //Base Case
        if(n==1 || n==0)
            return n;

        return fib(n-1)+fib(n-2);
    }
```