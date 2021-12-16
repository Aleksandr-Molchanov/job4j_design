package ru.job4j.ood.dip;

import java.util.ArrayList;
import java.util.List;

/**
 * Здесь проблема в том, что конструктор класса Base
 * в качестве аргумента принимает конкретную реализацию листа.
 */

class Example3 {

    private static class Base {

        private List<String> base;

        public Base(ArrayList<String> base) {
            this.base = base;
        }
    }
}