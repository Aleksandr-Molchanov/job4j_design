package ru.job4j.ood.lsp.storage;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {

    private List<Food> warehouse = new ArrayList<>();

    private InterestCalculator interestCalculator = new InterestCalculator();

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        if (food == null) {
            throw new IllegalArgumentException("Объект food не может быть равен null");
        }
        double interest = interestCalculator.run(food);
        if (interest > 0 && interest < 25) {
            warehouse.add(food);
            rsl = true;
        }
        return rsl;
    }
}
