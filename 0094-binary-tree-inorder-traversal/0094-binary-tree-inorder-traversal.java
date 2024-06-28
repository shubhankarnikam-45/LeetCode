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
        
        //creating arraylist that store the answer.
        List<Integer> ans = new ArrayList<>();

        //creating stack 
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(st.size() > 0)
        {
            if(st.size() == 1 && st.peek() == null) break;
            if(st.size() >=2 && st.peek() == null)
            {
                //pop.
                st.pop();

                //pop agaig and added to arraylist.
                TreeNode popElement = st.pop();

                ans.add(popElement.val);

                //going to right.
                st.push(popElement.right);
            }
            else if(st.peek()!= null && st.peek().left != null)
            {
                //push to arraylist.
                st.push(st.peek().left);

            }
            else if(st.peek()!= null && st.peek().left == null)
            {
                //pop.
                TreeNode popElement = st.pop();

                //print.
                ans.add(popElement.val);

                //going to right.
                st.push(popElement.right);
            }
        }

        return ans;
    }
}