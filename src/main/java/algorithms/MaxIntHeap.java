package algorithms;

import java.util.Arrays;

public class MaxIntHeap {
    private int capactity = 10;
    private int size = 0;

    public int[] items = new int[capactity];

    private int leftChildIndex(int parentIndex) {
        return 2*parentIndex+1;
    }
    private int rightChildIndex(int parentIndex) {
        return 2*parentIndex+2;
    }
    private int parentIndex(int childIndex ) {
        return (childIndex-1)/2;
    }

    private boolean hasLeftChild(int index) {
        return (items[leftChildIndex(index)] == 0);
    }
    private boolean hasRightChild(int index) {
        return (items[rightChildIndex(index)] == 0);
    }
    private boolean hasParent(int index) {
        return (items[parentIndex(index)] == 0);
    }

    private int leftChild(int index) {
        return items[leftChildIndex(index)];
    }
    private int rightChild(int index) {
        return items[rightChildIndex(index)];
    }
    private int parent(int index) {
        return items[parentIndex(index)];
    }

    public int extractMax() {
        int max = items[0];
        size--;
        swap(0, size);
        items[size] = 0;
        heapifyDown();
        return max;
    }

    private void ensureCapactity() {
        if (size == capactity) {
            items = Arrays.copyOf(items, capactity * 2);
            capactity *= 2;
        }
    }

    public void insert(int item) {
        ensureCapactity();
        items[size] = item;
        heapifyUp();
        size++;
    }

    public void heapifyUp() {
        int currentIndex = size;
        while (parent(currentIndex) < items[currentIndex]) {
                swap(parentIndex(currentIndex), currentIndex);
                currentIndex = parentIndex(currentIndex);
        }
    }

    public void heapifyDown() {
        int currentIndex = 0, childIndex;
        while(currentIndex < size) {
            childIndex = getGreaterChildIndex(currentIndex);
            if(childIndex == -1) {
                break;
            }
            if(items[currentIndex] < items[childIndex]) {
                swap(currentIndex, childIndex);
                currentIndex = childIndex;
            } else {
                break;
            }
        }
    }

    private int getGreaterChildIndex(int index) {
        int leftIndex = leftChildIndex(index);
        int rightIndex = rightChildIndex(index);
        if(leftIndex > size && rightIndex > size) {
            return -1;
        }
        if(leftChild(index) == 0 && rightChild(index) == 0) {
            return -1;
        }
        return (leftChild(index) > rightChild(index))
                ? leftChildIndex(index)
                : rightChildIndex(index);
    }

    public void print() {

    }

    private void swap(int indexOne, int indexTwo) {
        int buffer = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = buffer;
    }
}
