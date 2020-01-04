package algorithms;

public class BubbleSort {

    public int[] sort(int arr[])
    {
        for(int i=arr.length-1; i>0; i--) {
            for(int j=0; j<i; j++) {
                System.out.println(j);
                if(arr[j]>arr[j+1]) {
                    int buffer = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = buffer;
                }
            }
        }
        return arr;
    }
}