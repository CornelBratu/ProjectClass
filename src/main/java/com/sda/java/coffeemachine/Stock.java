package com.sda.java.coffeemachine;

import java.util.HashMap;
import java.util.Map;

public class Stock {
    private Map<Ingredient, Integer> ingredients = new HashMap<>();

    public Stock() {
        for(Ingredient eachIngredient : Ingredient.values()) {
            ingredients.put(eachIngredient, 0);
        }
    }

    public int getIngredient(Ingredient ingredient) throws Exception {
        if (!ingredients.containsKey(ingredient)) {
            throw new Exception("404 Ingredient not found: " + ingredient);
        }
        return ingredients.get(ingredient);
    }

    public void addToStock(String ingredient, int quantity) {
        // beans += quantity;
    }

    public void removeFromStock(String ingredient, int quantity) {
        // beans -= quantity;
    }
}
