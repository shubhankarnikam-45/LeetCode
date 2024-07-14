class Solution {

    public int findSum(int mat[][], int r, int c)
    {
        int sum = mat[r+1][c+1]; //middle element of hour glass.

        for(int i=0; i<3; i++)
        {
            sum+=mat[r][c+i];
            sum+=mat[r+2][c+i];
        }

        return sum;
    }
    public int maxSum(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;

           int ans = -1;
        
        //traversing in 2d array.
        for(int i=0; i<m-2; i++)
        {
            for(int j=0; j<n-2; j++)
            {
                //first sum.
                int total = findSum(mat, i, j);
                ans  = Math.max(ans, total);
            }
        }
        
        return ans;
    }
}