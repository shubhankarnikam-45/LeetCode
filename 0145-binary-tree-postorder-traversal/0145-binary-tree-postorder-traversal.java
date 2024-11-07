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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        //if root is null.
        if(root == null) return ans;

        //creating two stack.
        Stack<Integer> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack2.push(root);

        while(! stack2.isEmpty())
        {
            //pop.
            TreeNode popElement = stack2.pop();

            //adding to arraylist.
            stack1.push(popElement.val);

            //firt adding left child then right
            if(popElement.left != null)
            {
                stack2.push(popElement.left);
            }

            if(popElement.right != null)
            {
                stack2.push(popElement.right);
            }
        }

        while(stack1.size() > 0)
        {
            ans.add(stack1.pop());
        }

        return ans;
    }
}