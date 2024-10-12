class Solution {

    public  int fun(int ind1, int ind2, String s, String t, int dp[][])
    {
        //base case.
        if(ind2 < 0) return ind1 + 1;
        if(ind1 < 0 ) return ind2 + 1;
        
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        //if character mathc.
        if(s.charAt(ind1) == t.charAt(ind2))
        {
            return dp[ind1][ind2] = 0 + fun(ind1 - 1, ind2 - 1, s, t, dp);
        }
        else
        {
return dp[ind1][ind2] = 1 + Math.min(fun(ind1 , ind2 - 1, s, t , dp), Math.min(fun(ind1 - 1,ind2 - 1, s, t, dp), fun(ind1 - 1 , ind2, s, t, dp)));
        }
    }

    public int minDistance(String s, String t) {
        int n = s.length();
        int m = t.length();

        int dp[][] = new int[n + 1][m + 1];
        
        //first we wriet down the base cases.
        for(int ind1 = 1; ind1 <=n; ind1++) dp[ind1][0] = ind1;
        for(int ind2 = 1; ind2 <=m; ind2++) dp[0][ind2] = ind2;

        //tabulation.
        for(int ind1 = 1; ind1 <=n; ind1++)
        {
            for(int ind2 = 1; ind2<=m; ind2++)
            {
                //if character matches.
                if(s.charAt(ind1 - 1) == t.charAt(ind2 - 1))
                {
                    dp[ind1][ind2] = dp[ind1 - 1][ind2 - 1];
                }
                else
                {
                    dp[ind1][ind2] =  1 + Math.min(dp[ind1][ind2-1], Math.min(dp[ind1 - 1][ind2 - 1], dp[ind1 -1 ][ind2]));
                }
            }
        }

        return dp[n][m];
    }
}