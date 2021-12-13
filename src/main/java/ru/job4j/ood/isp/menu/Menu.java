package ru.job4j.ood.isp.menu;

import java.util.ArrayList;
import java.util.List;

public class Menu implements Print, Action {

    private Action action;

    private List<Item> list = new ArrayList<>();

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
        for (Item it : list) {
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


    @Override
    public void act() {

    }

    public void add(String parentName, String childName, Action action) {
        for (Item it : list) {
            if (it.getName().equals(parentName)) {
                it.getChildren().add(new Item(childName, null));
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        Item item = new Item("Задачa 1.");
        menu.list.add(item);
        menu.add("Задачa 1.", "Задачa 1.1.", null);
        menu.add("Задачa 1.", "Задачa 1.2.", null);
        menu.add("Задачa 1.2.", "Задачa 1.2.2.", null);
        menu.print(item, menu.printLine());
        System.out.println();
        System.out.println(menu.list.toString());
    }
}
