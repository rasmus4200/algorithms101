package challenges.binaryTrees;

public class CustomBinaryTree {

    public CustomBinaryTreeNode root;

    public CustomBinaryTree(int key) {
        root = new CustomBinaryTreeNode(key);
    }

    public void add(CustomBinaryTreeNode parent, CustomBinaryTreeNode child, String orientation) {
        if(orientation == "left") {
            parent.left = child;
        }
        if(orientation == "right") {
            parent.right = child;
        }
    }

    public int countPathsWithSum(int targetSum) {
        int paths = root.key;
        paths += countPathsWithSum(root, targetSum);
        return paths;
    }

    private int countPathsWithSum(CustomBinaryTreeNode root, int targetSum) {
        return 0;
    }

    // Number of paths with this sum starting from this node
    private int countPathsWithSumFromNode(CustomBinaryTreeNode node, int targetSum, int currentSum) {
        return 0;
    }

}

