class Solution {
    public int missingNumber(int[] a) {

        int N = a.length;
        //loop from 1 to n and then check in array.
        //this is brute force approach.
        for(int i=0; i<=N; i++)
        {
            int j = 0;
            for(;j<a.length; j++)
            {
                if(a[j] == i) break;
            }

            if(j == a.length) return i;
        }

        return -1;
    }
}