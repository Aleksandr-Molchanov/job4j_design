package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public static void packFiles(List<Path> sources, File target) {
        for (Path f : sources) {
            packSingleFile(f.toFile(), target);
        }
    }

    public static void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(String.valueOf(target))))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(String.valueOf(source)))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(args.length);
        System.out.println(Arrays.toString(args));
        if (args.length != 6) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        ArgsName param = ArgsName.of(args);
        packFiles(Search.search(
                Paths.get(param.get("d")),
                (p -> !(p.toFile().getName().endsWith(param.get("e"))))),
                new File(param.get("o"))
        );
    }
}