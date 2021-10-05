package ru.job4j.ood.srp;

import java.util.List;

/**
 * Здесь нарушение SRP - класс должен предоставлять только один функционал,
 * нужно разделить поиск музыки и проигрывание на 2 интерфейса
 */
public class MusicPlayer {

    public Music find() {
        return null;
    }

    public void play(List<Music> list) {
    }
}
