/** LC-662 Max width of binary tree
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<List<TreeNode>> queue = new LinkedList<>();
        List<TreeNode> list = new ArrayList<>();
        List<List<TreeNode>> levelList = new ArrayList<>();
        list.add(root);
        queue.add(list);
        
        while(!queue.isEmpty()) {
            List<TreeNode> interimList = new ArrayList<>();
            List<TreeNode> level = queue.remove();
            levelList.add(level);

            for(TreeNode node: level) {
                if(node.left != null) {
                    interimList.add(node.left);
                } else {
                    interimList.add(new TreeNode(Integer.MIN_VALUE));
                }

                if(node.right != null) {
                    interimList.add(node.right);
                } else {
                    interimList.add(new TreeNode(Integer.MIN_VALUE));
                }
            }

            interimList = trimList(interimList);
            if(isValidList(interimList)) {
                queue.add(interimList);
            }
        }
        
        int width = maxWidth(levelList);
        return width;
    }
    
    private int maxWidth(List<List<TreeNode>> list) {
        int maxSize = Integer.MIN_VALUE;
        for(List<TreeNode> level : list) {
            if(level.size() > maxSize) {
                maxSize = level.size();
            }
        }
        return maxSize;
    }
    
    private List<TreeNode> trimList(List<TreeNode> list) {
        for(int i = 0; i < list.size();) {
            TreeNode node = list.get(i);
            if(node.val != Integer.MIN_VALUE) {
                break;
            } else {
                list.remove(i);
                i = 0;
            }
        }

        for(int i = list.size() - 1; i > 0;) {
            TreeNode node = list.get(i);
            if(node.val != Integer.MIN_VALUE) {
                break;
            } else {
                list.remove(i);
                i = list.size() - 1;
            }
        }

        return list;
    }
    
    private boolean isValidList(List<TreeNode> list) {
        if(list.isEmpty()) {
            return false;
        }
        
        boolean isValid = false;
        
        for(TreeNode node : list) {
            if(node.val != Integer.MIN_VALUE) {
                return true;
            }
        }
        
        return isValid;
    }
}
