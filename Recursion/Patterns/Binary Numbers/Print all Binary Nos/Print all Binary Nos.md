Print all Binary numbers of length n with no consecutive 1 in lexiographical order

```
Input = 3
E.g. 000  001 010 100 101
```

```java
void binary(String n, int len)
{
    if(n.length()==len)
        System.out.print(n+ " ");
    else
    {
        // Check the last Character in the Binary Representation of the no.
        char lastChar = '';
        if(n.length()!=0)
            lastChar = n.charAt(n.length()-1);

        if(lastChar=='1')
        {
            binary(n+"0", len);
        }
        else
        {
            binary(n+"0", len);
            binary(n+"1", len);
        }
    }
}

```
