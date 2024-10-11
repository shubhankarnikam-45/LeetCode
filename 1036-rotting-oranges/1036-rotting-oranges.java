class Pair
{
    int i;
    int j;

    Pair(int i, int j)
    {
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        //created visited arrary
        boolean vis[][] = new boolean[m][n];

        //created queue.
        Queue<Pair> queue = new ArrayDeque<>();

        //traverse and collect the rotten orange.
        int toCompare = 0;

        for(int i=0; i<m ;i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 2)
                {
                    queue.add(new Pair(i, j));
                }
                else if(grid[i][j] == 1) toCompare++;
            }
        }

        int temp = 0;

        int delRow[] = {0, 1, 0, -1};
        int delCol[] = {1, 0, -1, 0};

        int count = 0;

        while(queue.size() > 0)
        {
            int size = queue.size();

            for(int idx = 1; idx <= size; idx++)
            {
                if(idx == 1) count++;

                //remove the element in queue.
                Pair pair = queue.remove();

                int i = pair.i;
                int j = pair.j;

                for(int p = 0; p < 4; p++)
                {
                    int ti = i + delRow[p];
                    int tj = j + delCol[p];

                    if(ti >= 0 && tj >=0 &&  ti < m && tj < n && vis[ti][tj] != true && grid[ti][tj] != 0 && grid[ti][tj] != 2)
                    {
                        temp++;
                        vis[ti][tj] = true;
                        queue.add(new Pair(ti, tj));
                    }
                }
            }
        }

        if(toCompare != temp) return -1;
        if(count == 0) return count;
        return count - 1;
    }
}