## Duplicate Character

#### Source :: 

Given a string S  which contains the first letter of all the student names in her class. 
Find out the count of characters that occur more than once in the string.




Output format
For each test case on a new line, print the output in the format character=count. 
If multiple characters have more than one count, print all of them separated by space, in alphabetical order.
In case no such character is present print −1

Input
```
3
prepbytes
java
algorithm
```

Output
```
e=2  p=2    
a=2  
−1
```

```java
 public void countFrequencies(String str)
    {
      SortedMap<Character, Integer> sm = new TreeMap<Character, Integer>();
        
        for(int i=0; i < str.length(); i++)
        {
          char ch = str.charAt(i);
          sm.put(ch, sm.getOrDefault(ch, 0)+1);
        }
        
        Set s = sm.entrySet();
        Iterator i = s.iterator();
        boolean found = false;
        while(i.hasNext())
        {
          Map.Entry m = (Map.Entry)i.next();
          char key = (char)m.getKey();
          int value = (int)m.getValue();
          if(value > 1)
            {System.out.print(key+"="+value+" ");
              found = true;
            }
        }
        if(!found)
          System.out.print("-1");
        System.out.println();
    }

```