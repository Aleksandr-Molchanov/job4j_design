package ru.job4j.ood.lsp.storage;

import java.util.Date;

public class Meat extends Food {

    public Meat(String name, Date expiryDate, Date createDate, double price, boolean discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
