package ru.job4j.ood.ocp;

import java.util.List;

/**
 * Здесь проблема в том, что в качестве поля в
 * классе LoadedMagazine используется не абстракция,
 * а конкретный реализованный класс.
 * Проблема возникнет, когда в LoadedMagazine захотят добавить
 * объекты не класса ArmorPiercing, а другого.
 */
public class Example2 {

    private interface Magazine {

        List<ArmorPiercing> charge();

    }

    private static class ArmorPiercing {
    }

    private static class LoadedMagazine implements Magazine {

        private ArmorPiercing armorPiercing;

        public LoadedMagazine(ArmorPiercing armorPiercing) {
            this.armorPiercing = armorPiercing;
        }

        @Override
        public List<ArmorPiercing> charge() {
            return List.of(
                    new ArmorPiercing(),
                    new ArmorPiercing(),
                    new ArmorPiercing(),
                    new ArmorPiercing(),
                    new ArmorPiercing(),
                    new ArmorPiercing()
            );
        }
    }

}