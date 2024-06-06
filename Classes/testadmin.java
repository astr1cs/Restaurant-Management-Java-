package Classes;
import java.util.HashMap;
import java.util.Map;

public class testadmin {
    private Map<String, Double> itemPrices;

    public testadmin() {
        // Initialize itemPrices with default prices
        itemPrices = new HashMap<>();
        itemPrices.put("Big Burger", 280.0);
        itemPrices.put("Spicy Kebab", 220.0);
        // Add more items and their default prices
    }

    // Method to update the price of a specific item
    public void updatePrice(String itemName, double newPrice) {
        itemPrices.put(itemName, newPrice);
    }

    // Getter to retrieve the current prices
    public Map<String, Double> getItemPrices() {
        return itemPrices;
    }
}
