class Solution {
    
    public int uniquePathHelper(boolean grid[][], int dp[][], int i, int j, int m , int n)
    {
    
        if(i == m-1 && j == n-1)
        {   
            return 1;
        } 

        if(dp[i][j] != -2) return dp[i][j];


        grid[i][j] = true;
        int down = 0;
        int right = 0;
        if(i + 1 < m && j < n)
            down = uniquePathHelper(grid,dp, i + 1, j, m, n);
        
        if(i < m && j + 1 < n)
            right = uniquePathHelper(grid,dp, i, j + 1, m, n);

        dp[i][j] = down + right;
        grid[i][j] = false;

        return down + right;
    }
    public int uniquePaths(int m, int n) {

        
        
        //creted the 2d array.
        boolean grid[][] = new boolean[m][n];
        int dp[][] = new int[m][n];

        for(int [] arr : dp)
        {
            Arrays.fill(arr, -2);
        }

        dp[0][0] = uniquePathHelper(grid, dp, 0, 0, m, n);

        return dp[0][0];
    }
}