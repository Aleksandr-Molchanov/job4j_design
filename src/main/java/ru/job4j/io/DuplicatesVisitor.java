package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private Map<FileProperty, Path> files = new HashMap<>();

    private List<Path> paths = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty property = new FileProperty(attrs.size(), file.getFileName().toString());
        if (files.get(property) == null) {
            files.put(property, file.toAbsolutePath());
        } else {
            paths.add(file);
        }
        return super.visitFile(file, attrs);
    }

    public List<Path> getPaths() {
        return paths;
    }
}