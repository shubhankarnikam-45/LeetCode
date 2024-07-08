class Solution {
    public int search(int[] arr, int key) {
         //define the low and high.
        int low = 0;
        int high = arr.length-1;
        
        while(low <= high)
        {
            //middle element.
            int mid = (low + (high- low)/2);  //to avoid overflow
            
            //if elemnt is found.
            if(arr[mid] == key) return mid;
            
            //left part is sorted or not ?
            if(arr[low] <= arr[mid])
            {
                if(key >= arr[low] && key<=arr[mid])
                {
                    high = mid - 1;
                }
                else
                {
                    low = mid + 1;
                }
            }
            //right part is sorted or not ?
            else if(arr[mid]<=arr[high])
            {
                if(key >= arr[mid] && key<=arr[high])
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid -1;
                }
            }
        }
        
        //if not answer found then we return -1;
        return -1;
    }
}