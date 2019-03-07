package com.sda.java.coffeemachine;

public enum CoffeeType {
    ESPRESSO(5, 50, 0, 0),
    LATTE(2, 100, 5, 100),
    FILTER_COFFEE(5, 200, 2, 0);

    private final int beansRequired;
    private final int waterRequired;
    private final int sugarRequired;
    private final int milkRequired;

    CoffeeType(int beansRequired, int waterRequired, int sugarRequired, int milkRequired) {
        this.beansRequired = beansRequired;
        this.waterRequired = waterRequired;
        this.sugarRequired = sugarRequired;
        this.milkRequired = milkRequired;
    }

    public int getBeansRequired() {
        return beansRequired;
    }

    public int getWaterRequired() {
        return waterRequired;
    }

    public int getSugarRequired() {
        return sugarRequired;
    }

    public int getMilkRequired() {
        return milkRequired;
    }
}