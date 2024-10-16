/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
//TC :- O(n)
//SC : O(n)
class BinaryTreeVerticalOrderTraversal {
    // Using BFS
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> q = new LinkedList();
        int min = 0;
        int max = 0;
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> currPair = q.poll();
            TreeNode currNode = currPair.getKey();
            int col = currPair.getValue();
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(currNode.val);
            // Process children
            if (currNode.left != null) {
                q.add(new Pair(currNode.left, col - 1));
                min = Math.min(min, col - 1);
            }

            if (currNode.right != null) {
                q.add(new Pair(currNode.right, col + 1));
                max = Math.max(max, col + 1);
            }
        }

        for (int i = min; i <= max; i++) {
            result.add(map.get(i));
        }

        return result;
    }
}