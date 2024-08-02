public class LoggerTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        if (logger1 == logger2) {
            System.out.println("Singleton pattern is working. Both references point to the same instance.");
        } else {
            System.out.println("Singleton pattern failed. Different instances were created.");
        }

        logger1.log("This is a log message.");
    }
}

