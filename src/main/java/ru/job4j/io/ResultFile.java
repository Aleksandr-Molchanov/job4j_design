package ru.job4j.io;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int row = 0; row < 10; row++) {
                for (int cell = 0; cell < 10; cell++) {
                    int num = (row + 1) * (cell + 1);
                    out.write((num + " ").getBytes(StandardCharsets.UTF_8));
                }
                out.write(System.lineSeparator().getBytes(StandardCharsets.UTF_8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
