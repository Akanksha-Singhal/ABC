import java.util.*;
import java.lang.*;

class Solution
{
    public static long fact(int n)
    {
        if(n==1||n==0)
            return 1;
        return n * fact(n-1);        
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();
        long res = fact(n);
        System.out.println(res);
    }
}