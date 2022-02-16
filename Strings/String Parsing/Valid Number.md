## Valid Number

#### Source :: https://leetcode.com/problems/valid-number/

* A valid number can be split up into these components (in order):
	1. A decimal number or an integer.
		* A decimal number can be split up into these components (in order):
			1. (Optional) A sign character (either '+' or '-').
			2. One of the following formats:
				* One or more digits, followed by a dot '.'.
				* One or more digits, followed by a dot '.', followed by one or more digits.
				* A dot '.', followed by one or more digits.

		* An integer can be split up into these components (in order):
			1. (Optional) A sign character (either '+' or '-').
			2. One or more digits.

	2. (Optional) An 'e' or 'E', followed by an integer.
    


Approach :: Use Regex
```java
 public boolean isNumber(String s) {  
        
          String Regex = "";
          String digits = "[0-9]";
          String optionalSign = "([+-]{0,1})";
          String dot = "[\\.]";
          String atleastOneDigit = "("+digits+"{1,20}"+")";
          
          String atleastOneInteger = "("+optionalSign+atleastOneDigit+")";
          
          String digits_dot =  "("+atleastOneDigit+dot+")";          
          String digits_dot_digits =  "("+atleastOneDigit+dot+atleastOneDigit+")";
          String dot_digits =  "("+dot+atleastOneDigit+")";

          String decimal =  "("+optionalSign+"("+digits_dot+"|"+digits_dot_digits+"|"+dot_digits+")"+")";
          
          String part1= "("+decimal+"|"+atleastOneInteger+")";          
          String part2 = "("+"([eE]"+atleastOneInteger+"){0,1}" +")";    
          Regex = "("+part1+part2+")";
          
         // System.out.println(Regex);
          
          return Pattern.matches(Regex, s);   
        
    }
```


Approach :: Split around the decimal

```java
class Solution {
    
    
    public boolean checkE(String s)
    {
       char ch[] = s.toCharArray();
         int countE=0; 
        for(int i=0; i<ch.length; i++)
        {
            if(ch[i]=='e' || ch[i]=='E')
            {
                countE++;
                if(i==0 || i== ch.length-1)
                    return false;     
                if(ch[i-1]=='.' && i==1) //".e1"
                    return false;

            }
            if(ch[i]=='.' && countE==1)  // "99e2.5"
                  return false;
            if(countE > 1)
                return false;            
        }
        return true;
    }
    
    
  public boolean count_Period(String s)
    {
        char ch[] = s.toCharArray();
        int countDot=0; 
        for(int i=0; i<ch.length; i++)
        {
            if(ch[i]=='.' )
                 countDot++;            
        }
        if(countDot>1)
            return false;     
      return true;
    }
    
    
    public boolean checkForNumeric(String s)
    {
        //System.out.println(s);
        char ch[] = s.toCharArray();
        int countE=0, countSign = 0;
        for(int i=0; i<ch.length; i++)
        {
            if((ch[i]>='0' && ch[i]<='9'))
                continue;
            else if(ch[i]=='e' || ch[i]=='E')
                continue;
            else if( (ch[i]=='+'||ch[i]=='-') && i!=0 && i!=ch.length-1 && (ch[i-1]=='e'||ch[i]=='E') && countSign < 1)
                { countSign++; continue; }             
            else 
              return false;
        }
        return true;
    }
    public boolean isNumber(String s) {
        
        // check if first char is '+' or '-'
        
        if(s.charAt(0)=='+'||s.charAt(0)=='-')
            s = s.substring(1, s.length());
        
        // Split the decimal and fractional part separated by "."
        String nums[] = s.split("\\.");  

        
        if(nums.length>2 || nums.length==0)
            return false;
        if(!count_Period(s) || !checkE(s))  //""0..""
            return false;

        return checkForNumeric(nums[0]) && ( (nums.length==1) || (nums.length==2 && checkForNumeric(nums[1])));
        
    }
}
```