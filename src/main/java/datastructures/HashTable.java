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

        HashEntry newEntry = new HashEntry(key, value);

        int index = getIndex(key);

        if(data[index] == null) {
            data[index] = newEntry;
        } else {
            HashEntry currentEntry = data[index];
            while(currentEntry.next != null) {
                currentEntry = currentEntry.next;
            }
            currentEntry.next = newEntry;
        }
    }

    public V get(K key) {

        int index = getIndex(key);
        HashEntry currentEntry = data[index];
        while(!currentEntry.key.equals(key)) {
            currentEntry = currentEntry.next;
        }

        return (V) currentEntry.value;
    }

    private int getIndex(K key) {

        int hash;
        int index;

        // Hack to force collision for testing
        if (key.equals("John Smith") || key.equals("Sandra Dee")) {
            index = 4;
        } else {
            hash = key.hashCode();
            index = hash & (INITIAL_SIZE-1);
        }

        return index;
    }

    @Override
    public String toString() {

        /**
         * TODO: Try to use a StringBuilder here
         */

        StringBuilder sb = new StringBuilder();

        sb.append("Complete Hashtable:");
        sb.append("\n");
        sb.append("=============================================");
        sb.append("\n");

        for(int i=0; i < data.length; i++) {
            sb.append("Entry at index no. " + i + ": ");
            if(data[i] == null) {
                sb.append("\n\tEmpty entry");
                sb.append("\n");
            }else {
                HashEntry entry = data[i];
                while(entry != null) {
                    sb.append("\n\tKey: " + entry.key + "; Value: " + entry.value);
                    entry = entry.next;
                }
                sb.append("\n");
            }
        }
        sb.append("=============================================");
        return sb.toString();
    }
}