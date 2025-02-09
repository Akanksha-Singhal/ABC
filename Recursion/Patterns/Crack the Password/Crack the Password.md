Crack The Password

````
Given a length l
Try all possible combinations of numerical passwords of length n 
Digits of the password are from 1 to 9
````

Method: Recursion

```java
static void password(String n, int len)
    {
        if(n.length()==len)
        {
            System.out.print(n+" ");
            return;
        }
        else
        {
            for(char c='1'; c<='9'; c++)
            {
                password(n+c, len);
            }
        }
    }

```





