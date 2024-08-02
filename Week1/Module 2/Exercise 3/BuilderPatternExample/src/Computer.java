public class Computer {
    private final String CPU;
    private final int RAM;
    private final int Storage;
    private final boolean hasGraphicsCard;
    private final boolean hasBluetooth;

    // Private constructor to be used by the Builder
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.Storage = builder.Storage;
        this.hasGraphicsCard = builder.hasGraphicsCard;
        this.hasBluetooth = builder.hasBluetooth;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + "GB, Storage=" + Storage + "GB, Graphics Card=" + (hasGraphicsCard ? "Yes" : "No") + ", Bluetooth=" + (hasBluetooth ? "Yes" : "No") + "]";
    }

    // Static nested Builder class
    public static class Builder {
        private final String CPU; // Required
        private final int RAM; // Required
        private final int Storage; // Required
        private boolean hasGraphicsCard = false; // Optional
        private boolean hasBluetooth = false; // Optional

        // Builder constructor with required parameters
        public Builder(String CPU, int RAM, int Storage) {
            this.CPU = CPU;
            this.RAM = RAM;
            this.Storage = Storage;
        }

        // Optional methods to set optional attributes
        public Builder setGraphicsCard(boolean hasGraphicsCard) {
            this.hasGraphicsCard = hasGraphicsCard;
            return this;
        }

        public Builder setBluetooth(boolean hasBluetooth) {
            this.hasBluetooth = hasBluetooth;
            return this;
        }

        // Method to build and return the Computer instance
        public Computer build() {
            return new Computer(this);
        }
    }
}
