class Solution {
    public int subarraysDivByK(int[] nums, int k) {
       //length of the array.
       int n = nums.length;

       //crating the hashmap.
       HashMap<Long, Integer> map = new HashMap<>();
       map.put(0l, 1);

       //creating variable that stores the sum.
       long sum  = 0;

       //here we store the count.
       int count = 0;

       //traverse array and find answer.
       for(int i = 0; i<n; i++)
       {
            //here we store sum each time of iteration.
            sum += nums[i];

            long remainder = sum % k;
            if (remainder < 0) remainder += k;

            
            if(map.containsKey(remainder) ==  true )
            {
                count += map.get(remainder);
            }

            map.put(remainder, map.getOrDefault(remainder, 0)+1);
       }

       //return the answer.
       return count;

    }
}


