package ru.job4j.ood.ocp;

import java.util.List;

/**
 * Наследование использовать здесь нельзя,
 * так как если поступит требование не выстрелить из пистолета,
 * а сделать удар ножом, начнуться проблемы.
 * Нужно было использовать интерфейс weapon с методом attack().
 */
public class Example1 {

    private static class Gun {
        public void attack() {
            System.out.println("выстрел");
        }
    }

    public static void main(String[] args) {
        List<Gun> guns = List.of(new Gun(), new Gun());
        guns.forEach(Gun::attack);
    }
}
