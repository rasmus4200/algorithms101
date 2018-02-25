package challenges.binaryTrees;

public class SubtreeChecker {

    public boolean isSubTree(SimpleBinarySearchTree t1, SimpleBinarySearchTree t2) {
        String order1 = t1.getOrder();
        String order2 = t2.getOrder();

        return order1.contains(order2);
    }
}