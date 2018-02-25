package challenges.binaryTrees;

public class SimpleBinarySearchTree {

    class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
        }
    }

    Node root;

    public SimpleBinarySearchTree() {
        root = null;
    }

    public void insert(int key) {
        root = insertItem(root, key);
    }

    public Node insertItem(Node node, int key) {

        Node newNode = new Node(key);

        if (node == null) {
            node = newNode;
            return node;
        }

        if (key < node.key) {
            node.left = insertItem(node.left, key);
        } else {
            node.right = insertItem(node.right, key);
        }

        return node;
    }

    public String getOrder() {
        StringBuilder sb = new StringBuilder();
        preOrderTraversal(root, sb);
        return sb.toString();
    }

    public void printPreOrderTraversal() {
        preOrderTraversal(root, null);
    }

    private void preOrderTraversal(Node node, StringBuilder sb) {
        if (node != null) {

            if (sb != null) {
                sb.append(node.key);
            }
            preOrderTraversal(node.left, sb);
            preOrderTraversal(node.right, sb);
        }
    }

    //
    // Utils
    //
    public void prettyPrint() {
        // Hard coded print out of binary tree depth = 3

        int rootLeftKey = root.left == null ? 0 : root.left.key;
        int rootRightKey = root.right == null ? 0 : root.right.key;

        int rootLeftLeftKey = 0;
        int rootLeftRightKey = 0;

        if (root.left != null) {
            rootLeftLeftKey = root.left.left == null ? 0 : root.left.left.key;
            rootLeftRightKey = root.left.right == null ? 0 : root.left.right.key;
        }

        int rootRightLeftKey = 0;
        int rootRightRightKey = 0;

        if (root.right != null) {
            rootRightLeftKey = root.right.left == null ? 0 : root.right.left.key;
            rootRightRightKey = root.right.right == null ? 0 : root.right.right.key;
        }

        System.out.println("     " + root.key);
        System.out.println("   /  \\");
        System.out.println("  " + rootLeftKey + "    " + rootRightKey);
        System.out.println(" / \\  / \\");
        System.out.println(rootLeftLeftKey + "  " + rootLeftRightKey + " " + rootRightLeftKey + "   " + rootRightRightKey);
    }
}