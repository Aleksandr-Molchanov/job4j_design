package ru.job4j.ood.dip;

/**
 * Здесь проблема в том, что класс Clothes
 * зависит от конкретной реализации Sneakers.
 * Нужно было выделить абстракцию,
 * которую бы реализовал класс Sneakers
 * и в качестве поля в классе Clothes использовать
 * эту абстракцию.
 */

class Example1 {

    private static class Sneakers {

        private int size;

    }

    private static class Clothes {

        private Sneakers sneakers;

    }
}