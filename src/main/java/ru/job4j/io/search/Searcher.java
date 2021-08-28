package ru.job4j.io.search;

import ru.job4j.io.ArgsName;
import ru.job4j.io.Search;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

public class Searcher {

    public static void main(String[] args) throws IOException {
        if (args.length != 4) {
            throw new IllegalArgumentException("Ошибка параметров запуска");
        }
        ArgsName param = ArgsName.of(args);
        List<Path> paths = finder(param);
        writeFile(paths, new File(param.get("o")));
    }

    public static List<Path> finder(ArgsName param) throws IOException {
        List<Path> rsl;
        Path start = Paths.get(param.get("d"));
        if (param.get("t").equals("mask")) {
            rsl = Search.search(start, p -> p.toFile().getName().endsWith(param.get("n")));
        } else if (param.get("t").equals("name")) {
            rsl = Search.search(start, p -> p.toFile().getName().equals(param.get("n")));
        } else if (param.get("t").equals("regex")) {
            Pattern pattern = Pattern.compile(param.get("n"));
            rsl = Search.search(start, p -> pattern.matcher(p.toFile().getName()).find());
        } else {
            throw new IllegalArgumentException("Ошибка параметра поиска");
        }
        return rsl;
    }

    public static void writeFile(List<Path> file, File out) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(out))) {
            for (Path path : file) {
                pw.write(path.toFile().getName());
                pw.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
