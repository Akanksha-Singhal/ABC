import java.util.*;
import java.lang.*;

class Solution
{
    static int binary(int n, int num, char lastDigit)
    {
        if(n>num)
            return 0;
        if(n==num)
            return 1;

        int count = 1;
        if(lastDigit == '1' && n!=0)
            count += binary(n<<1, num, '0');
        else
        {
            if(n!=0)
                count += binary(n<<1, num, '0'); //Binary(n) + '0'
            count+=binary((n<<1)+1, num, '1');   // Binary(n) + '1'
        }
    return count;
    }
    
    static int findIntegers(int n) {

          return binary(0, n, '0');
        
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();
        long res = findIntegers(n);
        System.out.println(res);
    }
}