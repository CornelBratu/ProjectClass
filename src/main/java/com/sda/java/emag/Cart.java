package com.sda.java.emag;

import com.sda.java.emag.item.Item;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Cart {
    private static final String SEPARATOR = " ";
    private Map<Item, Integer> cartItems;
    private float total;

    public Cart(Map<Item, Integer> cartItems) {
        this.cartItems = cartItems;
    }

    public int addCartItem(Item item, int addQuantity) {
        total += addQuantity * item.getPrice();
        if (cartItems.containsKey(item)) {
            final int updatedQuantity;
            updatedQuantity = cartItems.get(item) + addQuantity;
            cartItems.put(item, updatedQuantity);
        }
        cartItems.put(item, addQuantity);
        return addQuantity;
    }

    public int removeItem(Item item, int removeQuantity) {
        if (!cartItems.containsKey(item)) {
            return 0;
        }
        int currentQuantity = cartItems.get(item);
        if (currentQuantity <= removeQuantity) {
            cartItems.remove(item);
            total -= currentQuantity * item.getPrice();
            return currentQuantity;
        }
        int updatedQuantity = currentQuantity - removeQuantity;
        cartItems.put(item, updatedQuantity);
        total -= removeQuantity * item.getPrice();
        return removeQuantity;
    }

    public Map<Item, Integer> removeAll() {
        final Map<Item, Integer> previousState = cartItems;
        cartItems = new HashMap<>();
        total = 0;
        return previousState;
    }

    public String checkOut() {

        final String processedItems = getItemToString();
        removeAll();
        return processedItems;
    }

    private String getItemToString() {
        return cartItems.entrySet().stream().map(itemEntry -> {
            final Item item = itemEntry.getKey();
            final StringBuilder displayResult = new StringBuilder();
            displayResult.append(item.showDetails());
            displayResult.append(SEPARATOR);
            displayResult.append("Stock: ");
            displayResult.append(itemEntry.getValue());
            return displayResult.toString();
        })
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public void print() throws IOException {
        final FileWriter fileWriter = new FileWriter("print_cart.txt");
        final BufferedWriter bufferedWriter= new BufferedWriter(fileWriter);
        final String processedItems = getItemToString();
        bufferedWriter.write(processedItems);
        bufferedWriter.flush();// Force write on disk.
        bufferedWriter.close();

    }


}
