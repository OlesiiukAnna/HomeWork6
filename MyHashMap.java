package org.anna.Task_6;

import java.util.Arrays;

public class MyHashMap implements MyMap {

    private HashMapEntry[] table = new HashMapEntry[16];
    private double loadFactor = 0.75;
    private double threshold = loadFactor * table.length;
    private int numberOfElements = 0;

    @Override
    public void clear() {
        numberOfElements = 0;
        table = new HashMapEntry[16];
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    @Override
    public int size() {
        return numberOfElements;
    }

    @Override
    public String put(String key, String value) {
        String result = putInternal(key, value);
        if (result == null) {
            numberOfElements++;
        }
        if (numberOfElements > threshold) {
            resize();
        }
        return result;
    }

    private String putInternal(String key, String value) {
        HashMapEntry newEntry = new HashMapEntry(key, value);
        int basketIndex = getBasketIndex(key);
        if (!isBasketEmpty(basketIndex)) {
            HashMapEntry current = table[basketIndex];
            while (current != null && !current.key.equals(key)) {
                current = current.next;
            }

            if (current != null && current.key.equals(key)){
                String oldValue = current.value;
                current.value = value;
                return oldValue;
            }
        }
        newEntry.next = table[basketIndex];
        table[basketIndex] = newEntry;
        return null;
    }

    private int getBasketIndex(String key) {
        return key.hashCode() % table.length;
    }

    private void resize() {
        Entry[] array = toArray();
        table = new HashMapEntry[table.length * 2];
        threshold = loadFactor * table.length;
        for (Entry entry : array) {
            putInternal(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public boolean containsKey(String key) {
        int basketIndex = getBasketIndex(key);
        return !isBasketEmpty(basketIndex) && table[basketIndex].key.equals(key);
    }

    private boolean isBasketEmpty(int index) {
        return table[index] == null;
    }

    @Override
    public String get(String key) {
        int position = getBasketIndex(key);
        return containsKey(key) ? table[position].value : null;
    }

    @Override
    public String remove(String key) {
        int basketIndex = getBasketIndex(key);
        return findAndRemoveEntryInList(basketIndex, key);
    }

    private String findAndRemoveEntryInList(int basketIndex, String key) {
        HashMapEntry current = table[basketIndex];
        HashMapEntry previous = null;

        while (current != null && !current.key.equals(key)) {
            previous = current;
            current = current.next;
        }

        if (current != null && current.key.equals(key)) {
            return removeEntry(current, previous, basketIndex);
        }
        return null;
    }

    private String removeEntry(HashMapEntry current, HashMapEntry previous, int basketIndex) {
        String value = current.value;
        if (previous == null) {
            table[basketIndex] = current.next;
        } else {
            previous.next = current.next;
        }
        numberOfElements--;
        return value;
    }

    @Override
    public Entry[] toArray() {
        HashMapEntry[] result = new HashMapEntry[numberOfElements];
        int index = 0;
        for (HashMapEntry temp : table) {
            while (temp != null) {
                result[index] = temp;
                temp = temp.next;
                index++;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    private static class HashMapEntry implements MyMap.Entry {
        private String key;
        private String value;
        private int hashCode;
        private HashMapEntry next;

        private HashMapEntry(String key, String value) {
            this.key = key;
            this.value = value;
            this.hashCode = key.hashCode();
        }

        @Override
        public String getKey() {
            return key;
        }

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }


}
