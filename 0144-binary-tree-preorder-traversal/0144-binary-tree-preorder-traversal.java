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

    public void preorderTraversalHelper(TreeNode root, List<Integer> alist )
    {
        if(root == null) return;
        alist.add(root.val);
        preorderTraversalHelper(root.left, alist);
        //add current node.
        

        //going to right.
        preorderTraversalHelper(root.right, alist);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();

        preorderTraversalHelper(root, ans);

        return ans;

    }
}