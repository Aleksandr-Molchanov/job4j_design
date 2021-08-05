package ru.job4j.io;

import java.io.*;
import java.util.*;

public class CSVReader {

    public static List<String> filter(File path, String delimiter, String filter) {
        List<String> file = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();
        boolean flag = true;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            for (String str = br.readLine(); str != null && !str.isEmpty(); str = br.readLine()) {
                if (flag) {
                    String[] header = str.split(delimiter);
                    String[] column = filter.split(",");
                    Set<String> columns = new HashSet<>(Arrays.asList(column));
                    int num = 0;
                    for (String s : header) {
                        if (columns.contains(s)) {
                            indexes.add(num);
                        }
                        num++;
                    }
                    flag = false;
                }
                String[] subStr = str.split(delimiter);
                StringBuilder strResult = new StringBuilder();
                for (Integer i : indexes) {
                    strResult.append(subStr[i]).append(delimiter);
                }
                strResult.deleteCharAt(strResult.length() - 1);
                file.add(strResult.toString());
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

    public static void main(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        ArgsName param = ArgsName.of(args);
        List<String> filteredIn = filter(new File(param.get("path")), param.get("delimiter"), param.get("filter"));
        if (param.get("out").equals("stdout")) {
            for (String s : filteredIn) {
                System.out.println(s);
            }
        } else {
            writeFile(filteredIn, new File(param.get("out")));
        }
    }
}
