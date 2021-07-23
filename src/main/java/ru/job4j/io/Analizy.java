package ru.job4j.io;

import java.io.*;

public class Analizy {
    public static void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source));
            PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(target)
                ))) {
            boolean trigger = true;
            for (String str = read.readLine(); str != null; str = read.readLine()) {
                if (trigger && (str.startsWith("400") || str.startsWith("500"))) {
                    String[] logStart = str.split(" ");
                    out.write(logStart[1]);
                    out.print(";");
                    trigger = false;
                }
                if (!trigger && (str.startsWith("200") || str.startsWith("300"))) {
                    String[] logStop = str.split(" ");
                    out.write(logStop[1]);
                    out.println(";");
                    trigger = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}