package ru.job4j.ood.isp.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PrintItem implements Print {

    private List<Item> menu = new ArrayList<>();

    @Override
    public void print(Item item, String line) {
        if (item != null) {
            System.out.println(item.getName());
            List<Item> list = item.getChildren();
            if (list != null) {
                for (Item it : list) {
                    System.out.print(line);
                    print(it, line + line);
                }
            }
        }

    }

    public void printByName(String name) {
        print(findByName(name), printLine());
    }

    public Item findByName(String name) {
        Item rsl = null;
        for (Item it : menu) {
            if (it.getName().equals(name)) {
                rsl = it;
                break;
            }
        }
        return rsl;
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
        menu.print(item, menu.printLine());
        System.out.println();
        menu.printByName("Задача 2.1.");
    }
}
