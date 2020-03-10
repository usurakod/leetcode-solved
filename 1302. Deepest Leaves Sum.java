/* Given a binary tree, return the sum of values of its deepest leaves.
 

Example 1:Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15
****************************************************************************************/

class Solution {
       int  maxSum = 0; 
       int  maxLevel = -1;
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;
        helper(root, 0);
        return maxSum;
    }
    
    
    public void helper(TreeNode root, int level){
        if(root == null) return;
        
        if(root.left == null && root.right == null){
            if(maxLevel < level){
                maxLevel = level;
                maxSum = root.val;
            }
            else if(maxLevel == level){
                maxSum  += root.val;
            }
        }
        helper(root.left, level+1);
        helper(root.right,level+1);
    }
}
