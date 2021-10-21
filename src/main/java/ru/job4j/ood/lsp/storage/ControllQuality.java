package ru.job4j.ood.lsp.storage;

import java.util.Date;
import java.util.List;

public class ControllQuality {

    private List<Storage> storages;

    public ControllQuality(List<Storage> storage) {
        this.storages = storage;
    }

    public boolean distribute(Food food) {
        boolean rsl = false;
        for (Storage st : storages) {
            if (st.add(food)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        Bread bread = new Bread("bread", new Date(), new Date(), 10.99, false);
        Eggs eggs = new Eggs("eggs", new Date(), new Date(), 10.99, false);
        Meat meat = new Meat("meat", new Date(), new Date(), 10.99, false);
        ControllQuality control = new ControllQuality(List.of(new Warehouse(), new Shop(), new Trash()));
        control.distribute(bread);
        control.distribute(eggs);
        control.distribute(meat);
    }
}
