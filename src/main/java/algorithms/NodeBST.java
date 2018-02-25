package algorithms;

public class NodeBST {

    NodeBST left, right;
    int data;

    public NodeBST(int data) {
        this.data = data;
    }

    public void insert(int value) {
        // look to the left and the right to see where we want to insert
        if (value <= data) {
            if (left == null) {
                left = new NodeBST(value);
            } else {
                // push down to child and ask it to handle : recursion
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new NodeBST(value);
            } else {
                right.insert(value);
            }
        }
    }

    public boolean contains(int value) {
        // if we are there, return true
        if (value == data) {
            return true;
        } else if (value < data) {
            // then it should be on the left
            // if there is no left node
            if (left == null) {
                return false;
            } else {
                return left.contains(value);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        }
    }

    // left child -> parent -> right child
    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }

        System.out.println("data = " + data);

        if (right != null) {
            right.printInOrder();
        }
    }
}
