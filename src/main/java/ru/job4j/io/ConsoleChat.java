package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    @SuppressWarnings("checkstyle:InnerAssignment")
    public void run() {
        List<String> answers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers));
             PrintWriter pw = new PrintWriter(new FileWriter(path));
             BufferedReader read = new BufferedReader(new InputStreamReader(System.in))
        ) {
            for (String str = br.readLine(); str != null; str = br.readLine()) {
                answers.add(str);
            }
            String s;
            String out;
            boolean flag = true;
            while ((s = read.readLine()) != null && !s.equals(OUT)) {
                if (s.equals(STOP)) {
                    flag = false;
                    continue;
                }
                if (s.equals(CONTINUE)) {
                    flag = true;
                    continue;
                }
                if (flag) {
                    out = "Бот: " + answers.get(new Random().nextInt(answers.size()));
                    pw.write("Пользователь: " + s);
                    pw.println();
                    pw.println(out);
                    System.out.println(out);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat(
                "C:\\projects\\job4j_design\\src\\data\\log.txt",
                "C:\\projects\\job4j_design\\src\\data\\botAnswers.txt"
        );
        cc.run();
    }
}