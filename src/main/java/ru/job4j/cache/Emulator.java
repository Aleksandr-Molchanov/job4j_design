package ru.job4j.cache;

public class Emulator {
    public static void main(String[] args) {
        DirFileCache dirFileCache = new DirFileCache("./data/");
        System.out.println(dirFileCache.load("text.txt"));
    }
}