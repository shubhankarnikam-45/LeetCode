class Solution {

    public int checkPalindrome(int i, int j, String s, int dp[][])
    {
        //base case.
        if(i > j || i == j) return 1;

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == s.charAt(j)) 
            return dp[i][j] = checkPalindrome(i+1, j-1, s, dp);

        return dp[i][j] =  0;
    }
    public String longestPalindrome(String s) {
        
        //length of string.
        int n = s.length();
        
        int dp[][] = new int[1001][1001];

        for(int arr[] : dp) Arrays.fill(arr, -1);

        //the answer string we later return.
        String ans = "";
        for(int i=0; i<n; i++)
        {
            for(int j=i; j<n; j++)
            {
                if(checkPalindrome(i, j, s, dp) == 1)
                {
                    String candidate = s.substring(i, j + 1);
                    
                    //check.
                    if(ans.length() < candidate.length())
                    {
                        ans = candidate;
                    }
                }
            }
        }

        return ans;
    }
}