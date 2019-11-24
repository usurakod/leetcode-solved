/* Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
********************************************************************************************************************************/

class Solution {
    int count=0;
    public int maxDepth(TreeNode root) {        
        if(root == null){
            return count;
        }
       int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1; 
    }
}
