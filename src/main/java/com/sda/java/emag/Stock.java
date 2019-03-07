package com.sda.java.emag;

import com.sda.java.emag.item.Item;

import java.io.*;
import java.util.Map;


public class Stock implements Serializable {
    private final Map<Item, Integer> items;
    private static final String SEPARATOR = " ";


    public Stock(Map<Item, Integer> items) {
        this.items = items;
    }

    public int addItem(Item item, int supplyQuantity) {
        if (items.containsKey(item)) {
            final int supply;
            supply = items.get(item) + supplyQuantity;
            items.put(item, supply);
            return supply;
        }
        items.put(item, supplyQuantity);
        return supplyQuantity;
    }


    public int retrieveItem(Item item, int requestedQuantity) {
        if (!items.containsKey(item)) {
            return 0;
        }
        int currentQuantity = items.get(item);
        if (currentQuantity < requestedQuantity) {
            items.put(item, 0);
            return currentQuantity;
        }
        int updatedQuantity = currentQuantity - requestedQuantity;
        items.put(item, updatedQuantity);
        return requestedQuantity;
    }

    public String showItems() {
        final StringBuilder displayResult = new StringBuilder();
        for (Map.Entry<Item, Integer> itemEntry : items.entrySet()) {
            final Item item = itemEntry.getKey();
            displayResult.append(item.showDetails());
            displayResult.append(SEPARATOR);
            displayResult.append("Stock: ");
            displayResult.append(itemEntry.getValue());
            displayResult.append(System.lineSeparator());

        }
        return displayResult.toString();

    }

    public void saveState() throws IOException {
        final FileOutputStream fileOutputStream = new FileOutputStream("Stock.db");
        final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(this);
        objectOutputStream.close();

    }
    public void loadState() throws IOException {
        final FileInputStream fileInputStream = new FileInputStream("Stock.db");
        final BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        final ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
        //objectInputStream.readObject();
        objectInputStream.close();

    }

    public void getIngredient(String beans) {
    }
}
