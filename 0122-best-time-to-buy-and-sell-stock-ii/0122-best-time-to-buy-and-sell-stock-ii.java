class Solution {
    public int fun(int ind, int buy, int prices[], int dp[][])
    {
        //base case.
        if(ind == prices.length) return 0;

        //if in dp already exists.
        if(dp[ind][buy] != -1) return dp[ind][buy];

        if(buy == 1) //buy
        {
            return dp[ind][buy] = Math.max(-prices[ind] + fun(ind + 1, 0, prices, dp), 0 + fun(ind + 1, 1, prices, dp));
        }
        else //sell
        {
            return dp[ind][buy] =  Math.max(prices[ind] + fun(ind + 1, 1, prices, dp), 0 + fun(ind + 1, 0, prices, dp));
        }
    }
    public int maxProfit(int[] prices) {
        
        //creating dp 2d array to store the duplicate values.
        int n = prices.length;
        int dp[][] = new int[n + 1][2];

        //TABULATION.
        
        //write the base case.
        dp[n][1] = dp[n][0] = 0;

        //travel and solve
        for(int ind = n - 1; ind>=0; ind--)
        {
            for(int buy = 0; buy<=1; buy++)
            {
                if(buy == 1) //buy
                {
                    dp[ind][buy] = Math.max(-prices[ind] + dp[ind + 1][0], 0 + dp[ind + 1][1]);
                }
                else //sell
                {
                    dp[ind][buy] = Math.max(prices[ind] + dp[ind + 1][1], 0 + dp[ind + 1][0]);

                }
            }
        }

      
        return dp[0][1];
    }
}