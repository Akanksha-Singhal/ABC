
Print a pattern without using any loop

#### Source :: https://www.geeksforgeeks.org/print-a-pattern-without-using-any-loop/
Pattern : n, n-5, n-10, n-15, 0, ...., n-5, n


```java
public static void pattern_(int n)
    {
        System.out.print(n+ " ,");
        if(n>=0)  //do recursion only for positive values of n
            pattern_(n-5);
        
        if(n>0)  // re-print the same number
            System.out.print(n+" ,");

    }
```