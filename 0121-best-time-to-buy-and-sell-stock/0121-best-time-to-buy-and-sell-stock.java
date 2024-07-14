class Solution {
    public int maxProfit(int[] prices) {

        //size.
        int n = prices.length;

        //suffixMax
        int suffixMaxArr[]  = new int[n];

        int max = Integer.MIN_VALUE;

        //moving in backward direction and create the prefix aray.
        for(int i=n-1; i>=0; i--)
        {
            if(prices[i] > max)
            {
                max = prices[i];
            }
            suffixMaxArr[i] = max;

        }

        //variable that store the maximum profit.
        int maxProfit = Integer.MIN_VALUE;
        //moving in forward direction and calculate the max
        for(int i=0; i<n; i++)
        {
            int diff = suffixMaxArr[i] - prices[i];
            maxProfit = Math.max(maxProfit, diff);
        }

        //return answer.
        //final answer.
        return maxProfit;
    }
}