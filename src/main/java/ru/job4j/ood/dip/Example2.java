package ru.job4j.ood.dip;

import java.util.List;

/**
 * Здесь проблема в том, что класс ClientBase
 * зависит от конкретной реализации Client.
 * Нужно было выделить абстракцию,
 * которую бы реализовал класс Client
 * и в качестве объектов, которые хранятся
 * в листе base использовать эту абстракцию.
 */

class Example2 {

    private static class Client {
    }

    private static class ClientBase {

        private List<Client> base;

    }
}