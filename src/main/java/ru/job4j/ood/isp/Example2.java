package ru.job4j.ood.isp;

/**
 * Есть 2 класса, которые реализуют интерфейс Scooter(самокат).
 * Класс ElectricScooter это реализация электросамоката,
 * в этом классе все реализованные методы актуальны.
 * Класс NonElectricScooter это реализация обычного самоката,
 * в этом классе метод charge() избыточен.
 * Класс NonElectricScooter реализует метод, который не использует.
 */

public class Example2 {

    interface Scooter {

        void drive();

        void charge();

    }

    public static class ElectricScooter implements Scooter {

        @Override
        public void drive() {

        }

        @Override
        public void charge() {

        }
    }

    public static class NonElectricScooter implements Scooter {

        @Override
        public void drive() {

        }

        @Override
        public void charge() {

        }
    }
}
