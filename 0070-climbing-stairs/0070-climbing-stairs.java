class Solution {
    public int climbStairsHelper(int n, int dp[]) {
        
        if(n == 0) return 1;
        if(n == 1) return 1;

        if(dp[n] != 0) return dp[n];

        dp[n] = climbStairsHelper(n-1, dp) + climbStairsHelper(n-2,dp);
        return dp[n];
    }

    public int climbStairs(int n) {
        
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        return climbStairsHelper(n, dp);
        
        
    }
    
}