class Solution {

   public boolean fun(int idx, int arr[],  int target, int dp[][])
    {
        
        if(target == 0) return true;   
        
        if(idx == 0) return arr[0] == target;
        
        if(dp[idx][target] != -1) return dp[idx][target] == 1;

        boolean no = fun(idx - 1, arr, target, dp);        
        boolean yes = false;
        if(arr[idx] <= target)
        yes = fun(idx - 1 , arr, target - arr[idx],  dp);

        
        int result = (yes || no) ? (1) : (0);
        dp[idx][target] = result;
        return result == 1;
    }
    public boolean canPartition(int[] nums) {

       //first we calculate the overall sum
       int sum = 0;
       for(int i=0; i<nums.length; i++)
       sum+=nums[i];

       if(sum %2 == 1) return false;

       sum = sum / 2;

       int dp[][] = new int[nums.length][sum+1];
       for(int arr[] : dp)
       Arrays.fill(arr, -1);

       return fun(nums.length-1, nums, sum, dp); 
     
    }
}