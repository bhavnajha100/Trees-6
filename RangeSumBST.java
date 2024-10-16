//TC : O(n)
//SC : O(n)
class RangeSumBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0;

        int result = 0;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        TreeNode prev = null;

        while (!st.isEmpty()) {
            TreeNode curr = st.peek();
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null && curr.val > low)
                    st.push(curr.left);
                else if (curr.right != null && curr.val < high)
                    st.push(curr.right);
                else {
                    // process
                    if (curr.val >= low && curr.val <= high)
                        result += curr.val;
                    st.pop();
                }
            } else if (curr.left == prev) {
                if (curr.right != null && curr.val < high)
                    st.push(curr.right);
                else {
                    // process
                    if (curr.val >= low && curr.val <= high)
                        result += curr.val;
                    st.pop();
                }
            } else if (curr.right == prev) {
                // process
                if (curr.val >= low && curr.val <= high)
                    result += curr.val;
                st.pop();
            }
            prev = curr;
        }

        return result;

    }
}