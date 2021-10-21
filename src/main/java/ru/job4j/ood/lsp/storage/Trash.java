package ru.job4j.ood.lsp.storage;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {

    private List<Food> trash = new ArrayList<>();

    private InterestCalculator interestCalculator = new InterestCalculator();

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        if (food == null) {
            throw new IllegalArgumentException("Объект food не может быть равен null");
        }
        double interest = interestCalculator.run(food);
        if (interest >= 100) {
            trash.add(food);
            rsl = true;
        }
        return rsl;
    }
}
