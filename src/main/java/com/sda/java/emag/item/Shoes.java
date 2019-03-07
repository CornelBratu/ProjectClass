package com.sda.java.emag.item;

public class Shoes extends Item{
    private final String brand;
    private final Color color;
    private final int size;


    public Shoes( String name, float price, String brand, Color color, int size) {
        super(Category.FASHION, name, price);
        this.brand = brand;
        this.color = color;
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public Color getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public String showDetails(){
        final StringBuilder displayResult = new StringBuilder();
        displayResult.append(getItemDetails());
        displayResult.append(SEPARATOR);
        displayResult.append(brand);
        displayResult.append(SEPARATOR);
        displayResult.append(color);
        displayResult.append(SEPARATOR);
        displayResult.append(size);
        return displayResult.toString();
    }
}
