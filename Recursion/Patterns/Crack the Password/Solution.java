import java.util.*;
import java.lang.*;

class Solution
{
    static void password(String n, int len)
    {
        if(n.length()==len)
        {
            System.out.print(n+" ");
            return;
        }
        else
        {
            for(char c='1'; c<='9'; c++)
            {
                password(n+c, len);
            }
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of digits");
        int len = sc.nextInt();
        System.out.println("All possible numerical passwords are :");
        password("", len);
    }
    

}