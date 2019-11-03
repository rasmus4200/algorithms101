package algorithms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AVLTreeTest {

    private AVLTree avl;

    @Before
    public void SetUp() {
        avl = new AVLTree();
    }

    @Test
    public void LeftLeft() {
        avl.insert(30);
        avl.insert(20);
        avl.insert(10);

//        avl.printInOrderTraversal();

        /*
              30
             /         20
           20    >    /  \
          /         10    30
        10
         */
    }

    @Test
    public void RightRight() {
        avl.insert(30);
        avl.insert(40);
        avl.insert(50);

//        avl.printInOrderTraversal();

        /*
        30
          \             40
          40      >    /  \
            \        30    50
             50
         */
    }

    @Test
    public void LeftRight() {
        avl.insert(30);
        avl.insert(20);
        avl.insert(25);

//        avl.printInOrderTraversal();

        /*
           30           30
          /            /          25
        20      >    25     >    /  \
          \         /          20    30
          25      20
         */
    }

    @Test
    public void RightLeft() {
        avl.insert(30);
        avl.insert(40);
        avl.insert(35);

//        avl.printInOrderTraversal();

        /*
        30          30
          \           \             35
           40   >      35   >      /  \
          /              \       30    40
        35                40
         */
    }

}

