import java.util.Arrays;

public class ECommerceSearchSystem {

    // Defining the Product class
    public static class Product {
        private String productId;
        private String productName;
        private String category;

        // Constructor
        public Product(String productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        // Getters and Setters
        public String getProductId() { return productId; }
        public void setProductId(String productId) { this.productId = productId; }

        public String getProductName() { return productName; }
        public void setProductName(String productName) { this.productName = productName; }

        public String getCategory() { return category; }
        public void setCategory(String category) { this.category = category; }

        @Override
        public String toString() {
            return "ProductID: " + productId + ", Name: " + productName + ", Category: " + category;
        }
    }

    // Defining the SearchAlgorithms class
    public static class SearchAlgorithms {
        // Linear search for a Product by productId
        public static Product linearSearch(Product[] products, String productId) {
            for (Product product : products) {
                if (product.getProductId().equals(productId)) {
                    return product;
                }
            }
            return null; // Product not found
        }

        // Binary search for a Product by productId
        public static Product binarySearch(Product[] products, String productId) {
            int left = 0;
            int right = products.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int comparison = products[mid].getProductId().compareTo(productId);

                if (comparison == 0) {
                    return products[mid];
                } else if (comparison < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return null; // Product not found
        }
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        Product[] products = {
            new Product("P001", "Product A", "Category 1"),
            new Product("P002", "Product B", "Category 2"),
            new Product("P003", "Product C", "Category 1"),
            new Product("P004", "Product D", "Category 3")
        };

        // Linear search
        Product resultLinear = SearchAlgorithms.linearSearch(products, "P003");
        System.out.println("Linear Search Result: " + (resultLinear != null ? resultLinear : "Product not found"));

        // Binary search requires a sorted array
        Arrays.sort(products, (p1, p2) -> p1.getProductId().compareTo(p2.getProductId()));

        // Binary search
        Product resultBinary = SearchAlgorithms.binarySearch(products, "P003");
        System.out.println("Binary Search Result: " + (resultBinary != null ? resultBinary : "Product not found"));
    }
}

