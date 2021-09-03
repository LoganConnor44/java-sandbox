package loganconnor44.katas.trees;

public class BinaryTreePathSum {
    public boolean hasPath(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }
        return this.hasPath(root.left, sum - root.val) || this.hasPath(root.right, sum - root.val);
    }
}
