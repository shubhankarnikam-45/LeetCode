class Solution {

    //logic for swap
    public void swap(int arr[], int left, int right)
    {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    //logic for reverse.
    public void reverse(int arr[], int left, int right)
    {
        while(left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }
    public void rotate(int[] nums, int k) {
        
        //size of array.
        int n = nums.length;

        k = k % n;
       int middleIndex = n - k;

       reverse(nums, 0, middleIndex - 1);
       reverse(nums, middleIndex, n-1);
       reverse(nums, 0, n-1);

        //TC : O(k * n)
    }
}