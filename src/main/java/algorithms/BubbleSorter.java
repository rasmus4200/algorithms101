package algorithms;

public class BubbleSorter {

    public int[] sort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                print(arr, i, j);
                if (arr[j] > arr[j+1])
                {
                    // swap temp and arr[i]
                    System.out.println("Swapping: " + arr[j] + " " + arr[j+1]);
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        return arr;
    }

    public void print(int[] a, int i, int j) {
        System.out.println(a[0] + " " + a[1] + " " + a[2] + " " + a[3] + " " + a[4] + " i=" + i + " j=" + j);
    }
}