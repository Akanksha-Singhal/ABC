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
    

```
Valid Numbers :
integer - "2", "0089" 
decimal - "0.1", "3.14", "4.", ".9"
Integer with e ( unsigned power) - "2e10", "90E3"
Integer with e with (signed integral power) - "3e+7", "6e-1"
Decimal with e with (signed integral power) - "53.5e93", "123.456e789", "46.e3", "-1."

Invalid Numbers:
Alphabets - "abc", "1a", "95a54e53"
e is not in middle - "1e", "e3"
fractional powers - "99e2.5"
Base or power not defined - "4e+", ".e1"
More than 1 sign or decimal - "--6", "-+3", "0.."
```

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



Approach :: Split around the "E"

```java
class Solution {
    
    
    public boolean checkAtleastOneDigit(String num)
    {
        char ch[] = num.toCharArray();
        if(ch.length==0)
            return false;
        
        for(int i=0; i<ch.length; i++)
        {
            if(!(ch[i]>='0' && ch[i]<='9'))
                return false;
        }
        return true;
    }
    
    public boolean checkOptionalSign(String num)
    {
        char ch[] = num.toCharArray();
        if(ch.length>1)
            return false;
        for(int i=0; i<ch.length; i++)
        {
            if(!(ch[i]=='+'||ch[i]=='-'))
                return false;
        }
        return true;
    }
    
    public boolean checkAtleastOneInteger(String num)
    {
        char ch[] = num.toCharArray();
        if(ch.length==0)
                return false;
        
        String sign = num.substring(0, 1);
        boolean isFirstCharSign = checkOptionalSign(sign);

        if(isFirstCharSign)
            num = num.substring(1, num.length());
        
        boolean atleastOneDigit = checkAtleastOneDigit(num);
        return atleastOneDigit;
        
    }
    
    
    public boolean checkDecimalDots(String num)
    {
        char ch[] = num.toCharArray();
        if(ch.length==0)
                return false;
        
        String sign = num.substring(0, 1);
        boolean isFirstCharSign = checkOptionalSign(sign);

        if(isFirstCharSign)
            num = num.substring(1, num.length());
        
        if(num.length()==0)
            return false;
        
        if(num.charAt(num.length()-1)=='.')
        {
              num = num.substring(0, num.length()-1);
              return checkAtleastOneDigit(num);
        }
        else if(num.charAt(0)=='.')
        {
             num = num.substring(1, num.length());
             return checkAtleastOneDigit(num);
        }
        else
        {
            String[] nums = num.split("\\.");
            if(nums.length!=2)
                return false;
            return checkAtleastOneDigit(nums[0]) && checkAtleastOneDigit(nums[1]);
        }
    }
    
    boolean checkPart1(String num)
    {
        return checkAtleastOneInteger(num)||checkDecimalDots(num);
    }
    
    boolean checkValidNumber(String num)
    {
          if(num.length()==0)
              return true;
         int indexOfE =num.indexOf('e');
         if(indexOfE==-1)
             indexOfE =num.indexOf('E');
         
         if(indexOfE==-1)
             return checkPart1(num.substring(0, num.length()));       
         
         String half1= num.substring(0, indexOfE);
         String half2= num.substring(indexOfE+1, num.length());
        
        return  checkPart1(half1) && checkAtleastOneInteger(half2);
    }
    
    
     public boolean isNumber(String num) 
     {                   
         return  checkValidNumber(new String(num));
     }
}
```