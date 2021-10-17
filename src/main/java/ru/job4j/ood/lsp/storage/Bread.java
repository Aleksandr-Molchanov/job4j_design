package ru.job4j.ood.lsp.storage;

import java.util.Date;

public class Bread extends Food {

    public Bread(String name, Date expiryDate, Date createDate, double price, boolean discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
