//TC : o(n)
//SC : o(n)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class SerializeAndDeserializeBinaryTree {
    // Using BFS
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode currNode = q.poll();
            if (currNode == null) {
                sb.append('#');
            } else {
                sb.append(currNode.val);
                q.add(currNode.left);
                q.add(currNode.right);
            }
            sb.append(',');
        }
        System.out.print(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;
        String[] strArr = data.split(",");
        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(strArr[i]));
        i++;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode currNode = q.poll();
            if (!strArr[i].equals("#")) {
                currNode.left = new TreeNode(Integer.parseInt(strArr[i]));
                q.add(currNode.left);
            }
            i++;
            if (!strArr[i].equals("#")) {
                currNode.right = new TreeNode(Integer.parseInt(strArr[i]));
                q.add(currNode.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));