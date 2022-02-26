## Pretty Json

####Source :: https://www.interviewbit.com/problems/pretty-json/


Given a string A representating json object. 
Return an array of string denoting json object with proper indentaion.

Rules for proper indentation:

Every inner brace should increase one indentation to the following lines.
Every close brace should decrease one indentation to the same line and the following lines.
The indents can be increased with an additional ‘\t’
Note:
```
[] and {} are only acceptable braces in this case.

Assume for this problem that space characters can be done away with.
```

For Example

Input 1:
```
    A = "{A:"B",C:{D:"E",F:{G:"H",I:"J"}}}"
```

Output 1:
```
    { 
        A:"B",
        C: 
        { 
            D:"E",
            F: 
            { 
                G:"H",
                I:"J"
            } 
        } 
    }
```

Input 2:
```
A = ["foo", {"bar":["baz",null,1.0,2]}]
```
Output 2:
```
   [
        "foo", 
        {
            "bar":
            [
                "baz", 
                null, 
                1.0, 
                2
            ]
        }
    ]
```
```java
public class Solution {
    
    public String addTabs(String str, int tabSpace)
    {
        str = "";
        for(int k=0; k<tabSpace; k++)
            str+="\t";
        return str;
    }
    
    
    public String[] prettyJSON(String A) {
        
        ArrayList<String> list = new  ArrayList<String>();
        char ch[] = A.toCharArray();
        
        int tabSpace =0;
        int n = ch.length;
        String str = "";

        for(int i=0; i<n; i++)
        {
            if(ch[i]==' ')
                continue;
            str+=ch[i];
            if(ch[i]=='{' || ch[i]=='[')
            {
                // clear everything start a new line 
                str = addTabs(str, tabSpace); // add tabs till now
                str+=ch[i];  // add the opening bracket
                list.add(str); //add a new line 
            // Rules :: Every inner brace should increase one indentation to the following lines.
                tabSpace++; // increase tabsapce
                // clear everything start a new line 
                str = addTabs(str, tabSpace); // add tabsapce till now
            }
            else if(i+1<n && (ch[i+1]=='{' || ch[i+1]=='['))
            {
               // before adding an inner brace , add the current line
                list.add(str);
            }
            else if(ch[i]==',')
            {
                //add a new line 
                list.add(str);
                // clear everything start a new line 
                str = addTabs(str, tabSpace);
            }
            else if(ch[i]=='}' || ch[i]==']')
            {  
              // if it is followed by comma, then rules for commas are applied
               if(i==n-1 || (i+1<n && ch[i+1]!=','))
               {
                    //clear everything start a new line 
                    str = addTabs(str, tabSpace);
                    str+=ch[i]; 
                    list.add(str); 
                    // Every close brace should decrease one indentation to the following line 
                    tabSpace--;  
                    // clear everything start a new line 
                    str = addTabs(str, tabSpace);
               }
            }
            else if(i+1<n && (ch[i+1]=='}' || ch[i+1]==']'))
            {
            // Rules :: Every close brace should decrease one indentation to 
            //the same line and the following lines.
                // add the string so far -> new line -> reduce tab space
                   list.add(str);
                   tabSpace--; // decrease one indentation to the same line 
                   // clear everything start a new line 
                   str = addTabs(str, tabSpace);
            }
        }
       
       String s[] = new String[list.size()];
       
       for(int i=0; i<list.size(); i++)
       {
           s[i] = list.get(i);
       }
        return s;
    }
}

```