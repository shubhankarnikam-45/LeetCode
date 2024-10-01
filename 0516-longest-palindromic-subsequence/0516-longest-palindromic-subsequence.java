class Solution {
    public int fun(int left, int right, String s, int dp[][])
    {
        //base case.
        if(left == right) return 1;
        if(left > right) return 0;

        if(dp[left][right] != -1) return dp[left][right];

        if(s.charAt(left) == s.charAt(right))
        {
            return dp[left][right] = 2 + fun(left + 1, right - 1, s, dp);
        }
        
        return dp[left][right] = Math.max(fun(left + 1, right, s, dp), fun(left, right - 1, s, dp));


    }
    public int longestPalindromeSubseq(String s) {
        
        int m = s.length();
        int dp[][] = new int[m][m];
        // for(int arr[] : dp) Arrays.fill(arr, -1);

        // return fun(0, m - 1, s, dp); 


        //TABULATION.
        // for(int i=0; i<m ;i++)
        // {
        //     for(int j=0; j<m; j++)
        //     {
        //         if(i == j) dp[i][j] = 1;
        //     }
        // }


        for(int left = (m - 1); left >= 0; left--)
        {
            for(int right = 0; right <m; right++)
            {

                if(left == right) dp[left][right] = 1;
                else if(left > right) dp[left][right] = 0;
                else
                {
                        if(s.charAt(left) == s.charAt(right))
                        {
                                dp[left][right] = 2 + dp[left + 1] [right - 1];
                        }
                        else
                        dp[left][right] = Math.max(dp[left + 1] [right] , dp[left][right - 1] );
                }

            }
        }

        return dp[0][m - 1];
    }
}