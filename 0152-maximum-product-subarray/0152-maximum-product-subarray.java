class Solution {
    public int maxProduct(int[] nums) {
        
        long prefixSum = 1;
        long suffixSum = 1;

        long ans = Integer.MIN_VALUE;

        int n= nums.length;
        for(int i=0; i<n; i++)
        {
            prefixSum = (prefixSum == 0 || prefixSum < Integer.MIN_VALUE) ? 1 : prefixSum;
            suffixSum = (suffixSum == 0 || suffixSum < Integer.MIN_VALUE) ? 1 : suffixSum;

        
            prefixSum *= nums[i];
            suffixSum *= nums[n-i-1];

            ans = Math.max(ans, Math.max(prefixSum, suffixSum));

        }

        
        return (int) ans;
    }
}