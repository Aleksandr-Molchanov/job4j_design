package ru.job4j.ood.isp.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PrintItem implements Print {

    private List<Item> menu = new ArrayList<>();

    @Override
    public void print(Item item, String line) {
        System.out.println(item.getName());
        List<Item> list = Objects.requireNonNull(item).getChildren();
        if (list != null) {
            for (Item it : list) {
                System.out.print(line);
                print(it, line + line);
            }
        }
    }

    public void printByName(Item item, String name) {
        if (item.getName().equals(name)) {
            print(item, printLine());
            return;
        }
        List<Item> list = Objects.requireNonNull(item).getChildren();
        Item rsl = null;
        for (Item it : list) {
            rsl = it;
            printByName(rsl, name);
        }
    }

    @Override
    public String printLine() {
        return "----";
    }

    public void add(Item item) {
        if (item != null) {
            menu.add(item);
        }
        List<Item> list = Objects.requireNonNull(item).getChildren();
        if (list != null) {
            for (Item it: item.getChildren()) {
                add(it);
            }
        }
    }

    public static void main(String[] args) {
        PrintItem menu = new PrintItem();
        Item item = new Item("Задачи:", List.of(
                new Item("Задача 1.", List.of(
                        new Item("Задача 1.1.")
                )),
                new Item("Задача 2.", List.of(
                        new Item("Задача 2.1.", List.of(
                                new Item("Задача 2.1.1")
                        )),
                        new Item("Задача 2.2."))
                )
        ));
        menu.add(item);
        //menu.print(item, menu.printLine());
        menu.printByName(item, "Задача 2.");
    }
}
