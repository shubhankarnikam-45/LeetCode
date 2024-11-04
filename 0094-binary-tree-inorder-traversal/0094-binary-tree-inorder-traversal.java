
class Solution {
     public void inorder(TreeNode root, List<Integer> ans)
    {
        //base case.
        if(root == null) return;

       
        
        inorder(root.left, ans);
         ans.add(root.val);
        inorder(root.right, ans);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }
}