package algorithms;

public class MergeSort {

    // Main function that sorts arr[l..r] using
    // merge()
    public void sort(int arr[], int l, int r)
    {

    }

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    public void merge(int arr[], int l, int m, int r)
    {

    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Pros: Pretty efficient sorting algorithm - O(n log(n))

    // Cons: Takes up a bit more space (as you are copying and duplicating contents of array)

    /* This code is contributed by Rajat Mishra */
}