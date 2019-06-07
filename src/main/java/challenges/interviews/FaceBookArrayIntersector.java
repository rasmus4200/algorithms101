package challenges.interviews;

import java.util.ArrayList;

public class FaceBookArrayIntersector {

    public FaceBookArrayIntersector() {
    }

    public ArrayList<Integer> intersect(int[] array1, int[] array2) {

        ArrayList<Integer> collector = new ArrayList<>();

        // you try... scroll down to see solution below

        return collector;
    }




























    public ArrayList<Integer> intersectBruteForce(int[] array1, int[] array2) {

        ArrayList<Integer> collector = new ArrayList<>();

        // O(n)
        for (int i : array1) {
            // O(m)
            for (int j : array2) {
                if (i == j) {
                    collector.add(i);
                }
            }
        }

        return collector;
    }

    public ArrayList<Integer> intersectElegant(int[] array1, int[] array2) {

        // array1: i length m
        // array2: i length n

        // loop through both arrays
        // if one element is less than the other ... there can be no intersection
        //  - increment the lower pointer
        //  - if elements are equal collect
        //    - then increment either of the pointers

        int i = 0; int m = array1.length;
        int j = 0; int n = array2.length;

        ArrayList<Integer> collector = new ArrayList<>();

        // O(n + m)
        while (i < m && j < n) {
            if (array1[i] < array2[j]) {
                i++;
            } else if (array2[j] < array1[i]) {
                j++;
            } else { // equal
                collector.add(array1[i]);
                i++;
            }
        }

        return collector;
    }

}
