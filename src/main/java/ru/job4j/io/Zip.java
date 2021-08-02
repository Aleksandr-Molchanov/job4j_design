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
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(String.valueOf(target))))) {
            for (Path f : sources) {
                zip.putNextEntry(new ZipEntry(f.toFile().getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(String.valueOf(f)))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        if (args.length != 3) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        ArgsName param = ArgsName.of(args);
        System.out.println(Paths.get(param.get("d")));
        System.out.println(new File(param.get("o")));
        System.out.println(param.get("e"));
        packFiles(Search.search(
                Paths.get(param.get("d")),
                (p -> !(p.toFile().getName().endsWith(param.get("e"))))),
                new File(param.get("o"))
        );
    }
}