import java.lang.*;
import java.util.*;

class SumOfDigits
{
    // 35 -> 8
    // 119 -> 11

    public static int sum_of_digits(int n)
    {
        //base case
        if(n==0)  
            return 0;

        // recursion(remaining number) + last digit
        return sum_of_digits(n/10) + (n%10);
    }

    public static void main(String args[])
    {
        System.out.println("Enter the Number");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int res= sum_of_digits(n);
        System.out.println(res);

        sc.close();

    }
    
}