package challenges.binaryTrees;

public class CustomBinaryTree {

    public CustomBinaryTreeNode root;

    public CustomBinaryTree(int key) {
        root = new CustomBinaryTreeNode(key);
    }

    public void add(CustomBinaryTreeNode parent, CustomBinaryTreeNode child, String orientation) {
        if (orientation.equals("left")) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }

    public int countPathsWithSum(int targetSum) {
        return countPathsWithSum(root, targetSum);
    }

    private int countPathsWithSum(CustomBinaryTreeNode root, int targetSum) {
        if (root == null) return 0;

        // Count paths with sum starting from the root
        int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);

        // Try the nodes on the left and the right
        int pathsOnLeft = countPathsWithSum(root.left, targetSum);
        int pathsOnRight = countPathsWithSum(root.right, targetSum);

        return pathsFromRoot + pathsOnLeft + pathsOnRight;
    }

    // Number of paths with this sum starting from this node
    private int countPathsWithSumFromNode(CustomBinaryTreeNode node, int targetSum, int currentSum) {
        if (node == null) return 0;

        currentSum += node.key;

        int totalPaths = 0;
        if (currentSum == targetSum) { // Found a path from the root
            totalPaths++;
        }

        totalPaths += countPathsWithSumFromNode(node.left, targetSum, currentSum);
        totalPaths += countPathsWithSumFromNode(node.right, targetSum, currentSum);
        return totalPaths;
    }

}

