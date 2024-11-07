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
    public TreeNode findInvert(TreeNode root)
    {
        if(root == null) return null;

        TreeNode left = findInvert(root.left);
        TreeNode right = findInvert(root.right);
        TreeNode temp = root.right;

        root.right = left;
        root.left = right;

        return root;
    }
    public TreeNode invertTree(TreeNode root) {
        
        if(root == null) return null;
        return findInvert(root);
    }
}