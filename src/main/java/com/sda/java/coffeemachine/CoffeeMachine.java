package com.sda.java.coffeemachine;

import com.sda.java.coffeemachine.menu.Coffee;
import com.sda.java.coffeemachine.menu.Espresso;
import com.sda.java.coffeemachine.menu.FilterCoffee;
import com.sda.java.coffeemachine.menu.Latte;

public class CoffeeMachine {
    private final Stock stock = new Stock();
    private CoffeeType coffeeType = CoffeeType.FILTER_COFFEE;

    public static void main(String[] args) throws Exception {
        final CoffeeMachine coffeeMachine = new CoffeeMachine();
        Stock stock = coffeeMachine.getStock();
        stock.getIngredient("Beans");

        // User selects coffee type
        coffeeMachine.chooseCoffee(CoffeeType.LATTE);

        // User presses START
        final Coffee coffee = coffeeMachine.prepareCoffee();
        System.out.println("Consuming the coffee: " + coffee);
    }

    public void chooseCoffee(CoffeeType coffeeType) {
        // TODO: add check if credit is sufficient and show message
        this.coffeeType = coffeeType;
    }

    // Detachable stock: can retrieve the stock and operate it independently
    public Stock getStock() {
        return stock;
    }

//    // Forwarding
//    public void removeFromStock(int quantity) {
//        stock.removeBeansFromStock(quantity);
//    }

    public Coffee prepareCoffee() throws Exception {
        if (stock.getBeans() >= coffeeType.getBeansRequired()) {
            stock.removeBeansFromStock(coffeeType.getBeansRequired());
            return createCoffee();
        }
        throw new Exception("Cannot create coffee");
    }

    private Coffee createCoffee() {
        switch (coffeeType) {
            case LATTE:
                return new Latte();
            case ESPRESSO:
                return new Espresso();
            case FILTER_COFFEE:
                return new FilterCoffee();
            default:
                return new FilterCoffee();
        }
    }
}