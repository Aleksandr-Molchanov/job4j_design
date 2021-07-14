package ru.job4j.collection.map;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void whenAddNull() {
        Map<String, Integer> map = new SimpleMap<>();
        assertTrue(map.put(null, 1));
        assertThat(map.get(null), is(1));
    }

    @Test
    public void whenAddNonNull() {
        Map<String, Integer> map = new SimpleMap<>();
        assertTrue(map.put("a", 1));
        assertTrue(map.put("b", 2));
        assertTrue(map.put("a", 3));
    }

    @Test
    public void whenAddThenGet() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("first", 1);
        Integer rsl = map.get("first");
        assertThat(rsl, is(1));
    }

    @Test
    public void whenYouAddAnElementUsingAnExistingKey() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("first", 1);
        map.put("first", 2);
        Integer rsl = map.get("first");
        assertThat(rsl, is(2));
    }

    @Test
    public void whenTheValueIsNotFound() {
        Map<String, Integer> map = new SimpleMap<>();
        Integer rsl = map.get("first");
        assertNull(rsl);
    }

    @Test
    public void whenRemoveNonNull() {
        Map<String, Integer> map = new SimpleMap<>();
        assertTrue(map.put("a", 1));
        assertThat(map.get("a"), is(1));
        assertTrue(map.remove("a"));
        assertNull(map.get("a"));
    }

    @Test
    public void whenRemoveNull() {
        Map<String, Integer> map = new SimpleMap<>();
        assertTrue(map.put(null, 1));
        assertThat(map.get(null), is(1));
        assertTrue(map.remove(null));
        assertNull(map.get(null));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        Map<String, Integer> map = new SimpleMap<>();
        map.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("first", 1);
        Iterator<String> it = map.iterator();
        map.put("second", 2);
        it.next();
    }

    @Test
    public void whenTheMapExpands() {
        Map<String, Integer> map = new SimpleMap<>();
        assertTrue(map.put("a", 1));
        assertTrue(map.put("b", 2));
        assertTrue(map.put("c", 3));
        assertTrue(map.put("d", 4));
        assertTrue(map.put("e", 5));
        assertTrue(map.put("f", 6));
        assertTrue(map.put("g", 7));
        assertTrue(map.put("h", 8));
        assertTrue(map.put("i", 9));
        assertTrue(map.put("j", 10));
    }
}