class Solution {
    public int fun(int i, int j, int grid[][], int dp[][])
    {
        
        if(i < 0 || j < 0) return 100000;

        if(i == 0 && j == 0) return grid[0][0];

        if(dp[i][j] != -1) return dp[i][j];

        int up = fun(i-1, j, grid, dp);
        int left = fun(i, j-1, grid, dp);

        int candidate = grid[i][j] + Math.min(up, left);

        return dp[i][j] = candidate;
    }
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int dp[][] = new int[m][n];
        for(int arr[] : dp)
        {
            Arrays.fill(arr, -1);
        }

        return fun(m-1, n-1, grid, dp);
    }
}