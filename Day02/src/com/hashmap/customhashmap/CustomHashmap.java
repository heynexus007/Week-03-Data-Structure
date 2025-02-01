package com.hashmap.customhashmap;

//Creating custom hashMap
public class CustomHashmap <K,V> {
    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int SIZE = 16;
    private Entry<K, V>[] table;

    public CustomHashmap() {
        table = new Entry[SIZE];
    }

    private int getIndex(K key) {
        return key.hashCode() % SIZE;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        Entry<K, V> newEntry = new Entry<>(key, value);

        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            Entry<K, V> current = table[index];
            while (current.next != null && !current.key.equals(key)) {
                current = current.next;
            }

            if (current.key.equals(key)) {
                current.value = value; // Update existing key
            }
            else {
                current.next = newEntry; // Collision handling (chaining)
            }
        }
    }

    public V get(K key) {
        int index = getIndex(key);
        Entry<K, V> current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null; //if Key not found
    }

    public void remove(K key) {
        int index = getIndex(key);
        Entry<K, V> current = table[index];
        Entry<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next; // Remove head
                } else {
                    prev.next = current.next; // Remove from chain
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public static void main(String[] args) {
        CustomHashmap<String, Integer> map = new CustomHashmap<>();
        map.put("One", 1);
        map.put("Two", 2);

        System.out.println("Value for 'One' : " + map.get("One"));
        map.remove("One");
        System.out.println("Value for 'One' after deletion : " + map.get("One"));
    }
}
