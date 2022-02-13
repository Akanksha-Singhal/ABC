## Best Time to Buy and Sell Stock II
### Source :: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

```
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. 
However, you can buy it then immediately sell it on the same day.
Find and return the maximum profit you can achieve. 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
```

#### Approach :: Time - O(n) Space - O(1)
```java
class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int maxProfit = 0;
        // find the day on which you can buy
        //i.e. a day where the price is the least
        
        int i=1;         
        while( i <n)
        {   
            // price of the current Buy day should be less than the next day
            while(i<n-1 && prices[i-1] >= prices[i]) 
                i++;
            
            int buyDay = i-1;             
            if(i==n)
                break;
            
            // check for the sellDay         
            // find the day on which you can sell i.e. a day where the price is the max
            // price of the current Sell day should be more than the previous day

            while(i < n && prices[i-1] <= prices[i]) 
                i++;
            int sellDay = i-1;
            int profit = prices[sellDay]-prices[buyDay];
            maxProfit += Math.max(profit, 0);

            i++;
        }
       
        return maxProfit;
        
    }
}
```