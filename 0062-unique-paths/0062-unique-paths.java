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

        int dp[] = new int[n];
        dp[n-1] = 1;

        for(int row = m-1; row>=0; row --)
        {
        
            int temp []= new int[n];
            if( row == m-1)
            temp[n-1] = 1;

            for(int col = n-1; col>=0; col--)
            {
                int down = (row + 1 < m )?(dp[col]):(0);
                int right = (col + 1 < n)?(temp[col + 1]):(0);

                if( ! (row ==  m-1 && col == n-1))
                temp[col] = down + right;
            }

            dp = temp;
        }

        return dp[0];
    }
}