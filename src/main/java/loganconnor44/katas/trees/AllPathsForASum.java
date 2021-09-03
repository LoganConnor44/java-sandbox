package loganconnor44.katas.trees;

import java.util.*;

public class AllPathsForASum {
    public List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        this.findPathsRecursive(root, sum, currentPath, allPaths);
        return allPaths;
    }
    public void findPathsRecursive(TreeNode currentNode, int sum, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (currentNode == null) {
            return;
        }

        currentPath.add(currentNode.val);

        if (currentNode.val == sum && currentNode.left == null && currentNode.right == null) {
            allPaths.add(new ArrayList<Integer>(currentPath));
        } else {
            this.findPathsRecursive(currentNode.left, sum - currentNode.val, currentPath, allPaths);
            this.findPathsRecursive(currentNode.right, sum - currentNode.val, currentPath, allPaths);
        }

        currentPath.remove(currentPath.size() - 1);
    }
}
