package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    public boolean evenNumber() {
        for (int index = point; index < data.length; index++) {
            if (data[index] % 2 == 0) {
                point = index;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasNext() {
        if (evenNumber()) {
            return point < data.length;
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }
}
