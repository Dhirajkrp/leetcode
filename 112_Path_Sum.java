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

    static boolean flag = false;
    static void preOrder(TreeNode root ,int target ,int currentVal ){

       if(root == null) return;

       currentVal = currentVal + root.val;
        if(currentVal == target && root.left ==null && root.right == null){
           Solution.flag = true;
            return;
        } 
 

        preOrder(root.left , target , currentVal);
        preOrder(root.right , target , currentVal );
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        Solution.flag = false;
        if(root == null ) return false;
        preOrder(root , targetSum , 0);
        return Solution.flag;
        
    }
}