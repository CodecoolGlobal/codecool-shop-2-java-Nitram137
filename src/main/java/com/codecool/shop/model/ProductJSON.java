package com.codecool.shop.model;

public class ProductJSON {

    private final int id;
    private final String name;
    private final String price;
    private final String description;
    private final String supplier;

    public ProductJSON(int id, String name, String price, String description, String supplier) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.supplier = supplier;
    }

}
