class Solution {

     public int fun(int i, int j,  int mat[][], int dp[][])
    {
        //base case.
        if(i < 0 || j < 0) return 0;

        //if obstacle.
        if(mat[i][j] == 1) return 0;

        if(i == 0 && j == 0) return 1;

        if(dp[i][j] != -11) return dp[i][j];

        // int left = (j-1 >= 0)?( fun(i, j-1, mat)):(0);
        // int up = (i-1 >= 0)?(fun(i-1, j, mat)):(0);

         int left = fun(i, j-1, mat, dp);
        int up =  fun(i-1, j, mat,dp);

        return dp[i][j] = left + up;
        
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int n = obstacleGrid.length;
        int m  = obstacleGrid[0].length;

         int dp[][] = new int[n][m];
         
        for(int arr[] : dp)
        {
            Arrays.fill(arr, -11);
        } 

        // return fun(n-1, m-1, obstacleGrid, dp);

        if(obstacleGrid[n-1][m-1] == 1) return 0;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {

                if(i == 0 && j == 0) 
                {
                    dp[i][j] = 1; 
                    continue;
                }
                
                int left = (j-1 >= 0 && obstacleGrid[i][j-1] != 1)?( dp[i][j-1]):(0);
                int up = (i-1 >= 0 && obstacleGrid[i-1][j] != 1)?(dp[i-1][j]):(0);

                dp[i][j] = left + up;
            }
        }

        return dp[n-1][m-1];
    }
}