package datastructures;

public class HashTable {

    private int INITIAL_SIZE = 16;
    private HashEntry[] data; // LinkedList

    class HashEntry {
        String key;
        String value;
        HashEntry next;

        HashEntry(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    HashTable() {
        data = new HashEntry[INITIAL_SIZE];
    }

    public void put(String key, String value) {

        // Get the index
        int index = getIndex(key);

        // Create the linked list entry
        HashEntry entry = new HashEntry(key, value);

        // If no entry there - add it
        if (data[index] == null) {
            data[index] = entry;
        }
        // Else handle collision by adding to end of linked list
        else {
            HashEntry entries = data[index];
            // Walk to the end...
            while(entries.next != null) {
                entries = entries.next;
            }
            // Add our new entry there
            entries.next = entry;
        }
    }

    public String get(String key) {

        // Get the index
        int index = getIndex(key);

        // Get the current list of entries
        HashEntry entries = data[index];

        // if we have existing entries against this key...
        if (entries != null) {
            // else walk chain until find a match
            while (!entries.key.equals(key) && entries.next !=null) {
                entries = entries.next;
            }
            // then return it
            return entries.value;
        }

        // it we have no entries against this key...
       return null;
    }

    private int getIndex(String key) {
        // Get the hash code
        int hashCode = key.hashCode();
        System.out.println("hashCode = " + hashCode);

        // Convert to index
        int index = (hashCode & 0x7fffffff) % INITIAL_SIZE;
//        int index = hashCode % INITIAL_SIZE;

        System.out.println("index = " + index);

        // Hack to force collision for testing
        if (key.equals("John Smith") || key.equals("Sandra Dee")) {
            index = 4;
        }

        return index;
    }

    @Override
    public String toString() {
        int bucket = 0;
        StringBuilder hashTableStr = new StringBuilder();
        for (HashEntry entry : data) {
            if(entry == null) {
                continue;
            }
            hashTableStr.append("\n bucket[")
                    .append(bucket)
                    .append("] = ")
                    .append(entry.toString());
            bucket++;
            HashEntry temp = entry.next;
            while(temp != null) {
                hashTableStr.append(" -> ");
                hashTableStr.append(temp.toString());
                temp = temp.next;
            }
        }
        return hashTableStr.toString();
    }
}