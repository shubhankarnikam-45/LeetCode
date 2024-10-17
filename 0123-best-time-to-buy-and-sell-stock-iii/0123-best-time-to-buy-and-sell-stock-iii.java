class Solution {
    
    public int maxProfit(int[] prices) {
        
        int n = prices.length;

        //creating the 3d dp to optimize this.
        int dp[][][] = new int[n + 1][2][3];
        
      


        for(int ind = n -1; ind >= 0; ind--)
        {
            for(int buy = 0; buy<=1; buy++)
            {
                for(int cap = 1; cap <= 2; cap++)
                {
                    int profit = 0;

                    if(buy == 1) //buy
                    {
                    profit = Math.max(-prices[ind] + dp[ind + 1] [0][cap] , 0 + dp[ind + 1][1][cap]);   
                    }
                    else //sell
                    {
                        profit = Math.max(prices[ind] + dp[ind + 1][1][cap - 1], 0 + dp[ind + 1][0][cap]);
                    }

                    dp[ind][buy][cap] = profit;

                }
            }
        }

        

        return dp[0][1][2];
    }
}