## Compare Version Numbers

```
Given two version numbers, version1 and version2, compare them.

* Version numbers consist of one or more revisions joined by a dot '.'. 
* Each revision consists of digits and may contain leading zeros. 
* Every revision contains at least one character. 
* Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, 
the next revision being revision 1, and so on. 
For example 2.5.33 and 0.1 are valid version numbers.

* To compare version numbers, compare their revisions in left-to-right order. 
* Revisions are compared using their integer value ignoring any leading zeros. 
* This means that revisions 1 and 001 are considered equal. 
* If a version number does not specify a revision at an index, then treat the revision as 0. 
For example, version 1.0 is less than version 1.1 because their revision 0s are the same, 
but their revision 1s are 0 and 1 respectively, and 0 < 1.

Return the following:

If version1 < version2, return -1.
If version1 > version2, return 1.
Otherwise, return 0.
```

```java
public class Solution {
    
    public String padLeftZeros(String inputString, int length) 
    {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);
    
        return sb.toString();
    }

    String removeLeadingZeros(String str)
    {
       if(str.length()==1)
            return str;
        
        char ch[] = str.toCharArray();
        int i=0;
        while(i< ch.length-1 && ch[i]=='0')
            i++;
        return str.substring(i, ch.length);
    }
    
    public int compareVersion(String version1, String version2) {
        
        String str1[] = version1.split("\\.");
        String str2[] = version2.split("\\.");
        
        
        for(int i=0; i<str1.length; i++)
            str1[i] = removeLeadingZeros( str1[i]);
           
        
        for(int i=0; i<str2.length; i++)
            str2[i]= removeLeadingZeros( str2[i]);
        
        int i=0;
        int minLength = Math.min(str1.length, str2.length);
        for(; i<minLength; i++)
        {
            
            int diffInLength = str1[i].length() - str2[i].length();
            

            if(diffInLength<=0) // str2[i] is longer, pad str1[i] with zeros
                str1[i] = padLeftZeros(str1[i], str2[i].length());
            else
                str2[i] = padLeftZeros(str2[i], str1[i].length());
            
            
            int comp = str1[i].compareTo(str2[i]);
            

            if(comp>=1)
                return 1;
            else if(comp <=-1)
                return -1;
            
        }
        
        
        // for test cases like - 1.0 and 1.0.0 [are equal]
        while(i < str1.length)
        {
            if(str1[i].equals("0"))
                i++;
            else
                return 1;
        }
        
         while(i < str2.length)
        {
            if(str2[i].equals("0"))
                i++;
            else
                return -1;
        }
            
        return 0;  
    }
   
}
```