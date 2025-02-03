GCD(a, b)

````
Greatest Common Divisor for a and b is the largest number that fully divides both a and b
````

```java
public static int gcd(int a, int b)
{
    if(a==0)
        return b;

    return gcd(b%a, a);
}

```


```
gcd(0, 5) = 5

gcd(10, 5) = 5

gcd(15, 5) = 5

        gcd(15, 5)
            /  
    gcd(0, 5)  


gcd(25, 15) = 5

        gcd(25, 15) 
            /    
      gcd(15, 25)
          /
    gcd(10, 15)
        /
  gcd(10, 15)
     /
 gcd(5, 10)
   /
gcd(0, 5)

```

