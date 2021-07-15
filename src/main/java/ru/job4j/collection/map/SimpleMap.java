package ru.job4j.collection.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
       if (key == null) {
            table[0] = new MapEntry<>(null, value);
            count++;
            modCount++;
            return true;
        }
        int hash = hash(key.hashCode());
        int position = indexFor(hash);
        if (table[position] != null && !table[position].key.equals(key)) {
            return false;
        }
        table[position] = new MapEntry<>(key, value);
        count++;
        modCount++;
        if (count / capacity >= LOAD_FACTOR) {
            expand();
        }
        return true;
    }

    private int hash(int hashCode) {
        return (hashCode == 0) ? 0 : hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (table.length - 1);
    }

    private void expand() {
        MapEntry<K, V>[] tmp = table;
        capacity *= 2;
        count = 0;
        table = new MapEntry[capacity];
        for (MapEntry<K, V> el : tmp) {
            if (el != null) {
                put(el.key, el.value);
                count++;
                modCount++;
            }
        }
    }

    @Override
    public V get(K key) {
        V rsl = null;
        if (key == null && table[0] != null) {
            rsl = table[0].value;
        } else if (key != null) {
            int position = indexFor(hash(key.hashCode()));
            if (table[position] != null && table[position].key.equals(key)) {
                rsl = table[position].value;
            }
        }
        return rsl;
    }

    @Override
    public boolean remove(K key) {
        if (key == null) {
            table[0] = null;
            count--;
            modCount++;
            return true;
        }
        int hash = hash(key.hashCode());
        int position = indexFor(hash);
        if (table[position].key.equals(key)) {
            table[position] = null;
            count--;
            modCount++;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int point = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                for (MapEntry<K, V> el : table) {
                    if (el != null) {
                        point++;
                        break;
                    }
                }
                return point < count;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (K) table[point++];
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}