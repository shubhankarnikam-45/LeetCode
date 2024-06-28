/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void inorderTraversalHelper(TreeNode root, List<Integer> alist )
    {
        if(root == null) return;
        
        inorderTraversalHelper(root.left, alist);
        //add current node.
        alist.add(root.val);

        //going to right.
        inorderTraversalHelper(root.right, alist);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();

        inorderTraversalHelper(root, ans);

        return ans;
    }
}