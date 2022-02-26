## Star Character  

There is a collection of strings stored in an array. 
He wants to know the count of Star Characters present in the collection. 
A Star character is a character that occurs at least once in each of the string present inside the collection.


Example
Input
```
3
3
abcdde
baccd
eeabg
4
basdfj
asdlkjfdjsa
bnafvfnsd
oafhdlasd
3
vtrjvgbj
mkmjyaeav
sibzdmsk
```
Output
```
2
4
0
```

```java
     static int countDupCharacters(String str[], int n)
     {
       HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for(int i=0; i<n; i++)
        {
          char ch[] = str[i].toCharArray();
          for(int j=0; j<ch.length; j++)
          {
            if(hm.getOrDefault(ch[j], 0)==i)
                hm.put(ch[j], hm.getOrDefault(ch[j], 0) + 1); 
          }
        }
        
        Set s = hm.entrySet();
        Iterator i = s.iterator();
        int count =0;
        while(i.hasNext())
        {
          Map.Entry m = (Map.Entry)i.next();
          int key = (Character)m.getKey();
          int val = (Integer)m.getValue();
          if(val==n)
           count++;
        }
        return count;
     }
     
```
