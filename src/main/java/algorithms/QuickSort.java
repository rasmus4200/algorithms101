package algorithms;

public class QuickSort {

    public int[] sort(int[] array) {
        // Pick a pivot element randomly

        // Walk through the array making sure that all the elements
        // are smaller before the pivot, and that all elements after are bigger
        // and we do this in place! That's the killer feature. No extra array required.
        //
        // Then we repeat the process to the left and right portions over and over again
        // Then eventually our array becomes sorted.


        quickSort(array, 0, array.length-1);
        return array;
    }

    private void quickSort(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }
        int pivot = array[(left+right)/2];
        int index = pivot(array, left, right, pivot);
        quickSort(array, left, index-1);
        quickSort(array, index, right);
    }

    private int pivot(int[] array, int left, int right, int pivot) {
        int leftIndex = left;
        int rightIndex = right;

        while (leftIndex < rightIndex) {
            while(array[leftIndex] < pivot) {
                leftIndex++;
            }
            while(array[rightIndex] > pivot) {
                rightIndex--;
            }
            if(leftIndex <= rightIndex) {
                swap(array, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public void prettyPrint(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}