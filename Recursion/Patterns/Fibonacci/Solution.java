import java.util.*;
import java.lang.*;

class Solution
{
    //fib(0)       = 0;
    //fib(1)       = 1;
    //fib(2) = 0+1 = 1
    //fib(3) = 1+1 = 2
    //fib(4) = 1+2 = 3
    public static long fib(int n)
    {
        //Base Case
        if(n==1 || n==0)
            return n;

        return fib(n-1)+fib(n-2);
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();
        long res = fib(n);
        System.out.println(n+"th Fibonacci no. "+res);
    }

}