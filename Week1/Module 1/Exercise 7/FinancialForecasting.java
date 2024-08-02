public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // Base Case: If no periods are left, return the present value
        if (periods == 0) {
            return presentValue;
        }
        // Recursive Case: Calculate future value for one period and recurse for remaining periods
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        double presentValue = 1000.0; // Initial amount
        double growthRate = 0.05;     // 5% growth rate
        int periods = 10;             // Number of periods

        double futureValue = calculateFutureValue(presentValue, growthRate, periods);
        System.out.println("Future Value after " + periods + " periods: " + futureValue);
    }
}

