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
        if(root == null) {
            root = new Node(key);
        } else {
            insertItem(root, key);
        }
    }

    private void insertItem(Node node, int key) {
        //left
        if(key <= node.key) {
            if(node.left == null) {
                node.left = new Node(key);
            } else {
                insertItem(node.left, key);
            }
        }
        //right
        if(key > node.key) {
            if(node.right == null) {
                node.right = new Node(key);
            } else {
                insertItem(node.right, key);
            }
        }
    }

    public String getOrder() {
        StringBuilder sb = new StringBuilder();
        if(root != null) {
            sb.append(root.key);
            preOrderTraversal(root, sb);
        }
        return sb.toString();
    }

    public void printPreOrderTraversal() {

    }

    private void preOrderTraversal(Node node, StringBuilder sb) {
        if(node != null) {

            if(node.left != null) {
                sb.append(node.left.key);
                preOrderTraversal(node.left, sb);
            }

            if(node.right != null) {
                sb.append(node.right.key);
                preOrderTraversal(node.right, sb);
            }
        }
    }

    //
    // Utils
    //
    public void prettyPrint() {
    }
}