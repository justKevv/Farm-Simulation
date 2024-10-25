package farm.player;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {
    private Map<String, Integer> items;

    public Inventory() {
        items = new HashMap<>();
    }

    public void addItem(String itemName, int quantity) {
        items.put(itemName, items.getOrDefault(itemName, 0) + quantity);
    }

    public void removeItem(String itemName, int quantity) {
        if (items.containsKey(itemName)) {
            int currentQuantity = items.get(itemName);
            if (currentQuantity >= quantity) {
                items.put(itemName, currentQuantity - quantity);
                if (items.get(itemName) == 0) {
                    items.remove(itemName);
                }
            } else {
                System.out.println("Not enough " + itemName + " to sell.");
            }
        } else {
            System.out.println(itemName + " not found in inventory.");
        }
    }

    public void displayInventory() {
        if (items.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            for (Map.Entry<String, Integer> entry : items.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
    public boolean hasItem(String itemName) {
        return items.containsKey(itemName);
    }
}
