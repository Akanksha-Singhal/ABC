### Vowel And Consonant Substrings!

#### Source :: https://www.interviewbit.com/old/problems/vowel-and-consonant-substrings/

Given a string A consisting of lowercase characters.
You have to find the number of substrings in A which starts with vowel and end with consonants or vice-versa.
Return the count of substring modulo 10<sup>9</sup> + 7

>Input 1:
>A = "aba"
>Output 1:
> 2
>Explanation 1:
> Substrings of S are : [a, ab, aba, b, ba, a] Out of these only 'ab' and 'ba' satisfy the condition 
 for special Substring. So the answer is 2.


 Approach :: Time :: O(n) Space :: O(1)

  - count the no of vowels = n_vowels
  - count the no of Consonants = n_cons
  - 
  - choose one vowel and one consonant 
  - they are arranged in one fixed pattern only ( as per their relative arrangement )
    ( <sup>n_vowels</sup>C <sub>1</sub>) * ( <sup>n_cons</sup>C <sub>1</sub>)


 ```java
 public class Solution {    
    
    public int solve(String str) {
        
        long mod = (long)1e9+7;
        
        char ch[] = str.toCharArray();
        long vowel = 0, consonant = 0;

        for(int i=0; i<ch.length; i++)
        {
            if(ch[i]=='a' || ch[i]=='e' || ch[i]=='i' || ch[i]=='o' || ch[i]=='u')
                vowel++;
            else
                consonant++;
        }
        return (int)((vowel*consonant)%(mod));
    }
}
 ```