class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();

        for(int i=0; i<nums.length; i++)
        {

            if(pqueue.size() < k)
            {   
                pqueue.add(nums[i]);
            }
            else
            {
                if(pqueue.peek() < nums[i])
                {
                    //pop.
                    pqueue.remove();
                    pqueue.add(nums[i]);
                }
            }
        }

        return pqueue.peek();
    }
}