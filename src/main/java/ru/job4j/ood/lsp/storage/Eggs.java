package ru.job4j.ood.lsp.storage;

import java.util.Date;

public class Eggs extends Food {

    public Eggs(String name, Date expiryDate, Date createDate, double price, boolean discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
