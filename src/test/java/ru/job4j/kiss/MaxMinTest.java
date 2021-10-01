package ru.job4j.kiss;

import org.junit.Test;
import static org.hamcrest.Matchers.is;

import java.util.List;

import static org.junit.Assert.*;

public class MaxMinTest {

    @Test
    public void whenZIsTheMaximum() {
        MaxMin maxMin = new MaxMin();
        List<String> value = List.of("c", "a", "b", "z", "x");
        String rsl = maxMin.max(value, String::compareTo);
        String expected = "z";
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenAIsTheMinimum() {
        MaxMin maxMin = new MaxMin();
        List<String> value = List.of("c", "a", "b", "z", "x");
        String rsl = maxMin.min(value, String::compareTo);
        String expected = "a";
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenTheValuesAreEqual() {
        MaxMin maxMin = new MaxMin();
        List<String> value = List.of("a", "a", "a", "a", "a");
        String rslMin = maxMin.min(value, String::compareTo);
        String rslMax = maxMin.max(value, String::compareTo);
        String expected = "a";
        assertThat(rslMin, is(expected));
        assertThat(rslMax, is(expected));
    }
}