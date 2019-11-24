/* Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42

******************************************************************************************************************************
*/

class Solution {
  class MaxSum{
        int maxSum=Integer.MIN_VALUE;
    }
    
    MaxSum result=new MaxSum();
    
    public int maxPathSum(TreeNode root) {
        max(root);
       return result.maxSum;
    }
    
    private int max(TreeNode root) {
        
     if(root==null){
         return 0;
     }   
        
    int lmax=max(root.left);
    int rmax=max(root.right);   
   
    lmax=lmax<0?0:lmax;
    rmax=rmax<0?0:rmax;
   
  //update result     
   result.maxSum=Math.max(result.maxSum,lmax+rmax+root.val);
        
   //Maximum Sum here     
   return root.val+Math.max(lmax,rmax);  
    }
    

}
