package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

    public List<String> readPhrases() {
        List<String> answers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new FileReader(botAnswers)
        )) {
            for (String str = br.readLine(); str != null; str = br.readLine()) {
                answers.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answers;
    }

    public void writeLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            for (String str : log) {
                pw.write(str);
                pw.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        List<String> log = new ArrayList<>();
        List<String> ans = readPhrases();
        try (BufferedReader read = new BufferedReader(
                new InputStreamReader(System.in)
        )) {
            String s = read.readLine();
            String out;
            boolean flag = true;
            while (s != null && !s.equals(OUT)) {Y
                if (s.equals(STOP)) {
                    flag = false;
                    continue;
                }
                if (s.equals(CONTINUE)) {
                    flag = true;
                    continue;
                }
                if (flag) {
                    out = "Бот: " + ans.get(new Random().nextInt(ans.size()));
                    log.add("Пользователь: " + s);
                    log.add(out);
                    System.out.println(out);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeLog(log);
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat(
                "C:\\projects\\job4j_design\\src\\data\\log.txt",
                "C:\\projects\\job4j_design\\src\\data\\botAnswers.txt"
        );
        cc.run();
    }
}