package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

public class DuplicatesFinder {

    Map<String, Long> duplicates = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        DuplicatesVisitor searcher = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("C:\\projects\\job4j_design\\"), searcher);
        for (Path p : searcher.getPaths()) {
            System.out.println(p);
        }
    }
}