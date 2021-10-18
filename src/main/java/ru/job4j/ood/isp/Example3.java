package ru.job4j.ood.isp;

/**
 * Есть 2 класса, которые реализуют интерфейс Plane(самолет).
 * Класс Boeing747 это реализация пассажирского самолета,
 * в этом классе все реализованные методы актуальны.
 * Класс TU160 это реализация самолета бомбардировщика,
 * в этом классе метод feed() избыточен.
 * Класс TU160 реализует метод, который не использует.
 */

public class Example3 {

    interface Plane {

        void takeoff();

        void landing();

        void feed();
    }

    public static class Boeing747 implements Plane {

        @Override
        public void takeoff() {

        }

        @Override
        public void landing() {

        }

        @Override
        public void feed() {

        }
    }

    public static class TU160 implements Plane {

        @Override
        public void takeoff() {

        }

        @Override
        public void landing() {

        }

        @Override
        public void feed() {

        }
    }
}
