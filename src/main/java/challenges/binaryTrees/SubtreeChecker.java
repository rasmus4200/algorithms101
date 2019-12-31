package challenges.binaryTrees;

public class SubtreeChecker {

    public boolean isSubTree(SimpleBinarySearchTree t1, SimpleBinarySearchTree t2) {
        String s1 = t1.getOrder();
        String s2 = t2.getOrder();
        return (s1.contains(s2)) ? true : false;
    }
}