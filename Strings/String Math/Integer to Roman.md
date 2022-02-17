### Integer To Roman

#### Source :: https://leetcode.com/problems/integer-to-roman/

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral.

```java
class Solution {
    
    public String getChar(int num)
    {
        switch(num)
        {
            case 1:
                return "I";
            case 5:
                return "V";
            case 10:
                return "X";
            case 50:
                return "L";
            case 100:
                return "C";
            case 500:
                return "D";
            case 1000:
                return "M";
        }
        return "";   
    }
    public String intToRoman(int num) {
        
        String roman ="";
        int previous_Divisor = 10000;
        int divisor = 1000;
        
        
        while(divisor >=1)
        {
            int face_value = num/divisor;        
            
            String symbol = getChar(divisor);
            String symbol_5 = getChar(divisor*5);
            String symbol_10 = getChar(divisor*10);


            if(face_value <4){
                for(int i=0; i<face_value; i++) roman +=symbol;
            }
            else if(face_value==4){ //4000 => symbol(1000)+symbol(5000)
                roman +=symbol+symbol_5;
            }
            else if(face_value == 5){
                roman +=symbol_5;
            }
            else if(face_value <=8){ //8000 => symbol(5000) + (8-5)symbol(1000)
                roman +=symbol_5; 
                for(int i=0; i<face_value-5; i++) roman +=symbol;         

            }
            else if(face_value == 9){ //9000 =>symbol(1000)+ symbol(10,000)             
                roman += symbol+symbol_10;                     
            }
        
            num = num %divisor;
            divisor = divisor/10;
        }
        
        return roman;
        
    }
}
```