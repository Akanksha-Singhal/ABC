import java.util.*;
import java.lang.*;

class Solution
{
    public static int gcd(int a, int b)
    {
        if(a==0)
            return b;

        return gcd(b%a, a);
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the two numbers");
        int a = sc.nextInt();
        int b = sc.nextInt();

        int res = gcd(a, b);

        System.out.println("gcd("+a+","+b+") = "+ res);

    }
}