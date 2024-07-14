class Solution {

    // public int findSum(int mat[][], int r, int c)
    // {
    //     int sum = mat[r+1][c+1]; //middle element of hour glass.

    //     for(int i=0; i<3; i++)
    //     {
    //         sum+=mat[r][c+i];
    //         sum+=mat[r+2][c+i];
    //     }

    //     return sum;
    // }
    public int maxSum(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;

           int ans = -1;
        
        //traversing in 2d array.
        for(int r=0; r<m-2; r++)
        {
            for(int c=0; c<n-2; c++)
            {
                //first sum.
                int total = mat[r][c+0] + mat[r][c+1] + mat[r][c+2]+ mat[r+1][c+1] + mat[r+2][c+0] + mat[r+2][c+1] + mat[r+2][c+2];
                ans  = Math.max(ans, total);
            }
        }
        
        return ans;
    }
}