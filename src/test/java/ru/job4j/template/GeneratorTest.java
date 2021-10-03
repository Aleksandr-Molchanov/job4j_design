package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class GeneratorTest {

    @Test
    @Ignore
    public void produce() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Alexander");
        map.put("subject", "you");
        Generator generator = new PlugGenerator();
        String result = generator.produce("I am a ${name}, Who are ${subject}?", map);
        String expected = "I am a Alexander, Who are you?";
        assertThat(result, is(expected));
    }

    @Test (expected = IllegalArgumentException.class)
    @Ignore
    public void whenThereAreMoreKeysInTheTemplateThanInTheMap() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Alexander");
        Generator generator = new PlugGenerator();
        generator.produce("I am a ${name}, Who are ${subject}?", map);
    }

    @Test (expected = IllegalArgumentException.class)
    @Ignore
    public void whenThereAreFewerKeysInTheTemplateThanInTheMap() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Alexander");
        map.put("subject", "you");
        map.put("subject2", "she");
        Generator generator = new PlugGenerator();
        generator.produce("I am a ${name}, Who are ${subject}?", map);
    }
}