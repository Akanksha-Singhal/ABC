## Compare Version Numbers

#### Source :: https://leetcode.com/problems/compare-version-numbers/
Given two version numbers, version1 and version2, compare them.

* Version numbers consist of one or more revisions joined by a dot '.'. 
    * Each revision consists of digits and may contain leading zeros. 
    * Every revision contains at least one character. 
    * Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision being revision 1, and so on. 
    For example 2.5.33 and 0.1 are valid version numbers.

* To compare version numbers, compare their revisions in left-to-right order. 
    * Revisions are compared using their integer value ignoring any leading zeros. 
    * This means that revisions 1 and 001 are considered equal. 
    * If a version number does not specify a revision at an index, then treat the revision as 0. 
    For example, version 1.0 is less than version 1.1 because their revision 0s are the same, 
but their revision 1s are 0 and 1 respectively, and 0 < 1.

Return the following:
> If version1 < version2, return -1.  
If version1 > version2, return 1.
Otherwise, return 0.


#### Test Cases to Consider while coding
###### Example 1
``` 
Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
```

###### Example 2
``` 
Input: version1 = "1.0", version2 = "1.0.0"
Output: 0
Explanation: version1 does not specify revision 2, which means it is treated as "0".
```

###### Example 3
``` 
Input: version1 = "0.1", version2 = "1.1"
Output: -1
Explanation: version1's revision 0 is "0", while version2's revision 0 is "1". 0 < 1, so version1 < version2.
```

###### Example 4
``` 
A : "3346237295"
B : "898195413.2.6243"
Output: 1 
> Note : While comparing strings "898195413" >  "3346237295", but we have to compare them as numbers 

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
        
        // Split all the revisions separated by "."
        String str1[] = version1.split("\\.");
        String str2[] = version2.split("\\.");
        
        // Remove Leading zeros from every version
        for(int i=0; i<str1.length; i++)
            str1[i] = removeLeadingZeros(str1[i]);
           
        
        for(int i=0; i<str2.length; i++)
            str2[i]= removeLeadingZeros(str2[i]);
        
        int i=0;
        int minLength = Math.min(str1.length, str2.length); // compare their revisions in left-to-right order.
        for(; i<minLength; i++)
        {
            // To compare 2 revisions as a String they should be of equal length, if not pad the shorter with zeros in the left
            int diffInLength = str1[i].length() - str2[i].length();
            
            
            if(diffInLength<=0) // Revision2 is longer, pad Revision1 with zeros
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
