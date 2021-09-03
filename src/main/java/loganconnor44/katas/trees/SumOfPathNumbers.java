package loganconnor44.katas.trees;

public class SumOfPathNumbers {
    public int findSumOfPathNumbers(TreeNode root) {
        return this.findSumRecursive(root, 0);
    }

    private int findSumRecursive(TreeNode currentNode, int sum) {
        if (currentNode == null) {
            return 0;
        }
        sum = 10 * sum + currentNode.val;
        if (currentNode.left == null && currentNode.right == null) {
            return sum;
        }
        return this.findSumRecursive(currentNode.left, sum) + this.findSumRecursive(currentNode.right, sum);
    }
}
