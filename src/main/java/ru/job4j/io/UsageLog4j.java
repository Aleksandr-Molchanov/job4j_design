package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        char c = 'a';
        long l = 100000000000000L;
        byte b = 127;
        short s = 10;
        float f = 1.00f;
        double d = 10.55;
        boolean bool = true;
        LOG.debug("User info name : {}, age : {}", name, age);
        LOG.debug("info age : {}, c : {}, l : {}, b : {}, s : {}, f : {}, d : {}, bool : {}", age, c, l, b, s, f, d, bool);
    }
}