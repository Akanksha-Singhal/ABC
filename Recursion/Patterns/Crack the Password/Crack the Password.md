Crack The Password

Try all possible combinations of numerical passwords of length n 

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





