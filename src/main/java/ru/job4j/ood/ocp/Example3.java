package ru.job4j.ood.ocp;

/**
 * Здесь проблема возникнет, когда нужно будет конвертировать
 * миллисекунды в минуты. Нужно будет добавить новый метод.
 */
public class Example3 {

    public long convertMillisToSecond(long millis) {
        return millis / 1000;
    }
}
