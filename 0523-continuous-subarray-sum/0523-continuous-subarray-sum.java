class Solution {
    public boolean checkSubarraySum(int[] nums, int k) 
    {
        //size of array.
        int n = nums.length;

        //we store the current sum.
        int sum = 0;

        //hashmap.
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        //traverse array.
        for(int i = 0; i<n; i++)
        {
            //store sum each time.
            sum += nums[i];

            //remainder.
            int remainder = sum % k;

            //if in hashmap remainder exists then we return true.
            if(map.containsKey(remainder))
            {
                if(i - map.get(remainder) >=2) return true;

            }
            else
                map.put(remainder, i);
            
            
        }

        //here we reach that means their is not subarray.
        return false;
    }
}