package loganconnor44.katas.trees;

public class PathWithGivenSequence {
    public boolean findPaths(TreeNode root, int[] sequence) {
        if (root == null) {
            return sequence.length == 0;
        }

        return this.findPathsRecursive(root, sequence, 0);
    }

    private boolean findPathsRecursive(TreeNode currentNode, int[] sequence, int level) {
        if (currentNode == null) {
            return false;
        }

        if (level > sequence.length || currentNode.val != sequence[level]) {
            return false;
        }

        if (currentNode.left == null && currentNode.right == null && level == sequence.length - 1) {
            return true;
        }

        return this.findPathsRecursive(currentNode.left, sequence, level + 1) || this.findPathsRecursive(currentNode.right, sequence, level + 1);
    }
}
