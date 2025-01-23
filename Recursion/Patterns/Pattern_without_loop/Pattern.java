

import java.lang.*;
import java.util.*;

class Pattern
{ 

    // N, N-5, N-10, N-15, N-20, ..... N-5, N
    public static void pattern_(int n)
    {
        System.out.print(n+ " ,");
        if(n>=0)  //do recursion only for positive values of n
            pattern_(n-5);
        
        if(n>0)  // re-print the same number
            System.out.print(n+" ,");

    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Pattern : n, n-5, n-10, n-15, ...., n-5, n");
        System.out.println("Enter a no");
        int n = sc.nextInt();
    
        pattern_(n);
        sc.close();
    }
}