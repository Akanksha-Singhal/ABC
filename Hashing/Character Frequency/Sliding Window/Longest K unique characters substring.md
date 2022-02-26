## Longest K unique characters substring 

Source :: https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1/

Given a string you need to print the size of the longest possible substring that has exactly K unique characters. 
If there is no possible substring then print -1.

Example 1:
```
Input:
S = "aabacbebebe", K = 3
Output: 7
Explanation: "cbebebe" is the longest substring with K distinct characters.
```

Example 2:
```
Input: 
S = "aaaa", K = 2
Output: -1
Explanation: There's no substring with K distinct characters.
```


```java
int longestSubstrWithKUnique(String S, int k){
     
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        // (char, lasIndex where char was found)
        char ch[] = S.toCharArray();
        int maxlen =-1;
        int ws = 0, we=0;
       
        for(we=0;we<ch.length;we++) 
        {	// increase the freqency of the current character
            hm.put(ch[we], hm.getOrDefault(ch[we], 0)+1); 

            // as soon as the no of Characters are more than k
        	while(hm.size()> k) 
        	{
        	    // dec the freq of ws char  till one of the elements reaches a 0 frequency
        	    //and move the window forward
        	    
        		hm.put(ch[ws], hm.get(ch[ws])-1);
        		if(hm.get(ch[ws]) == 0)
        			hm.remove(ch[ws]);
        		ws++;
        	}
            
            //
        	maxlen = hm.size() == k ? Math.max(maxlen , we-ws+1) : maxlen ;
        }
        return maxlen;
    }
```