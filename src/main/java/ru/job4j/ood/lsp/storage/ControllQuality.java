package ru.job4j.ood.lsp.storage;

import java.util.List;

public class ControllQuality {

    private List<Strategy> strategy;

    public ControllQuality(List<Strategy> strategy) {
        this.strategy = strategy;
    }

    public boolean distribute(Food food) {
        boolean rsl = false;
        for (Strategy st : strategy) {
            if (st.add(food)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }
}
