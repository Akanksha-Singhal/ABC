## Reverse Words in a String

#### Source :: https://leetcode.com/problems/reverse-words-in-a-string/
#### Source :: https://www.interviewbit.com/problems/reverse-the-string/

Approach 1 :: Split and Reverse :: O(n) Space :: O(n) 
 - Split the string with white spaces and store it in an array
 - Reverse the array

 ```java
 public class Solution {
    public String[] splitAroundWhiteSpaces(String str)
    {
         List<String> l = new ArrayList<String>();
         String splitstr="";
         int n = str.length();
         for(int i=0; i<n;)
         {
            while(i<n && str.charAt(i)==' ')
                i++;
            int start = i;
            while(i<n && str.charAt(i)!=' ')
                            i++;
            if(start < n && str.charAt(start)!=' ')
               {
                   splitstr = str.substring(start, i);
                    l.add(splitstr);
               } 
         }

        String s[] = new String[l.size()];
        for(int i=0; i<l.size(); i++)
         {
             s[i] = l.get(i);
         }
        return s;
    }
    
    public String solve(String str) {
 
         String s[]  = splitAroundWhiteSpaces(str);     
        int start =0, end = s.length-1;
        for(int i=0; i<=(end-start)/2; i++)
        {
            String temp = s[start+i];
            s[start+i] = s[end-i];
            s[end-i] = temp;
        }

        String res="";
        for(int i=0; i<s.length-1; i++)
            res += s[i]+" ";
        res+= s[s.length-1];

        return res;
    }
}
 ```


Approach 2 :: Two Pointer       Time :: O(n) Space :: O(1) 
```java
class Solution {
    
    public String append(String s, String word)
    {
         if(!s.equals(""))
               s= word+" "+s;
         else
              s= word;
        return s;        
    }
    
    public String prepend(String s, String word)
    {
         if(!s.equals(""))
               s+=" "+word;
         else
              s= word;
        return s;        
    }
    public String reverseWords(String s) {
        
        char ch[] = s.toCharArray();
        int n = ch.length;
        int i=0, j=n-1;
        String firstHalf="", secondHalf="";
        while(i<=j)
        {
            while(i<n && ch[i]==' ')
                i++;
            
            while(j>=0 && ch[j]==' ')
                j--;
            
            int start_i = i;
            int end_j = j;
            
            while(i<n && ch[i]!=' ')
                i++;
            
             while(j>=0 && ch[j]!=' ')
                j--;
            

            if(i<=j && !(start_i==j+1 && i==end_j+1))
            {
                firstHalf = append(firstHalf, s.substring(start_i, i));
                
                secondHalf = prepend(secondHalf, s.substring(j+1, end_j+1));                   

            }      
            else if(start_i==j+1 && i==end_j+1)
            {
                firstHalf=append(firstHalf, s.substring(start_i, i));
            }
               
        }
        if(secondHalf.equals(""))
            return firstHalf;
        return secondHalf+" "+firstHalf;

    }
}
```