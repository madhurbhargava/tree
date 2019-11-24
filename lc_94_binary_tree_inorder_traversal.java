/** LC-94: Binary Tree Inorder traversal
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //Inorder traverses first the left child, then the parent and lastly the right child
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) {
            return list;
        }
        
        Dequeue<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            
            stack.push(node.right);
            stack.push(node);
            stack.push(node.left);
            
            node = stack.pop();
            if(node != null) {
                list.add(node.val);
            }
        }
        
        return list;
    }
}
