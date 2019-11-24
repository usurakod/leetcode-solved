/* Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest.  You may return the result in any order.
Example 1:
Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]


**************************************************************************************************************************
*/
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Set<Integer> deleteList = new HashSet<>();
        for(int a : to_delete){
            deleteList.add(a);
        }
        root = delete(root,list,deleteList);
        if(root != null) list.add(root);
        return list;
        
    }
    public TreeNode delete(TreeNode root ,List<TreeNode> list, Set<Integer> deleteList){
        if(root == null){
            return null;
        }
        if(root.left != null){
            root.left = delete(root.left,list,deleteList);
        }
        if(root.right != null){
            root.right = delete(root.right,list,deleteList);
        }
        if(deleteList.contains(root.val)){
            if(root.left != null){
                list.add(root.left);
            }
            if(root.right != null){
                list.add(root.right);
            }
            root =null;
        }
        return root;
    }
}
