/** LC-145 - Binary tree postorder traversal(Iterative)
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) {
            return list;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(0, node.val);
            if(node.left != null) {
                stack.push(node.left);
            }
        
            if(node.right != null) {
                stack.push(node.right);
            }
        }
        
        return list;
    }
}
