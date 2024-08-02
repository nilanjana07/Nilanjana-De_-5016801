public class SortingCustomerOrders {

    // Define the Order class
    public static class Order {
        private String orderId;
        private String customerName;
        private double totalPrice;

        // Constructor
        public Order(String orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        // Getters and Setters
        public String getOrderId() { return orderId; }
        public void setOrderId(String orderId) { this.orderId = orderId; }

        public String getCustomerName() { return customerName; }
        public void setCustomerName(String customerName) { this.customerName = customerName; }

        public double getTotalPrice() { return totalPrice; }
        public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

        @Override
        public String toString() {
            return "OrderID: " + orderId + ", CustomerName: " + customerName + ", TotalPrice: $" + totalPrice;
        }
    }

    // Define sorting algorithms
    public static class SortingAlgorithms {
        // Bubble Sort to sort orders by totalPrice
        public static void bubbleSort(Order[] orders) {
            int n = orders.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - 1 - i; j++) {
                    if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                        // Swap orders[j] and orders[j + 1]
                        Order temp = orders[j];
                        orders[j] = orders[j + 1];
                        orders[j + 1] = temp;
                    }
                }
            }
        }

        // Quick Sort to sort orders by totalPrice
        public static void quickSort(Order[] orders, int low, int high) {
            if (low < high) {
                int pi = partition(orders, low, high);

                // Recursively sort elements before and after partition
                quickSort(orders, low, pi - 1);
                quickSort(orders, pi + 1, high);
            }
        }

        private static int partition(Order[] orders, int low, int high) {
            double pivot = orders[high].getTotalPrice();
            int i = (low - 1); // Index of smaller element
            for (int j = low; j < high; j++) {
                if (orders[j].getTotalPrice() <= pivot) {
                    i++;
                    // Swap orders[i] and orders[j]
                    Order temp = orders[i];
                    orders[i] = orders[j];
                    orders[j] = temp;
                }
            }

            // Swap orders[i + 1] and orders[high] (or pivot)
            Order temp = orders[i + 1];
            orders[i + 1] = orders[high];
            orders[high] = temp;

            return i + 1;
        }
    }

    // Main method to demonstrate sorting functionality
    public static void main(String[] args) {
        Order[] orders = {
            new Order("O001", "Alice", 250.00),
            new Order("O002", "Bob", 150.00),
            new Order("O003", "Charlie", 300.00),
            new Order("O004", "David", 100.00)
        };

        // Bubble Sort
        System.out.println("Bubble Sort:");
        SortingAlgorithms.bubbleSort(orders);
        for (Order order : orders) {
            System.out.println(order);
        }

        // Resetting orders for Quick Sort
        orders = new Order[]{
            new Order("O001", "Alice", 250.00),
            new Order("O002", "Bob", 150.00),
            new Order("O003", "Charlie", 300.00),
            new Order("O004", "David", 100.00)
        };

        // Quick Sort
        System.out.println("\nQuick Sort:");
        SortingAlgorithms.quickSort(orders, 0, orders.length - 1);
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}

