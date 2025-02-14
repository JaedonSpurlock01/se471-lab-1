package com.problem1.model;

import java.util.UUID;

public class Product {
    private final UUID ID;
    private String name;
    private double price;

    public Product(String name, double price) {
        this.ID = UUID.randomUUID();
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public UUID getID() {
        return ID;
    }
}
