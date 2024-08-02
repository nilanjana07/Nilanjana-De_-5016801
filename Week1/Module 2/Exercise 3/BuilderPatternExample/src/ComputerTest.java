public class ComputerTest {
    public static void main(String[] args) {
        // Create a basic Computer
        Computer basicComputer = new Computer.Builder("Intel i5", 8, 512).build();
        System.out.println(basicComputer);

        // Create a high-end Computer with additional features
        Computer gamingComputer = new Computer.Builder("AMD Ryzen 7", 16, 1024)
                .setGraphicsCard(true)
                .setBluetooth(true)
                .build();
        System.out.println(gamingComputer);
    }
}

