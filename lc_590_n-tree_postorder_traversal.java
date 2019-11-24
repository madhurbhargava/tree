/* LC - 590 - N-ary tree postorder traversal (Iterative)
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) {
            return list;
        }
        
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            
            for(Node child : node.children) {
                stack.push(child);
            }
            
            list.add(0, node.val);
        }
        return list;
        
    }
}
