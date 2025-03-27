class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        //here we store the total count of subaray.
        int count = 0;

        //length of array.
        int n = nums.length;

        //creating hashmap to store the <remainder, countOfRemainder>
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        //to store the current sum.
        int sum = 0;

        for(int i=0; i<n; i++)
        {
            //each we sum to current element.
            sum += nums[i];

            //remainder
            int remainder = sum % k;

            //if remainder is negative 
            // convert to positve (0 <= remainder < k)
            if(remainder < 0) remainder +=k;

            //if in hashmap current key is present then it's freq added to count variable.
            if(map.containsKey(remainder)  == true) count += map.get(remainder);
            
            //each time we put frequency of remainder.
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        //at last we just return the answer.
        return count;
    }
}