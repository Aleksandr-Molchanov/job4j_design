package ru.job4j.ood.isp;

/**
 * Есть 2 класса, которые реализуют интерфейс Fridge(холодильник).
 * Класс NewFridge это реализация современных моделей с дисплеем управления,
 * в этом классе все реализованные методы актуальны.
 * Класс OldFridge это реализация старых моделей без дисплея управления,
 * в этом классе методы temperatureValue(int temp) и diagnostics() избыточны.
 * Класс OldFridge реализует методы, которые не использует.
 */

public class Example1 {

    interface Fridge {

        void on();

        void off();

        void temperatureValue(int temp);

        void diagnostics();
    }

    public static class NewFridge implements Fridge {

        @Override
        public void on() {

        }

        @Override
        public void off() {

        }

        @Override
        public void temperatureValue(int temp) {

        }

        @Override
        public void diagnostics() {

        }
    }

    public static class OldFridge implements Fridge {

        @Override
        public void on() {

        }

        @Override
        public void off() {

        }

        @Override
        public void temperatureValue(int temp) {

        }

        @Override
        public void diagnostics() {

        }
    }
}
