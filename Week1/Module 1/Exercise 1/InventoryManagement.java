// Choose a Data Structure:
// For this example, we'll use HashMap to store products for efficient retrieval.
import java.util.HashMap;
import java.util.Map;

public class InventoryManagement {
    private Map<String, Product> inventory = new HashMap<>();

    // Add a product
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    // Update a product
    public void updateProduct(String productId, Product newProduct) {
        if (inventory.containsKey(productId)) {
            inventory.put(productId, newProduct);
        }
    }

    // Delete a product
    public void deleteProduct(String productId) {
        inventory.remove(productId);
    }

    // Retrieve a product
    public Product getProduct(String productId) {
        return inventory.get(productId);
    }
}
