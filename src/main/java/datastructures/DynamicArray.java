package datastructures;

public class DynamicArray<T> {

    private Object[] data;

    // Counter for the number of elements in our array
    private int size = 0;

    // The capacity of our array - or how many elements it can hold.
    // What we double when the number of elements exceeds the capacity of the array.
    private int initialCapacity;

    public DynamicArray(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        data = new Object[initialCapacity];
    }

    public T get(int index) {
        return null;
    }

    public void set(int index, T value) {
    }

    public void insert(int index, T value) {
    }

    public void delete(int index) {
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean Contains(T value) {
        return false;
    }


    public int size() {
        return 0;
    }

    public void print() {

    }

    // Some array implementations offer methods like insert (also known as pushBack).
    // Which is like insert, only in does the insert at the end of the array.
    public void add(T value) {
    }

    private void resize() {
    }
}