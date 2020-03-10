/*
Given a binary tree, return the sum of values of nodes with even-valued grandparent. 
(A grandparent of a node is the parent of its parent, if it exists.)

If there are no nodes with an even-valued grandparent, return 0.
Example 1:
Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 18
Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.

*************************************************************************************************************************************/

class Solution {
    int total = 0;
    public int sumEvenGrandparent(TreeNode root) {
        total = helper(root, null,null);
        return total;
    }
    
     public int helper(TreeNode curr, TreeNode parent, TreeNode gParent){
         if(curr == null) return 0;
         int sum =0;
         if(gParent != null && gParent.val %2 == 0){
             sum = curr.val;
         }
         return sum = sum + helper(curr.left,curr,parent) + helper(curr.right,curr,parent);
     }
}
