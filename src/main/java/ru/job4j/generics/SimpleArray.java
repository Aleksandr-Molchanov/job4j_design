package ru.job4j.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private final T[] data;
    private int size = 0;

    public SimpleArray(T[] data) {
        this.data = data;
    }

    public void add(T model) {
        data[size] = model;
        size++;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, size);
        data[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size -= 1;
        data[size] = null;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return data[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int point = 0;

            @Override
            public boolean hasNext() {
                return point < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return data[point++];
            }
        };
    }

    @Override
    public String toString() {
        return "SimpleArray{"
                + "data=" + Arrays.toString(data)
                + ", size=" + size
                + '}';
    }

    public static void main(String[] args) {
        SimpleArray<Integer> simpleArray = new SimpleArray(new Integer[5]);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        System.out.println(simpleArray);
        simpleArray.set(1, 5);
        System.out.println(simpleArray);
        simpleArray.remove(1);
        System.out.println(simpleArray);
        System.out.println(simpleArray.get(2));
    }
}
