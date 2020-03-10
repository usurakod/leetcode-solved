/* Given the root of a binary tree, find the maximum value V for which there exists different nodes A and B where V = |A.val - B.val| and A is an ancestor of B.

(A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an ancestor of B.)

Input: [8,3,10,1,6,null,14,null,null,4,7,13]
Output: 7
Explanation: 
We have various ancestor-node differences, some of which are given below :
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.

****************************************************************************************************************************************************************/

class Solution {
    int maxDiff = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        if(root != null) findAncestorDiff(root, root.val, root.val);
        return maxDiff = maxDiff > Integer.MIN_VALUE ? maxDiff : 0 ;
    }
    
    public void findAncestorDiff(TreeNode root, int min , int max){
      
        if(max - min > maxDiff) maxDiff = max-min;
        
        if(root.left != null)
            findAncestorDiff(root.left, Math.min(min, root.left.val), Math.max(max, root.left.val));
        if(root.right != null)
            findAncestorDiff(root.right, Math.min(min, root.right.val), Math.max(max, root.right.val));

    }
    
    
}
