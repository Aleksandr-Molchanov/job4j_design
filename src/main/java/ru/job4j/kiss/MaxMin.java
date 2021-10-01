package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        Predicate<Integer> predicate = (x) -> x > 0;
        return comparing(value, comparator, predicate);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        Predicate<Integer> predicate = (x) -> x < 0;
        return comparing(value, comparator, predicate);
    }

    public <T> T comparing(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        T rsl = value.get(0);
        for (T val : value) {
            if (predicate.test(comparator.compare(val, rsl))) {
                rsl = val;
            }
        }
        return rsl;
    }
}