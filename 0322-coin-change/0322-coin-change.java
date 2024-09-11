class Solution {

    public int fun(int coins[], int amt, int dp[][])
    {
        if(amt == 0) return 0;
        if(amt < 0) return 1000000;

        int mini = 1000000;
        for(int i=0; i<coins.length; i++)
        {

            if(coins[i] <= amt)
            {
                if(dp[i][amt] != -1) mini = dp[i][amt];
                else mini = Math.min(mini, 1 + fun(coins, amt - coins[i], dp));
            }

            dp[i][amt] = mini;
           
        }

        return mini;
    }
    public int coinChange(int[] coins, int amount) {
        
        int dp[][] = new int[coins.length][amount+1];

        for(int arr[] : dp) Arrays.fill(arr, -1);

        int a = fun(coins, amount, dp);
        if(a == 1000000) return -1;
        return a;
    }
}