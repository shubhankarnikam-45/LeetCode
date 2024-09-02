class Solution {

    public boolean fun(int idx, int arr[], int curSum, int sum, int dp[][])
    {
        if(curSum == sum) return true;
        
        //base case.
        if(idx == 0) return curSum+arr[idx] == sum - arr[idx];

        if(dp[idx][curSum] != -1) return dp[idx][curSum] == 1;

        boolean exclude = fun(idx - 1, arr, curSum, sum, dp);
        boolean include = false;
        if(curSum < sum)
        {
            include = fun(idx - 1,arr, curSum + arr[idx], sum - arr[idx], dp);
        }

        int result = (exclude || include) ? (1) : (0);

        dp[idx][curSum] = result;

        return result == 1;
    }
    public boolean canPartition(int[] nums) {

       //first we calculate the overall sum
       int sum = 0;
       for(int i=0; i<nums.length; i++)
       sum+=nums[i];

       int dp[][] = new int[nums.length][sum+1];
       for(int arr[] : dp)
       Arrays.fill(arr, -1);

       return fun(nums.length-1, nums, 0, sum, dp); 
    }
}