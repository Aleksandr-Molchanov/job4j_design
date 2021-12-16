package ru.job4j.ood.isp.menu;

import java.util.ArrayList;
import java.util.List;

public class Menu implements Print {

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

    public Action findByName(String name) {
        Action rsl = null;
        for (Item it : list) {
            if (it.getName().equals(name)) {
                rsl = it.getAction();
                break;
            }
        }
        return rsl;
    }

    @Override
    public String printLine() {
        return "----";
    }

    public void add(String parentName, String childName, Action action) {
        for (Item it : list) {
            if (it.getName().equals(parentName)) {
                it.getChildren().add(new Item(childName, new ArrayList<Item>(), action));
            } else if (it.getChildren().size() > 0) {
                for (Item child : it.getChildren()) {
                    if (child.getName().equals(parentName)) {
                        child.getChildren().add(new Item(childName, new ArrayList<Item>(), action));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        Item item = new Item("Задачa 1.", new ArrayList<>(), null);
        menu.list.add(item);
        menu.add("Задачa 1.", "Задачa 1.1.", null);
        menu.add("Задачa 1.", "Задачa 1.2.", null);
        menu.add("Задачa 1.1.", "Задачa 1.1.1.", null);
        menu.add("Задачa 1.1.", "Задачa 1.1.2.", null);
        menu.add("Задачa 1.2.", "Задачa 1.2.1.", null);
        menu.print(item, menu.printLine());
    }
}
