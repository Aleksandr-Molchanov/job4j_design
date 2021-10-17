package ru.job4j.ood.lsp.storage;

public class ControllQuality {

    private Strategy strategy;

    public ControllQuality(Strategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(Food food) {
        return strategy.add(food);
    }
}
