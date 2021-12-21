package ru.job4j.ood.lsp.storage;

import java.util.List;

public interface Storage {

    boolean add(Food food);

    void remove();

    List<Food> getList();
}
