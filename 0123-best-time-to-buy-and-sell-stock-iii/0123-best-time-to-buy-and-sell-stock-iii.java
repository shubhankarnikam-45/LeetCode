class Solution {
    public int fun(int ind, int buy, int cnt, int prices[], int dp[][][])
    {
        //base case.
        if(ind == prices.length) return 0;
        if(cnt == 2) return 0;

        //if answe already exists.
        if(dp[ind][buy][cnt] != -1) return dp[ind][buy][cnt];

        int profit = 0;

        if(buy == 1) //buy
        {
            profit = Math.max(-prices[ind] + fun(ind + 1, 0, cnt , prices, dp), 0 + fun(ind + 1, 1, cnt, prices, dp));   
        }
        else //sell
        {
            profit = Math.max(prices[ind] + fun(ind + 1, 1, cnt + 1, prices, dp), 0 + fun(ind + 1, 0, cnt, prices, dp));
        }

        return dp[ind][buy][cnt] = profit;
    }
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