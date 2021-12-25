package ru.job4j.ood.isp.menu;

import java.util.*;

public class Menu implements Print {

    private String name;

    private List<Menu> children;

    private Action action;

    public Menu(String name, List<Menu> children, Action action) {
        this.name = name;
        this.children = children;
        this.action = action;
    }

    @Override
    public String print(String line) {
        StringBuilder rsl = new StringBuilder();
        rsl.append(name);
        rsl.append(System.lineSeparator());
        if (children != null) {
            for (Menu m : children) {
                rsl.append(line);
                rsl.append(m.print(line + line));
            }
        }
        return rsl.toString();
    }

    public Optional<Action> findByName(String name) {
        Optional<Action> found = Optional.empty();
        Queue<Menu> queue = new LinkedList<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            Menu el = queue.poll();
            if (Objects.equals(el.name, name)) {
                found = Optional.of(el.action);
                break;
            }
            queue.addAll(el.children);
        }
        return found;
    }

    @Override
    public String printLine() {
        return "----";
    }

    public void add(String parentName, String childName, Action action) {
        if (parentName.equals(name)) {
            children.add(new Menu(childName, new ArrayList<>(), action));
        } else {
            for (Menu m : children) {
                m.add(parentName, childName, action);
            }
        }
    }

    public Action select(String itemName) {
        Action rsl = null;
        if (name.equals(itemName)) {
            rsl = action;
        } else {
            for (Menu it : children) {
                rsl = it.select(itemName);
                if (rsl != null) {
                    break;
                }
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        Menu menu = new Menu("Задачa 1.", new ArrayList<>(), new MyAction());
        menu.add("Задачa 1.", "Задачa 1.1.", new MyAction());
        menu.add("Задачa 1.", "Задачa 1.2.", new MyAction());
        menu.add("Задачa 1.1.", "Задачa 1.1.1.", new MyAction());
        menu.add("Задачa 1.1.", "Задачa 1.1.2.", new MyAction());
        menu.add("Задачa 1.2.", "Задачa 1.2.1.", new MyAction());
        menu.add("Задачa 1.1.1.", "Задачa 1.1.1.1.", new MyAction());
        System.out.println(menu.findByName("Задачa 1.1.2."));
        System.out.println(menu.findByName("Задачa 1.1.1.1."));
        System.out.println(menu.print(menu.printLine()));
    }
}
