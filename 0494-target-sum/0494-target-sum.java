class Solution {

     public  int fun(int idx, int target, int arr[])
    {
        if(idx == 0)
        {
            if(arr[idx] == 0 && target == 0) return 2;
            if(target - arr[idx] == 0) return 1;
            else if(target + arr[idx] == 0) return 1;
            else return 0;
        }
        int minus = fun(idx -1, target - arr[idx], arr);
        int plus = fun(idx - 1, target + arr[idx], arr);

        return minus + plus;
    }

    public int findTargetSumWays(int[] nums, int target) {
        return fun(nums.length-1, target, nums);
    }
}