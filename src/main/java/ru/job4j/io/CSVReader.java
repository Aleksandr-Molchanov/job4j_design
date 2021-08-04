package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static List<String> readFile(File path) {
        List<String> file = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            for (String str = br.readLine(); str != null; str = br.readLine()) {
                file.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public static void writeFile(List<String> file, File out) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(out))) {
            for (String str : file) {
                pw.write(str);
                pw.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> filter(List<String> file, String delimiter, String filter) {
        List<String> rsl = new ArrayList<>();
        String[] header = file.get(0).split(delimiter);
        String[] column = filter.split(",");
        List<Integer> indexes = new ArrayList<>();
        int count = 0;
        for (String s : header) {
            for (String col : column) {
                if (s.equals(col)) {
                    indexes.add(count);
                }
                count++;
            }
            count = 0;
        }
        for (String str : file) {
            String[] subStr = str.split(delimiter);
            StringBuilder strResult = new StringBuilder();
            for (Integer i : indexes) {
                strResult.append(subStr[i]).append(delimiter);
            }
            strResult.deleteCharAt(strResult.length() - 1);
            rsl.add(strResult.toString());
        }
        return rsl;
    }

    public static void main(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        ArgsName param = ArgsName.of(args);
        List<String> in = readFile(new File(param.get("path")));
        List<String> out = filter(in, param.get("delimiter"), param.get("filter"));
        if (param.get("out").equals("stdout")) {
            for (String s : out) {
                System.out.println(s);
            }
        } else {
            writeFile(out, new File(param.get("out")));
        }
    }
}
