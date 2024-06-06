import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    // List that stores the final answer.
    List<List<Integer>> ans = new ArrayList<>();

    public void subsetWithDupHelper(int[] nums, int idx, List<Integer> al) {
        // Add the current subset to the answer list.
        ans.add(new ArrayList<>(al));

        for (int i = idx; i < nums.length; i++) {
            // Skip duplicates.
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }

            // Add the current element to the subset.
            al.add(nums[i]);
            // Recurse with the next element.
            subsetWithDupHelper(nums, i + 1, al);
            // Backtrack by removing the last element added.
            al.remove(al.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Sort the array to handle duplicates.
        Arrays.sort(nums);

        // Create an empty list to start with.
        List<Integer> al = new ArrayList<>();

        // Call the helper function to generate subsets.
        subsetWithDupHelper(nums, 0, al);

        // Return the list of subsets.
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {1, 2, 2};
        System.out.println(sol.subsetsWithDup(nums1));

        int[] nums2 = {0};
        System.out.println(sol.subsetsWithDup(nums2));
    }
}
