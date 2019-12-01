/*
LC-107: Binary Tree Level Order Traversal II
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null) {
            return list;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()) {
            List<TreeNode> levelElems = popAll(stack);
            List<Integer> vals = new ArrayList<Integer>();
            for(TreeNode node: levelElems) {
                if(node.left != null) {
                    stack.push(node.left);
                }
                if(node.right != null) {
                    stack.push(node.right);
                }
                vals.add(node.val);
            }
            list.add(0, vals);
        }
        return list;
    }
    
    List<TreeNode> popAll(Stack<TreeNode> stack) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        while(!stack.isEmpty()) {
            list.add(0, stack.pop());
        }
        return list;
    }
}
