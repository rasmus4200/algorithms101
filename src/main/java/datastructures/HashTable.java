package datastructures;

public class HashTable<K, V> {

    private int INITIAL_SIZE = 16;
    private HashEntry[] data; // LinkedList

    class HashEntry<K, V> {
        K key;
        V value;
        HashEntry next;

        HashEntry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    HashTable() {
        data = new HashEntry[INITIAL_SIZE];
    }

    public void put(K key, V value) {

    }

    public V get(String key) {

        return null;
    }

    private int getIndex(K key) {

        int index = 0;

        // Hack to force collision for testing
        /*
        if (key.equals("John Smith") || key.equals("Sandra Dee")) {
            index = 4;
        }
        */

        return index;
    }

    @Override
    public String toString() {

        /**
         * TODO: Try to use a StringBuilder here
         */

        return null;
    }
}