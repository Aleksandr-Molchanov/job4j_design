package ru.job4j.ood.isp.menu;

import java.util.*;

public class Menu implements Print {

    private Item root;

    public Menu(Item item) {
        this.root = item;
    }

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

    public Optional<Item> findByName(String name) {
        Optional<Item> found = Optional.empty();
        Queue<Item> queue = new LinkedList<>();
        queue.offer(this.root);
        while (!queue.isEmpty()) {
            Item el = queue.poll();
            if (Objects.equals(el.getName(), name)) {
                found = Optional.of(el);
                break;
            }
            queue.addAll(el.getChildren());
        }
        return found;
    }

    @Override
    public String printLine() {
        return "----";
    }

    public void add(String parentName, String childName, Action action) {
        Optional<Item> findPar = findByName(parentName);
        if (findPar.isPresent()) {
            Optional<Item> findChild = findByName(childName);
            if (findChild.isEmpty()) {
                Item newChild = new Item(childName, new ArrayList<>(), action);
                findPar.get().getChildren().add(newChild);
            }
        }
    }

    public static void main(String[] args) {
        Item root = new Item("Задачa 1.", new ArrayList<>(), new MyAction());
        Menu menu = new Menu(root);
        menu.add("Задачa 1.", "Задачa 1.1.", new MyAction());
        menu.add("Задачa 1.", "Задачa 1.2.", new MyAction());
        menu.add("Задачa 1.1.", "Задачa 1.1.1.", new MyAction());
        menu.add("Задачa 1.1.", "Задачa 1.1.2.", new MyAction());
        menu.add("Задачa 1.2.", "Задачa 1.2.1.", new MyAction());
        menu.add("Задачa 1.1.1.", "Задачa 1.1.1.1.", new MyAction());
        menu.print(root, menu.printLine());
    }
}
