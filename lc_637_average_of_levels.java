/*
LC-637: Average of Levels in Binary Tree
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<Double>();
        if(root == null) {
            return averages;
        }
        List<List<TreeNode>> levels = findAllLevels(root);
        for(List list: levels) {
            double avg = findAverage(list);
            averages.add(avg);
        }
        return averages;
    }
    
    List<List<TreeNode>> findAllLevels(TreeNode root) {
        List<List<TreeNode>> master = new ArrayList<List<TreeNode>>();
        List<TreeNode> list = new ArrayList<TreeNode>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()) {
            list = fullPop(stack);
            for(TreeNode n:list) {
                if(n.left != null) {
                    stack.push(n.left);
                }
                if(n.right != null) {
                    stack.push(n.right);
                }
            }
            master.add(list);
        }
        return master;
    }
    
    List<TreeNode> fullPop(Stack<TreeNode> stack) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        while(!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
    
    double findAverage(List<TreeNode> list) {
        long sum = 0;
        for(TreeNode node : list) {
            sum = sum + node.val;
        }
        return ((double)sum/(double)list.size());
    }
}
