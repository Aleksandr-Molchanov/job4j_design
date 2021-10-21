package ru.job4j.ood.lsp.storage;

import java.util.List;

public class Shop implements Strategy {

    private List<Food> shop;

    private InterestCalculator interestCalculator;

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        if (food == null) {
            throw new IllegalArgumentException("Объект food не может быть равен null");
        }
        double interest = interestCalculator.run(food);
        if (interest >= 25 && interest < 75) {
            shop.add(food);
            rsl = true;
        } else if (interest >= 75 && interest < 100) {
            food.setDiscount(true);
            food.setPrice(food.getPrice() * 50 / 100);
            shop.add(food);
            rsl = true;
        }
        return rsl;
    }
}
