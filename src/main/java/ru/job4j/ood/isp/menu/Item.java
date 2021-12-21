package ru.job4j.ood.isp.menu;

import java.util.List;
import java.util.Objects;

public class Item {

    private String name;

    private List<Item> children;

    private Action action;

    public Item(String name, List<Item> children, Action action) {
        this.name = name;
        this.children = children;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getChildren() {
        return children;
    }

    public void setChildren(List<Item> children) {
        this.children = children;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(name, item.name)
                && Objects.equals(children, item.children)
                && Objects.equals(action, item.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, action);
    }

    @Override
    public String toString() {
        return "Item{"
                + "name='" + name + '\''
                + ", children=" + children
                + ", action=" + action
                + '}';
    }
}
