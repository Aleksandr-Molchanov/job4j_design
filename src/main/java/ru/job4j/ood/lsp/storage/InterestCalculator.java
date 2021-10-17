package ru.job4j.ood.lsp.storage;

public class InterestCalculator {

    public float run(Food food) {
        long differenceOne = food.getExpiryDate().getTime() - food.getCreateDate().getTime();
        long differenceTwo = System.currentTimeMillis() - food.getCreateDate().getTime();
        return ((float) differenceTwo / differenceOne) * 100;
    }
}
