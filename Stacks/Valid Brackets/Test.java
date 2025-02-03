
//Ques1 :: 

//Given a string consisting of opening and closing parenthesis, find length of the longest valid parenthesis substring.

//()         output ::  2
//()(()))))  output :: 6

import java.lang.*;
import java.util.*;
class Test
{
    static Stack<Character> s = new Stack<Character>();
    static int longestString =0;
    static int count = 0;
    
    public static int checkPar(String str)
    {
        char c[] = str.toCharArray();
        
        int i=0;
        while(i<c.length)
        {
            if(c[i]=='(')
                s.push(c[i]);
            else if(!s.empty() && s.peek()=='(' && c[i] == ')')
                { 
                    s.pop();
                    count +=1;
                }
             i++;
        }
        return count;    
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string with Parenthesis");
        String str = sc.next();
        int ans = checkPar(str);
        System.out.println("The string has "+ans+" valid bracket");
        sc.close();
    }
}
