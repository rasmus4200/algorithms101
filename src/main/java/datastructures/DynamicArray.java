package datastructures;

public class DynamicArray<E> {

    private Object[] data;

    private int size = 0;

    private int initialCapacity;

    public DynamicArray(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        data = new Object[initialCapacity];
    }

    public E get(int index) {
        final E value = (E) data[index];
        return value;
    }

    public void set(int index, E value) {
        if(index <= size) {
            data[index] = value;
            this.size++;
        }
    }

    public void insert(int index, E value) {
        if(index < size) {
            if(size == initialCapacity) {
                resize();
            }
            for(int i=size; i > index; i--) {
                data[i] = data[i-1];
                data[i-1] = null;
            }
        }
        set(index, value);
    }

    public void delete(int index) {
        if(index < size) {
            data[index] = null;
            for(int i=index; i<=size-2; i++) {
                data[i] = data[i+1];
                data[i+1] = null;
            }
            this.size--;
        }
    }

    public boolean isEmpty() {
        return (size == 0) ? true : false;
    }

    public boolean Contains(E value) {
        for(int i = 0; i <  data.length; i++) {
            if (value == (E) data[i]) {
                return true;
            }
        }
        return false;
    }


    public int size() {
        return size;
    }

    public void print() {
        for(int i = 0; i <  data.length; i++) {
            if(data[i] == null) {
                System.out.println("empty");
            } else {
                System.out.println(data[i].toString());
            }
        }
    }

    // Some array implementations offer methods like insert (also known as pushBack).
    // Which is like insert, only in does the insert at the end of the array.
    public void add(E value) {
        if(size == initialCapacity) {
            resize();
        }
        set(size, value);
    }

    private void resize() {
        initialCapacity *=2;
        Object[] newData = new Object[initialCapacity];
        for(int i = 0; i <  data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}