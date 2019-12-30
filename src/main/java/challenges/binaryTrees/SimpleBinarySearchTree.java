package challenges.binaryTrees;

public class SimpleBinarySearchTree<E> {

    class Node<T> {
        int key;
        Node<T> left, right;

        public Node(int key) {
            this.key = key;
        }
    }

    Node<E> root;

    public SimpleBinarySearchTree() {
        root = null;
    }

    public void insert(int key) {
    }

    public Node insertItem(Node node, int key) {
        return null;
    }

    public String getOrder() {
        return null;
    }

    public void printPreOrderTraversal() {
    }

    private void preOrderTraversal(Node node, StringBuilder sb) {
    }

    //
    // Utils
    //
    public void prettyPrint() {
    }
}