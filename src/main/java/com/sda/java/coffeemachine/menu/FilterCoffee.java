package com.sda.java.coffeemachine.menu;

import com.sda.java.coffeemachine.CoffeeType;

public class FilterCoffee extends Coffee{
    private static final CoffeeType FILTER_COFFEE = CoffeeType.FILTER_COFFEE;

    public FilterCoffee() {
        super(FILTER_COFFEE);
    }

    protected String getCoffeeName() {
        return FILTER_COFFEE.toString();
    }
}