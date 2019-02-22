package com.sda.java.emag;

public abstract class Item {
    final private String name;
    private Float price;
    final private Category category;

    public Item(String name, Float price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Float getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }
}
