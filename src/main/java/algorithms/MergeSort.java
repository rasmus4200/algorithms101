package algorithms;

public class MergeSort {

    // Main function that sorts arr[l..r] using
    // merge()
    public void sort(int arr[])
    {
        sort(arr, 0, arr.length-1);
    }

    private void sort(int arr[], int l, int r)
    {
        if(l < r) {
            int m = (l+r)/2;
            sort(arr, l, m);
            sort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    public void merge(int arr[], int l, int m, int r)
    {
        int[] subLeft = getSubarray(arr, l, m);
        int[] subRight = getSubarray(arr, m+1, r);

        int leftPointer = 0;
        int rightPointer = 0;

        int currentPointer = l;

        while (leftPointer < subLeft.length && rightPointer < subRight.length) {
            if (subLeft[leftPointer] <= subRight[rightPointer]) {
                arr[currentPointer] = subLeft[leftPointer];
                leftPointer++;
            } else {
                arr[currentPointer] = subRight[rightPointer];
                rightPointer++;
            }
            currentPointer++;
        }

        while(leftPointer < subLeft.length) {
            arr[currentPointer] = subLeft[leftPointer];
            currentPointer++;
            leftPointer++;
        }

        while(rightPointer < subRight.length) {
            arr[currentPointer] = subRight[rightPointer];
            currentPointer++;
            rightPointer++;
        }
    }

    private int[] getSubarray(int[] arr, int leftInner, int rightInner) {
        int size = rightInner-leftInner+1;
        int[] subArr = new int[size];
        int oldPointer = leftInner;
        for(int i=0; i<size; i++) {
            subArr[i] = arr[oldPointer];
            oldPointer++;
        }
        return subArr;
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Pros: Pretty efficient sorting algorithm - O(n log(n))

    // Cons: Takes up a bit more space (as you are copying and duplicating contents of array)
}