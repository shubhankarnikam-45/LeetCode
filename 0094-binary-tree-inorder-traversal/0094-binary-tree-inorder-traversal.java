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
    public List<Integer> inorderTraversal(TreeNode root) {
         //arraylist to store the answer.
        List<Integer> ans = new ArrayList<>();
        
        TreeNode curr = root;
        
        while(curr != null)
        {
            if(curr.left == null)
            {
                ans.add(curr.val);
                //going to right.
                curr = curr.right;
            }
            else
            {
                //right to left subtree almost right.
                TreeNode leftSubtree  = curr.left;
                
                while(leftSubtree.right != null) 
                {
                    leftSubtree = leftSubtree.right;
                }
                
                //making the thread.
                leftSubtree.right = curr;
                
                //store this current in the temp 
                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }
        
        return ans;
    }
}