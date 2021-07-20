package ru.job4j.collection.tree;

import java.util.*;
import java.util.function.Predicate;

public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> findPar = findBy(parent);
        Optional<Node<E>> findChild = findBy(child);
        if (findPar.isPresent()) {
            if (findChild.isEmpty()) {
                Node<E> newChild = new Node<>(child);
                findPar.get().children.add(newChild);
                rsl = true;
            }
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Predicate<Node<E>> condition = (x) -> Objects.equals(x.value, value);
        return findByPredicate(condition);
    }

    public boolean isBinary() {
        Predicate<Node<E>> condition = (x) -> x.children.size() > 2;
        Optional<Node<E>> tmp = findByPredicate(condition);
        return tmp.isEmpty();
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}