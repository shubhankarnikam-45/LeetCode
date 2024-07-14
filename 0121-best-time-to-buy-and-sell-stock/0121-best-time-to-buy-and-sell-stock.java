class Solution {
    public int maxProfit(int[] prices) {
        

        int n = prices.length;

        int msf = prices[0];

        int a = 0;

        for(int i=1;i< n; i++)
        {
            //current.
            int ce = prices[i];

            if(ce > msf)
            {
                a  = Math.max(a, ce - msf);
            }
            else if(ce < msf)
            {
                msf = ce;
            }
        }

        return a;
    }
}