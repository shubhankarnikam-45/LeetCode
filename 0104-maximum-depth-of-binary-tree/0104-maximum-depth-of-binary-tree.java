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
    public int maxDepth(TreeNode root) {
        
           int level = 0;
        
        if(root == null) return level;
        //created queue.
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

     
        while(queue.size() > 0)
        {
            int size = queue.size();

            for(int i=1; i<=size; i++)
            {
                TreeNode r = queue.remove();

                if(r.left != null) queue.add(r.left);
                if(r.right != null) queue.add(r.right);
            }
            level+=1;
        }

        return level;
    }
}