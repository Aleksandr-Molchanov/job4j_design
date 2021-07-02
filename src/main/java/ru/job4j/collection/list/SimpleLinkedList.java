package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {

    private Node<E> firstNode;
    private Node<E> lastNode;
    private int modCount = 0;
    private int size = 0;

    public SimpleLinkedList() {
        lastNode = new Node<E>(null, (E) firstNode, null);
        firstNode = new Node<E>(null, null, lastNode);
    }

    @Override
    public void add(E value) {
        Node<E> prevNode = lastNode;
        prevNode.setItem(value);
        lastNode = new Node<E>(null, (E) prevNode, null);
        prevNode.setNext(lastNode);
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> target = firstNode.getNext();
        for (int i = 0; i < index; i++) {
            target = getNextElement(target);
        }
        return target.getItem();
    }

    private Node<E> getNextElement(Node<E> current) {
        return current.getNext();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int point = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return point < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return get(point++);
            }
        };
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        public E getItem() {
            return item;
        }

        public void setItem(E item) {
            this.item = item;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }
}