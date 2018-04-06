package challenges.binaryTrees;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {

    private SubtreeChecker treeChecker;

    @Before
    public void SetUp() {
        treeChecker = new SubtreeChecker();
    }

    @Test
    public void CheckSubTree() {
        // Challenge: T1 is a large binary tree and T2 is a smaller one. Write an
        // algorithm to determine if T2 is a subtree of T1.

        SimpleBinarySearchTree t1 = new SimpleBinarySearchTree();
        SimpleBinarySearchTree t2 = new SimpleBinarySearchTree();

        // Create our T1 tree
        t1.insert(5);
        t1.insert(3);
        t1.insert(2);
        t1.insert(4);
        t1.insert(7);
        t1.insert(6);
        t1.insert(8);

//        t1.prettyPrint();
//        t1.printPreOrderTraversal();

        Assert.assertEquals("5324768", t1.getOrder());

        // Create our T2 tree
        t2.insert(7);
        t2.insert(6);
        t2.insert(8);

//        t2.prettyPrint();
//        t2.printPreOrderTraversal();

        Assert.assertEquals("768", t2.getOrder());

        Assert.assertTrue(treeChecker.isSubTree(t1, t2));
    }

    @Test
    public void PathsWithSum() {
        // Challenge: Given a binary tree that can contain positive or negative keys,
        // design an algorithm to count the number of paths that sum to a given value.
        // The path does not need to start or end at the root or a leaf, but it must
        // go downwards from parent to child.

        // Soln:
        //
        // Let's say we want to check this binary tree for paths leading to '8'
        //
        //       10
        //      /  \
        //     5   -3
        //    / \    \
        //   3   2   11
        //  / \   \
        // 3  -2   1
        //
        //
        // First thing we need to do is build a binary tree that isn't sorted.
        //

        CustomBinaryTree binaryTree = new CustomBinaryTree(10); // root

        // Define our nodes
        CustomBinaryTreeNode node5 = new CustomBinaryTreeNode(5);
        CustomBinaryTreeNode nodem3 = new CustomBinaryTreeNode(-3);
        CustomBinaryTreeNode node3 = new CustomBinaryTreeNode(3);
        CustomBinaryTreeNode node2 = new CustomBinaryTreeNode(2);
        CustomBinaryTreeNode node11 = new CustomBinaryTreeNode(11);
        CustomBinaryTreeNode node3Other = new CustomBinaryTreeNode(3);
        CustomBinaryTreeNode nodem2 = new CustomBinaryTreeNode(-2);
        CustomBinaryTreeNode node1 = new CustomBinaryTreeNode(1);

        // And then insert them in the order we want
        binaryTree.add(binaryTree.root, node5, "left");
        binaryTree.add(binaryTree.root, nodem3, "right");

        binaryTree.add(node5, node3, "left");
        binaryTree.add(node5, node2, "right");

        binaryTree.add(nodem3, node11, "right");

        binaryTree.add(node3, node3Other, "left");
        binaryTree.add(node3, nodem2, "right");

        binaryTree.add(node2, node1, "right");

        // Now we are in a position to count paths
        Assert.assertEquals(3, binaryTree.countPathsWithSum(8));
    }

}
