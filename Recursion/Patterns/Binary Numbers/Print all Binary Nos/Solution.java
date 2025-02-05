import java.util.*;
import java.lang.*;


class Solution
{

    static void binary(String n, int len)
    {
        if(n.length()==len)
            System.out.print(n+ " ");
        else
        {
            // Check the last Character in the Binary Representation of the no.
            char lastChar = ' ';
            if(n.length()!=0)
                lastChar = n.charAt(n.length()-1);

            if(lastChar=='1')
            {
                binary(n+"0", len);
            }
            else
            {
                binary(n+"0", len);
                binary(n+"1", len);
            }
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();
        binary("", n);
        System.out.println();
    }

}